package com.devoluciones.carozzidev.controller;

import com.devoluciones.carozzidev.model.entity.ReceptionForm;
import com.devoluciones.carozzidev.model.repository.IReceptionFormRepository;
import com.devoluciones.carozzidev.service.impl.ReceptionFormImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReceptionFormController {

    @Autowired
    private ReceptionFormImpl receptionFormImpl;

    @Autowired
    private IReceptionFormRepository iReceptionFormRepository;


    @GetMapping("/forms")
    public ResponseEntity<List<ReceptionForm>> receptionFormList() {
        List<ReceptionForm> receptionForms = receptionFormImpl.receptionFormList();
        return new ResponseEntity<>(receptionForms, HttpStatus.OK);
    }
    @PostMapping("/form")
    public ReceptionForm save(@RequestBody ReceptionForm receptionForm) {
        return iReceptionFormRepository.save(receptionForm);
    }



}



