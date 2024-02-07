package com.devoluciones.carozzidev.model.repository;

import com.devoluciones.carozzidev.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByClientNameContainingIgnoreCase(String clientName);

    List<Client> findByClientRutContainingIgnoreCase(String clientRut);

    Client findByClientName(String clientName);

    Client findByClientRut(String clientRut);
    List<Client> findByClientNameContainingIgnoreCaseOrClientRutContainingIgnoreCase(String clientName, String clientRut);
}