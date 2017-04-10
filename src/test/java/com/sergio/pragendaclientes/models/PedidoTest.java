package com.sergio.pragendaclientes.models;

import java.util.Date;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoTest {
    
    private static final Integer ID = 1;
    private static final Date FECHA = new Date();
    private static final String PRODUCTO = "producto";
    private static final Double PRECIO = 9.99;
    private static final Double DTO = 0.01;
    private static final Double AC = 12.5;
    private static final Boolean COBRADO = true;
    
    private Cliente cliente = new Cliente();
    
    private Pedido pedido;
    
    @Before
    public void setUp() {
        pedido = new Pedido();
    }
    
    @After
    public void tearDown() {
        pedido = null;
    }
    
    @Test
    public void isClienteNotNull() {
        assertThat(pedido, is(notNullValue()));
    }
    
    @Test
    public void isIdRight() {
        pedido.setId(ID);
        assertThat(pedido.getId(), is(equalTo(ID)));
    }
    
    @Test
    public void isFechaRight() {
        pedido.setFecha(FECHA);
        assertThat(pedido.getFecha(), is(equalTo(FECHA)));
    }
    
    @Test
    public void isProductoRight() {
        pedido.setProducto(PRODUCTO);
        assertThat(pedido.getProducto(), is(equalTo(PRODUCTO)));
    }
    
    @Test
    public void isPrecioRight() {
        pedido.setPrecio(PRECIO);
        assertThat(pedido.getPrecio(), is(equalTo(PRECIO)));
    }
    
    @Test
    public void isDtoRight() {
        pedido.setDto(DTO);
        assertThat(pedido.getDto(), is(equalTo(DTO)));
    }
    
    @Test
    public void isAcRight() {
        pedido.setAc(AC);
        assertThat(pedido.getAc(), is(equalTo(AC)));
    }
    
    @Test
    public void isCobradoRight() {
        pedido.setCobrado(COBRADO);
        assertThat(pedido.getCobrado(), is(equalTo(COBRADO)));
    }
    
    @Test
    public void isClienteRight() {
        pedido.setCliente(cliente);
        assertThat(pedido.getCliente(), is(equalTo(cliente)));
    }
    
    @Test
    public void isEqualsReturningTrueWhenTheyAreEquals() {
        Pedido p1 = new Pedido(ID, FECHA, PRODUCTO);
        Pedido p2 = new Pedido(ID, FECHA, PRODUCTO);
        assertThat(p1.equals(p2), is(true));
    }
    
    @Test
    public void isEqualsReturningFalseWhenTheyAreNotEquals() {
        Pedido p1 = new Pedido(ID, FECHA, PRODUCTO);
        Pedido p2 = new Pedido(2, FECHA, PRODUCTO);
        assertThat(p1.equals(p2), is(false));
    }
    
    @Test
    public void isHashCodeTheSame() {
        Pedido p1 = new Pedido(ID, FECHA, PRODUCTO);
        Pedido p2 = new Pedido(ID, FECHA, PRODUCTO);
        assertTrue(p1.hashCode() == p2.hashCode());
    }
    
    @Test
    public void isToStringWorkingProperly() {
        Pedido p = new Pedido(ID);
        p.setFecha(FECHA);
        p.setProducto(PRODUCTO);
        p.setPrecio(PRECIO);
        p.setDto(DTO);
        p.setAc(AC);
        p.setCobrado(COBRADO);
        p.setCliente(cliente);
        assertThat(p.toString(), containsString("id=1"));
    }
}
