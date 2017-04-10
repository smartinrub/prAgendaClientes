
package com.sergio.pragendaclientes.daos;

import com.sergio.pragendaclientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAO extends JpaRepository<Cliente, Integer>{
}
