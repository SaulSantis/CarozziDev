package com.devoluciones.carozzidev.controller;

import com.devoluciones.carozzidev.model.Client;
import com.devoluciones.carozzidev.model.ReceptionForm;
import com.devoluciones.carozzidev.repository.IClientRepository;
import com.devoluciones.carozzidev.repository.IReceptionFormRepository;
import com.devoluciones.carozzidev.service.IReceptionFormService;
import com.devoluciones.carozzidev.service.ReceptionFormServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receptionForm")
public class ReceptionFormController {

    @Autowired
    private ReceptionFormServiceImpl receptionFormServiceImpl;

    @Autowired
    private IReceptionFormRepository IReceptionFormRepository;

    @Autowired
    private IClientRepository iClientRepository;

    @GetMapping("/all")
    public ResponseEntity<List<ReceptionForm>> getAllReceptionForms() {
        List<ReceptionForm> receptionForms = receptionFormServiceImpl.receptionFormList();
        return new ResponseEntity<>(receptionForms, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ReceptionForm> saveReceptionForm(@RequestBody ReceptionForm receptionForm, @RequestParam Long clientId) {
        try {
            // Buscar el cliente por su ID
            Client client = iClientRepository.findById(clientId)
                    .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + clientId));

            // Establecer la relación entre ReceptionForm y Client
            receptionForm.setClient(client);

            // Guardar ReceptionForm
            ReceptionForm savedReceptionForm = receptionFormServiceImpl.saveReceptionForm(receptionForm, clientId);

            return new ResponseEntity<>(savedReceptionForm, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

//    @PostMapping("/save")
//    public ResponseEntity<String> createReceptionForm(@RequestBody ReceptionForm receptionForm) {
//        // Verifica si el clienteId está presente en el ReceptionForm
//        if (receptionForm.getClient() != null && receptionForm.getClient().getClientId() != null) {
//            // Busca el cliente por el clientId proporcionado
//            Client client = iClientRepository.findById(receptionForm.getClient().getClientId()).orElse(null);
//            if (client == null) {
//                return ResponseEntity.badRequest().body("Cliente no encontrado");
//            }
//
//            // Asocia el ReceptionForm al cliente existente
//            receptionForm.setClient(client);
//
//            // Establece la fecha actual para recepción e factura
//            receptionForm.prePersist();
//
//            // Guarda el ReceptionForm en la base de datos
//            IReceptionFormRepository.save(receptionForm);
//
//            return ResponseEntity.ok("ReceptionForm creado exitosamente");
//        } else {
//            return ResponseEntity.badRequest().body("ReceptionForm debe tener un cliente asociado");
//        }
    }


}


