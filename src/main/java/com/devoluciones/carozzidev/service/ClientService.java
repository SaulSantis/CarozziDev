package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.Client;
import com.devoluciones.carozzidev.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> clientList() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findClientByName(String clientName) {
        return clientRepository.findByClientNameContainingIgnoreCase(clientName);
    }

    @Override
    public List<Client> findClientByRut(String clientRut) {
        return clientRepository.findByClientRutContainingIgnoreCase(clientRut);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> saveClientList(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
