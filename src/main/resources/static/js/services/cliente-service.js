'use strict';

angular.module('app').factory('clienteFactory', ['$resource', function ($resource) {

        var REST_SERVICE_URI = 'http://localhost:8880/clientes/';
        
        var funciones = {
            getAllClientes: getAllClientes,
            getCliente: getCliente,
            addCliente: addCliente,
            deleteCliente: deleteCliente
        };

        return funciones;

        function getAllClientes() {
            return $resource(REST_SERVICE_URI);
        }

        function getCliente() {
            return $resource(REST_SERVICE_URI + ":id");
        }

        function addCliente() {
            return $resource(REST_SERVICE_URI);
        }

        function deleteCliente() {
            return $resource(REST_SERVICE_URI + ":id");
        }
    }]);