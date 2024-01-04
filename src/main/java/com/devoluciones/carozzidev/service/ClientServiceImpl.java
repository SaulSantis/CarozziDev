package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.Client;
import com.devoluciones.carozzidev.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository IClientRepository;
    @Autowired
    public ClientServiceImpl(IClientRepository IClientRepository) {
        this.IClientRepository = IClientRepository;
    }

    @Override
    public List<Client> clientList() {
        return IClientRepository.findAll();
    }

    @Override
    public List<Client> findClientByName(String clientName) {
        return IClientRepository.findByClientNameContainingIgnoreCase(clientName);
    }

    @Override
    public List<Client> findClientByRut(String clientRut) {
        return IClientRepository.findByClientRutContainingIgnoreCase(clientRut);
    }

    @Override
    public Client saveClient(Client client) {
        return IClientRepository.save(client);
    }

    @Override
    public List<Client> saveClientList(List<Client> clients) {
        return IClientRepository.saveAll(clients);
    }

    @Override
    public void deleteClient(Long clientId) {
        IClientRepository.deleteById(clientId);
    }
}
