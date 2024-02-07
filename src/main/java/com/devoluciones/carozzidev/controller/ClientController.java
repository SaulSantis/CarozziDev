package com.devoluciones.carozzidev.controller;

import com.devoluciones.carozzidev.model.entity.Client;
import com.devoluciones.carozzidev.model.repository.IClientRepository;
import com.devoluciones.carozzidev.service.IClientService;
import com.devoluciones.carozzidev.service.impl.ClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientImpl clientImpl;

    @Autowired
    private IClientService IClientService;

    @Autowired
    private IClientRepository IClientRepository;

    // Obtener todos los clientes
    @GetMapping("/clients")
    public String showClientes(Model model) {
        model.addAttribute("clients", IClientService.clientList());
        return "plantillaCliente";  // "clientes" se refiere al nombre del archivo HTML en src/main/resources/templates
    }

    // Guardar una lista de clientes
    @PostMapping("/clients")
    public ResponseEntity<List<Client>> saveClientList(@RequestBody List<Client> clients) {
        List<Client> savedClients = clientImpl.saveAll(clients);
        return new ResponseEntity<>(savedClients, HttpStatus.CREATED);
    }

    // Guardar un nuevo cliente
    @PostMapping("/client")
    public String saveClients(@RequestBody Client client, Model model) {
        Client savedClient = IClientService.save(client);
        model.addAttribute("client", savedClient);
        return "plantillaCliente";
    }

    // Obtener clientes por nombre o por rut
    @GetMapping("/clients/searchByNameOrRut")
    public String searchClientsByNameOrRut(@RequestParam String query, Model model) {
        List<Client> searchResults = IClientRepository.findByClientNameContainingIgnoreCaseOrClientRutContainingIgnoreCase(query, query);
        model.addAttribute("clients", searchResults);
        return "plantillaCliente";
    }

    // Actualizar un cliente existente
    @PostMapping("/client/{clientId}")
    public ResponseEntity<Client> updateClient(@RequestParam Long clientId, @ModelAttribute Client updatedClient) {
        // Verificar que el cliente con el ID exista antes de actualizar
        Optional<Client> optionalClient = Optional.ofNullable(clientImpl.findById(clientId));

        if (optionalClient.isPresent()) {
            // Obtener el cliente existente de la base de datos
            Client existingClient = optionalClient.get();

            // Actualizar los campos necesarios
            existingClient.setClientName(updatedClient.getClientName());
            existingClient.setClientRut(updatedClient.getClientRut());

            // Guardar el cliente actualizado en la base de datos
            Client savedClient = clientImpl.save(existingClient);

            return new ResponseEntity<>(savedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un cliente
    @DeleteMapping("/client/{clientId}")
    public String deleteClient(@PathVariable Long clientId, Model model) {
        Client deleteClient = IClientService.delete(clientId);
        model.addAttribute("client", deleteClient);
        return "plantillaCliente";
    }
}


