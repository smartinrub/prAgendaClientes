package com.sergio.pragendaclientes.controllers;

import com.sergio.pragendaclientes.models.Pedido;
import com.sergio.pragendaclientes.services.PedidoService;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PedidoController.class)
@WithMockUser
public class PedidoControllerTest {
    
    private static final int ID_CLIENTE = 1;
    private static final int ID_PEDIDO = 10;
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoService pedidoService;
    
    @Test
    public void isPedidosReturningOkResponseWhenListNotEmpty()
            throws Exception {

        given(pedidoService.getAllByClienteId(1))
                .willReturn(Arrays.asList(new Pedido()));

        mockMvc.perform(get("/pedidos/" + ID_CLIENTE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void isPedidosReturningNoContentResponseWhenListEmpty()
            throws Exception {

        mockMvc.perform(get("/pedidos/" + ID_CLIENTE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
    
//    @Test
//    public void isAddPedidoReturningCreatedResponse() throws Exception{
//        mockMvc.perform(post("/pedidos/" + ID_CLIENTE))
//                .andExpect(status().isOk());
//    }
    
    @Test
    public void isDeletePedidoReturningNoContentResponse() throws Exception {
        
        Pedido pedido = new Pedido(ID_PEDIDO);
        
        given(pedidoService.findPedido(ID_PEDIDO)).willReturn(pedido);

        mockMvc.perform(delete("/pedidos/" + ID_CLIENTE + "/" + ID_PEDIDO)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().string("Pedido " 
                        + ID_PEDIDO + "eliminado con exito"));
    }
    
    @Test
    public void isDeletePedidoReturningNotFoundWhenPedidoDoesNotExistResponse()
            throws Exception {
       
        mockMvc.perform(delete("/pedidos/" + ID_CLIENTE + "/" + ID_PEDIDO)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Error al eliminar pedido con id 10"));
    }
    
}
