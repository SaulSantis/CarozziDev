package com.devoluciones.carozzidev.service.impl;

import com.devoluciones.carozzidev.model.entity.ReceptionForm;
import com.devoluciones.carozzidev.model.repository.IReceptionFormRepository;
import com.devoluciones.carozzidev.service.IReceptionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionFormImpl implements IReceptionFormService {

    @Autowired
    private IReceptionFormRepository iReceptionFormRepository;


    @Override
    public List<ReceptionForm> receptionFormList() {
        return iReceptionFormRepository.findAll();
    }

    @Override
    public ReceptionForm save(ReceptionForm receptionForm) {
        return iReceptionFormRepository.save(receptionForm);
    }

}