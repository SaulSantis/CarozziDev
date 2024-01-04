package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.Client;

import java.util.List;


public interface IClientService {

    List<Client> clientList();

    List<Client> findClientByName(String clientName);

    List<Client> findClientByRut(String clientRut);

    Client saveClient(Client client);

    List<Client> saveClientList(List<Client> clients);

    void deleteClient(Long Client);


}
