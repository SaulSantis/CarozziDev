package com.devoluciones.carozzidev.repository;

import com.devoluciones.carozzidev.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByClientNameContainingIgnoreCase(String clientName);

    List<Client> findByClientRutContainingIgnoreCase(String clientRut);

    void deleteById(Long clientId);

    Client findByClientName(String clientName);
}
