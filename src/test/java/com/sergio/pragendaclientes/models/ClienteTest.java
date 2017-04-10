package com.sergio.pragendaclientes.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ClienteTest {

    private static final Integer ID = 1;
    private static final String NOMBRE = "Sergio";
    private static final String TELEFONO = "123456789";
    private static final String DIRECCION = "mi casa";
    private static final String EMAIL = "a@a.com";
    private static final Boolean CONTACTO_FRIO = true;
    private static final Boolean REFERENCIA = true;
    private static final Boolean RECIBIO_CMCP = false;
    private static final Boolean FUE_ANFITRIONA = false;
    private static final Boolean SESION_COLOR = true;
    private static final Boolean SESION_FRAGANCIAS = false;
    private static final Boolean COMPARTI_OPORTUNIDAD = true;
    private static final Boolean ASISTIO_EVENTO = false;
    private static final String PERSONALIDAD = "social";
    private static final String OBSERVACIONES = "nada";

    private Cliente dummyCliente;

    public ClienteTest() {
    }

    @Before
    public void setUp() {
        dummyCliente = new Cliente();
    }

    @After
    public void tearDown() {
        dummyCliente = null;
    }

    @Test
    public void isClienteNotNull() {
        assertThat(dummyCliente, is(notNullValue()));
    }

    @Test
    public void isIdRight() {
        dummyCliente.setId(ID);
        assertThat(ID, is(equalTo(dummyCliente.getId())));
    }

    @Test
    public void isNombreRight() {
        dummyCliente.setNombre(NOMBRE);
        assertThat(NOMBRE, is(equalTo(dummyCliente.getNombre())));
    }

    @Test
    public void isTelefonoRight() {
        dummyCliente.setTelefono(TELEFONO);
        assertThat(TELEFONO, is(equalTo(dummyCliente.getTelefono())));
    }

    @Test
    public void isDireccionRight() {
        dummyCliente.setDireccion(DIRECCION);
        assertThat(DIRECCION, is(equalTo(dummyCliente.getDireccion())));
    }

    @Test
    public void isEmailRight() {
        dummyCliente.setEmail(EMAIL);
        assertThat(EMAIL, is(equalTo(dummyCliente.getEmail())));
    }

    @Test
    public void isContactoFrioRight() {
        dummyCliente.setContactoFrio(CONTACTO_FRIO);
        assertThat(CONTACTO_FRIO, is(equalTo(dummyCliente.getContactoFrio())));
    }

    @Test
    public void isReferenciaRight() {
        dummyCliente.setReferencia(REFERENCIA);
        assertThat(REFERENCIA, is(equalTo(dummyCliente.getReferencia())));
    }

    @Test
    public void isRecibioCmcpRight() {
        dummyCliente.setRecibioCmcp(RECIBIO_CMCP);
        assertThat(RECIBIO_CMCP, is(equalTo(dummyCliente.getRecibioCmcp())));
    }

    @Test
    public void isFueAnfitrionaRight() {
        dummyCliente.setFueAnfitriona(FUE_ANFITRIONA);
        assertThat(FUE_ANFITRIONA, is(equalTo(dummyCliente.getFueAnfitriona())));
    }

    @Test
    public void isSesionColorRight() {
        dummyCliente.setSesionColor(SESION_COLOR);
        assertThat(SESION_COLOR, is(equalTo(dummyCliente.getSesionColor())));
    }

    @Test
    public void isSesionFraganciasRight() {
        dummyCliente.setSesionFragancias(SESION_FRAGANCIAS);
        assertThat(SESION_FRAGANCIAS, is(equalTo(dummyCliente.getSesionFragancias())));
    }

    @Test
    public void isCompartiOportunidadRight() {
        dummyCliente.setCompartiOportunidad(COMPARTI_OPORTUNIDAD);
        assertThat(COMPARTI_OPORTUNIDAD, is(equalTo(dummyCliente.getCompartiOportunidad())));
    }

    @Test
    public void isAsistioEventoRight() {
        dummyCliente.setAsistioEvento(ASISTIO_EVENTO);
        assertThat(ASISTIO_EVENTO, is(equalTo(dummyCliente.getAsistioEvento())));
    }

    @Test
    public void isPersonalidadRight() {
        dummyCliente.setPersonalidad(PERSONALIDAD);
        assertThat(PERSONALIDAD, is(equalTo(dummyCliente.getPersonalidad())));
    }

    @Test
    public void isObservacionesRight() {
        dummyCliente.setObservaciones(OBSERVACIONES);
        assertThat(OBSERVACIONES, is(equalTo(dummyCliente.getObservaciones())));
    }

}
