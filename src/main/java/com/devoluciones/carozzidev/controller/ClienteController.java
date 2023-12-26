package com.devoluciones.carozzidev.controller;

import com.devoluciones.carozzidev.model.Cliente;
import com.devoluciones.carozzidev.repository.ClienteRepository;
import com.devoluciones.carozzidev.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.listarCliente();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @PostMapping("/guardar-lista")
    public List<Cliente> guardarListaClientes(@RequestBody List<Cliente> clientes) {
        return clienteService.guardarListaClientes(clientes);
    }

    @GetMapping("/por-nombre")
    public List<Cliente> getClientesPorNombre(@RequestParam String nombreCliente) {
        return clienteRepository.findByNombreClienteContainingIgnoreCase(nombreCliente);
    }

    @GetMapping("/por-rut")
    public List<Cliente> getClientesPorRut(@RequestParam String rutCliente) {
        return clienteRepository.findByRutClienteContainingIgnoreCase(rutCliente);
    }
}
