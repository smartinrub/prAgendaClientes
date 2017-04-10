package com.sergio.pragendaclientes.controllers;

import com.sergio.pragendaclientes.models.Pedido;
import com.sergio.pragendaclientes.services.PedidoService;
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
@RequestMapping("/pedidos")
public class PedidoController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{idCliente}")
    public ResponseEntity<List<Pedido>> pedidos(
            @PathVariable("idCliente") Integer idCliente) {
        List<Pedido> pedidos = pedidoService.getAllByClienteId(idCliente);
        if (pedidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        LOGGER.info("Devolviendo lista de pedidos");
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/{idCliente}")
    public ResponseEntity addPedido(
            @PathVariable("idCliente") Integer idCliente,
            @RequestBody Pedido pedido,
            UriComponentsBuilder ucBuilder) {
        LOGGER.info("Guardando pedido "
                + pedido.getProducto() + " del cliente " + idCliente);
        pedidoService.addPedido(idCliente, pedido);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/pedidos/{idCliente}")
                .buildAndExpand(pedido.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{idCliente}/{idPedido}")
    public ResponseEntity deletePedido(
            @PathVariable("idCliente") Integer idCliente,
            @PathVariable("idPedido") Integer idPedido) {
        LOGGER.info("Recogiendo y Eliminando Pedido "
                + idPedido + " del Cliente con id " + idCliente);

        Pedido pedido = pedidoService.findPedido(idPedido);
        if (pedido == null) {
            LOGGER.error("Error al eliminar pedido. Pedido con id "
                    + idPedido + " no ha sido encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al eliminar pedido con id " + idPedido);
        }

        pedidoService.deletePedido(idPedido);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pedido "
                + idPedido + "eliminado con exito");
    }

}
