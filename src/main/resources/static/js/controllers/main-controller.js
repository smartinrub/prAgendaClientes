'use strict';

angular.module('app').controller('MainController', ['clienteFactory', function (clienteFactory) {

        var self = this;

        self.cliente = {id: null, nombre: '', telefono: '', direccion: '',
            email: '', contactoFrio: false, referencia: false, recibioCmcp: false,
            fueAnfitriona: false, sesionColor: false, sesionFragancias: false,
            compartiOportunidad: false, asistioEvento: false, personalidad: 'social',
            observaciones: ''};
        self.clientes = [];

        getAllClientes();

        function getAllClientes() {
//            console.log("Devolviendo lista de clientes");
            self.clientes = clienteFactory.getAllClientes().query();
        }

    }]);