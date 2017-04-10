package com.sergio.pragendaclientes.controllers;

import com.sergio.pragendaclientes.models.Cliente;
import com.sergio.pragendaclientes.services.ClienteService;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.security.test.context.support.WithMockUser;

@RunWith(SpringRunner.class)
@WebMvcTest(ClienteController.class)
@WithMockUser
public class ClienteControllerTest {
    
    private static final int ID_CLIENTE = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void isClientesReturningOkResponseWhenListNotEmpty()
            throws Exception {

        given(clienteService.getAll())
                .willReturn(Arrays.asList(new Cliente(ID_CLIENTE)));

        mockMvc.perform(get("/clientes")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void isClientesReturningNoContentResponseWhenListEmpty()
            throws Exception {
        mockMvc.perform(get("/clientes")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void isGetClienteReturningOkResponse() throws Exception {
        mockMvc.perform(get("/clientes/" + ID_CLIENTE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }


    @Test
    public void isDeleteClienteReturningNoContentResponse()
            throws Exception {

        Cliente cliente = new Cliente(ID_CLIENTE);

        given(clienteService.findCliente(ID_CLIENTE)).willReturn(cliente);

        mockMvc.perform(delete("/clientes/" + ID_CLIENTE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().string("Cliente " + ID_CLIENTE + "eliminado con exito"));
    }
    
    @Test
    public void isDeleteClienteReturningNotFoundWhenCilenteDoesNotExistResponse()
            throws Exception {

        mockMvc.perform(delete("/clientes/" + ID_CLIENTE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Error al eliminar cliente con id " 
                        + ID_CLIENTE));
    }

}
