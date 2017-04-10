'use strict';

angular.module('app').factory('pedidoFactory', ['$resource', function ($resource) {

        var REST_SERVICE_URI = 'http://localhost:8880/pedidos/';

        var funciones = {
        getAllPedidosByClienteId: getAllPedidosByClienteId,
            addPedido: addPedido,
            deletePedido: deletePedido
        };

        return funciones;

        function getAllPedidosByClienteId() {
            return $resource(REST_SERVICE_URI + ":id");
        }

        function addPedido() {
            return $resource(REST_SERVICE_URI + ":id");
        }

        function deletePedido() {
            return $resource(REST_SERVICE_URI + ":id/:idPedido");
        }

    }]);