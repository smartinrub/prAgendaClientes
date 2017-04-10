package com.sergio.pragendaclientes.services;

import com.sergio.pragendaclientes.daos.ClienteDAO;
import com.sergio.pragendaclientes.daos.PedidoDAO;
import com.sergio.pragendaclientes.models.Cliente;
import com.sergio.pragendaclientes.models.Pedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> getAllByClienteId(Integer idCliente) {
        return pedidoDAO.getAllByClienteId(idCliente);
    }

    @Override
    @Transactional
    public void addPedido(Integer idCliente, Pedido pedido) {
        Cliente cliente = clienteDAO.findOne(idCliente);
        pedido.setCliente(cliente);
        cliente.addPedido(pedido);

        clienteDAO.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido findPedido(Integer idPedido) {
        return pedidoDAO.findOne(idPedido);
    }

    @Override
    @Transactional
    public void deletePedido(Integer idPedido) {
        pedidoDAO.delete(idPedido);
    }

}
