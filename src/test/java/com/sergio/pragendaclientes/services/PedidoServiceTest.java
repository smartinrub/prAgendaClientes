package com.sergio.pragendaclientes.services;

import com.sergio.pragendaclientes.daos.ClienteDAO;
import com.sergio.pragendaclientes.daos.PedidoDAO;
import com.sergio.pragendaclientes.models.Cliente;
import com.sergio.pragendaclientes.models.Pedido;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PedidoServiceTest {
    
    private static final int ID = 1;
    
    @Injectable PedidoDAO pedidoDAO;
    @Injectable ClienteDAO clienteDAO;
    
    @Tested private PedidoService pedidoService;
    
    @Before
    public void setUp() {
        pedidoService = new PedidoServiceImpl();
    }
    
    @After
    public void tearDown() {
        pedidoService = null;
    }
    
    @Test
    public void isGetAllClienteByIdRunningDAOOneTime() {
        
        pedidoService.getAllByClienteId(ID);
        
        new Verifications() {{
            pedidoDAO.getAllByClienteId(anyInt); times = 1;
        }};
    }
    
    @Test
    public void isAddPedidoRunningDAOOneTime(
            @Injectable Pedido pedido, 
            @Injectable Cliente cliente) {
        pedidoService.addPedido(ID, pedido);
        
        new Verifications() {{
            pedido.setCliente(cliente); times = 1;
            cliente.addPedido(pedido); times = 1;
            clienteDAO.save(cliente); times = 1;
        }};
    }
    
    @Test
    public void isFindPedidoRunningDAOOneTime() {
        pedidoService.findPedido(ID);
        
        new Verifications() {{
            pedidoDAO.findOne(anyInt); times = 1;
        }};
    }
    
    @Test
    public void isDeletePedidoRunningDAOOneTime() {
        pedidoService.deletePedido(ID);
        
        new Verifications() {{
            pedidoDAO.delete(anyInt); times = 1;
        }};
    }
    
}
