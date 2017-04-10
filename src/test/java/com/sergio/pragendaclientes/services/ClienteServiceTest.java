package com.sergio.pragendaclientes.services;

import com.sergio.pragendaclientes.daos.ClienteDAO;
import com.sergio.pragendaclientes.models.Cliente;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private static final int ID = 1;

    @Injectable
    ClienteDAO clienteDAO;

    @Tested
    private ClienteService clienteService;

    @Before
    public void setUp() {
        clienteService = new ClienteServiceImpl();
    }

    @After
    public void tearDown() {
        clienteService = null;
    }

    @Test
    public void isGetAllRunningDAOOneTime() {
        clienteService.getAll();

        new Verifications() {{
            clienteDAO.findAll(); times = 1;
        }};
    }
    
    @Test
    public void isDeleteClienteRunningDAOOneTime() {
        clienteService.deleteCliente(ID);
        
        new Verifications() {{
            clienteDAO.delete(anyInt); times = 1;
        }};
    }

    @Test
    public void isFindClienteRunningDAOOneTime() {
        clienteService.findCliente(ID);

        new Verifications() {{
            clienteDAO.findOne(anyInt); times = 1;
        }};
    }
    
    @Test
    public void isAddClienteRunningDAOOneTime(@Injectable Cliente cliente) {
        clienteService.addCliente(cliente);
        
        new Verifications() {{
            clienteDAO.save(cliente); times = 1;
        }};
    }

}
