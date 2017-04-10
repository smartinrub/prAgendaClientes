package com.sergio.pragendaclientes.services;

import com.sergio.pragendaclientes.daos.ClienteDAO;
import com.sergio.pragendaclientes.models.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAll() {
        return clienteDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteCliente(Integer id) {
        clienteDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findCliente(Integer id) {
        return clienteDAO.findOne(id);
    }

    @Override
    @Transactional
    public void addCliente(Cliente cliente) {
        clienteDAO.save(cliente);
    }

}
