'use strict';

angular.module('app').controller('ClienteController', ['$scope', '$location', 'clienteFactory', '$routeParams',
    function ($scope, $location, clienteFactory, $routeParams) {
        var self = this;

        self.cliente = {id: null, nombre: '', telefono: '', direccion: '',
            email: '', contactoFrio: false, referencia: false, recibioCmcp: false,
            fueAnfitriona: false, sesionColor: false, sesionFragancias: false,
            compartiOportunidad: false, asistioEvento: false, personalidad: 'social',
            observaciones: ''};

        self.enviar = enviar;
        self.deleteCliente = deleteCliente;
        self.limpiar = limpiar;

        self.titulo = "Nuevo Cliente";

        if ($routeParams.id !== undefined) {
            self.titulo = "Detalles Cliente";
            getCliente($routeParams.id);
        }

        function addCliente(cliente) {
            clienteFactory.addCliente().save(cliente).$promise.then(function () {
                $location.path('/main');
            });
        }

        function getCliente(id) {
//            console.log("Buscando cliente con id " + id);
            self.cliente = clienteFactory.getCliente().get({id: id});
        }

        function enviar() {
//            console.log('Guardando cliente', vm.cliente);
            addCliente(self.cliente);
        }

        function deleteCliente(id) {
//            console.log("Eliminando cliente con id: " + id);
            clienteFactory.deleteCliente().delete({id: id})
                    .$promise.then(function () {
                        $location.path('/main');
                    });
        }

        function limpiar() {
            self.cliente = {id: null, nombre: '', telefono: '', direccion: '',
                email: '', contactoFrio: false, referencia: false, recibioCmcp: false,
                fueAnfitriona: false, sesionColor: false, sesionFragancias: false,
                compartiOportunidad: false, asistioEvento: false, personalidad: 'social',
                observaciones: ''};
            $scope.formulario.$setPristine();
        }
    }]);