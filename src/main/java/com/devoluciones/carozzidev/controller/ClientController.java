package com.devoluciones.carozzidev.controller;

import com.devoluciones.carozzidev.model.Client;
import com.devoluciones.carozzidev.repository.IClientRepository;
import com.devoluciones.carozzidev.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientServiceImpl;
    @Autowired
    private IClientRepository IClientRepository;


    // Obtener todos los clientes
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientServiceImpl.clientList();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // Guardar un nuevo cliente
    @PostMapping("/save")
    public Client saveClient(@RequestBody Client client) {
        return clientServiceImpl.saveClient(client);
    }

    // Guardar una lista de clientes
    @PostMapping("/save-list")
    public List<Client> saveClientList(@RequestBody List<Client> clients) {
        return clientServiceImpl.saveClientList(clients);
    }

    // Obtener clientes por nombre
    @GetMapping("/by-name")
    public List<Client> getClientesPorNombre(@RequestParam String clientName) {
        return IClientRepository.findByClientNameContainingIgnoreCase(clientName);
    }

    // Obtener clientes por RUT (Rol Único Tributario)
    @GetMapping("/by-rut")
    public List<Client> getClientesPorRut(@RequestParam String clientRut) {
        return IClientRepository.findByClientRutContainingIgnoreCase(clientRut);
    }

    // Actualizar un cliente existente
    @PatchMapping("/update/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        // Verifica si el cliente existe
        if (!IClientRepository.existsById(clientId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Actualiza el cliente
        updatedClient.setClientId(clientId);
        Client clienteActualizado = clientServiceImpl.saveClient(updatedClient);

        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }

    // Eliminar un cliente
    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
        // Verifica si el cliente existe
        if (!IClientRepository.existsById(clientId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Elimina el cliente
        clientServiceImpl.deleteClient(clientId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
