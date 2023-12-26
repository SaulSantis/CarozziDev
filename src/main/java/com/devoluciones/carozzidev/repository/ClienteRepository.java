package com.devoluciones.carozzidev.repository;

import com.devoluciones.carozzidev.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombreClienteContainingIgnoreCase(String nombreCliente);
    List<Cliente> findByRutClienteContainingIgnoreCase(String rutCliente);

}
