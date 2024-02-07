package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.entity.ReceptionForm;

import java.util.List;

public interface IReceptionFormService {

    List<ReceptionForm> receptionFormList();

    ReceptionForm save(ReceptionForm receptionForm);

}
