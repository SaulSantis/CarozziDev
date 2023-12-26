package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.Cliente;
import com.devoluciones.carozzidev.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> findClienteByName(String nombreCliente) {
        return clienteRepository.findByNombreClienteContainingIgnoreCase(nombreCliente);
    }
    @Override
    public List<Cliente> findClienteByRut(String rutCliente) {
        return clienteRepository.findByRutClienteContainingIgnoreCase(rutCliente);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> guardarListaClientes(List<Cliente> clientes) {
        return clienteRepository.saveAll(clientes);
    }
    @Override
    public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
