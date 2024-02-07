package com.devoluciones.carozzidev.service.impl;

import com.devoluciones.carozzidev.model.entity.Client;
import com.devoluciones.carozzidev.model.repository.IClientRepository;
import com.devoluciones.carozzidev.service.IClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientImpl implements IClientService {

    @Autowired
    private IClientRepository iClientRepository;

    @Override
    public List<Client> clientList() {
        return iClientRepository.findAll();
    }

    @Override
    public List<Client> saveAll(List<Client> clients) {
        return iClientRepository.saveAll(clients);
    }

    @Override
    public List<Client> findClientByName(String clientName) {
        return iClientRepository.findByClientNameContainingIgnoreCase(clientName);
    }

    @Override
    public List<Client> findClientByRut(String clientRut) {
        return iClientRepository.findByClientRutContainingIgnoreCase(clientRut);
    }

    @Override
    public Client save(Client client) {
        return iClientRepository.save(client);
    }

    @Override
    public Client findById(Long clientId) {
        return iClientRepository.findById(clientId).orElse(null);
    }

    @Override
    public Client delete(Long clientId) {
        Client client = iClientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + clientId));
        iClientRepository.delete(client);
        return client;
    }

    @Override
    public boolean existsById(Long clientId) {
        Optional<Client> optionalClient = iClientRepository.findById(clientId);
        return optionalClient.isPresent();
    }


}