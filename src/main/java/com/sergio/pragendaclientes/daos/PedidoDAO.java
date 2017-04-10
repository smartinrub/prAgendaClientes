package com.sergio.pragendaclientes.daos;

import com.sergio.pragendaclientes.models.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoDAO extends JpaRepository<Pedido, Integer>{
    
    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :idCliente")
    public List<Pedido> getAllByClienteId(@Param("idCliente") Integer idCliente);    
    
}
