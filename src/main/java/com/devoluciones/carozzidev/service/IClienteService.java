package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {

    public List<Cliente> listarCliente();

    public List<Cliente> findClienteByName(String nombreCliente);
    public List<Cliente> findClienteByRut(String rutCliente);

    Cliente guardarCliente(Cliente cliente);
    List<Cliente> guardarListaClientes(List<Cliente> clientes);
    public void deleteCliente(Cliente Cliente);
}
