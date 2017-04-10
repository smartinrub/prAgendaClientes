'use strict';

angular.module('app').controller('PedidoController', ['pedidoFactory', '$routeParams', '$scope', function (pedidoFactory, $routeParams, $scope) {

        var self = this;

        self.pedido = {id: null, fecha: '', producto: '', precio: null,
            dto: null, ac: null, cobrado: false};
        self.pedidos = [];

        self.idCliente = $routeParams.id;

        getAllPedidosByClienteId(self.idCliente);

        self.enviar = enviar;
        self.editar = editar;
        self.remove = remove;
        self.limpiar = limpiar;

        function getAllPedidosByClienteId(id) {
//            console.log("Devolviendo lista de pedidos del cliente " + id);
            self.pedidos = pedidoFactory.getAllPedidosByClienteId()
                    .query({id: id});
        }

        function addPedido(pedido) {
            pedidoFactory.addPedido()
                    .save({id: self.idCliente}, pedido)
                    .$promise.then(function () {
                        getAllPedidosByClienteId($routeParams.id);
                    });
        }

        function deletePedido(idPedido) {

            pedidoFactory.deletePedido()
                    .delete({id: self.idCliente, idPedido: idPedido})
                    .$promise.then(function () {
                        getAllPedidosByClienteId($routeParams.id);
                    });
        }

        function enviar() {
//            console.log('Guardando el pedido', vm.pedido);
            addPedido(self.pedido);
            limpiar();
        }

        function editar(idPedido) {
//            console.log('Se editara el pedido ', idPedido);
            for (var i = 0; i < self.pedidos.length; i++) {
                if (self.pedidos[i].id === idPedido) {
                    self.pedido = angular.copy(self.pedidos[i]);
                    break;
                }
            }
        }

        function remove(idPedido) {
//            console.log("Eliminando pedido con id " + idPedido);
            if (self.pedido.id === idPedido) {
                limpiar();
            }
            deletePedido(idPedido);
        }

        function limpiar() {
            self.pedido = {id: null, fecha: '', producto: '', precio: null,
                dto: null, ac: null, cobrado: false};
            $scope.formulario.$setPristine();
        }

    }]);