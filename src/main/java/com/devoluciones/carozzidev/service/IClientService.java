package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.entity.Client;

import java.util.List;

public interface IClientService {

    List<Client> clientList();

    List<Client> saveAll(List<Client> clients);

    List<Client> findClientByName(String clientName);

    List<Client> findClientByRut(String clientRut);

    Client save(Client client);

    Client findById(Long clientId);

    Client delete(Long clientId);


    boolean existsById(Long clientId);
}
