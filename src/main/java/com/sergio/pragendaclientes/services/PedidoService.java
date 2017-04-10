package com.sergio.pragendaclientes.services;

import com.sergio.pragendaclientes.models.Pedido;
import java.util.List;

public interface PedidoService {
    
    public List<Pedido> getAllByClienteId(Integer idCliente);
    
    public Pedido findPedido(Integer idPedido);
    
    public void addPedido(Integer idCliente, Pedido pedido);
    
    public void deletePedido(Integer idPedido);
}
