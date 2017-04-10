package com.sergio.pragendaclientes.services;

import com.sergio.pragendaclientes.models.Cliente;
import java.util.List;

public interface ClienteService {
    
    public List<Cliente> getAll();
    
    public Cliente findCliente(Integer id);
    
    public void addCliente(Cliente cliente);
    
    public void deleteCliente(Integer id);
        
}
