package com.sergio.pragendaclientes.controllers;

import com.sergio.pragendaclientes.models.Cliente;
import com.sergio.pragendaclientes.services.ClienteService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private static final Logger LOGGER = 
            LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> clientes() {
        LOGGER.info("Devolviendo lista de clientes");
        List<Cliente> clientes = clienteService.getAll();
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable("id") Integer id) {
        LOGGER.info("Recogiendo Cliente con id " + id);
        return clienteService.findCliente(id);
    }
    
    @PostMapping
    public ResponseEntity addCliente(@RequestBody Cliente cliente, 
            UriComponentsBuilder ucBuilder) {
        LOGGER.info("Guardando cliente " + cliente.getNombre());
        clienteService.addCliente(cliente);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/clientes/{id}")
                .buildAndExpand(cliente.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") Integer id) {
        LOGGER.info("Recogiendo y Eliminando Cliente con id " + id);

        Cliente cliente = clienteService.findCliente(id);
        if (cliente == null) {
            LOGGER.error("Error al eliminar cliente. Cliente con id " 
                    + id + " no ha sido encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al eliminar cliente con id " + id);
        }
        clienteService.deleteCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Cliente " + id + "eliminado con exito");
    }

}
