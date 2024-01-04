package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.Client;
import com.devoluciones.carozzidev.model.ReceptionForm;
import com.devoluciones.carozzidev.repository.IClientRepository;
import com.devoluciones.carozzidev.repository.IReceptionFormRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionFormServiceImpl implements IReceptionFormService {

    private final IReceptionFormRepository IReceptionFormRepository;

    @Autowired
    private IClientRepository iClientRepository;

    public ReceptionFormServiceImpl(com.devoluciones.carozzidev.repository.IReceptionFormRepository iReceptionFormRepository) {
        IReceptionFormRepository = iReceptionFormRepository;
    }

    @Override
    public List<ReceptionForm> receptionFormList() {
        return IReceptionFormRepository.findAll();
    }

    @Override
    public ReceptionForm saveReceptionForm(ReceptionForm receptionForm, Long clientId) {
        // Buscar el cliente por su ID
        Client client = iClientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + clientId));

        // Establecer la relación entre ReceptionForm y Client
        receptionForm.setClient(client);

        // Guardar ReceptionForm
        return IReceptionFormRepository.save(receptionForm);
    }
}
