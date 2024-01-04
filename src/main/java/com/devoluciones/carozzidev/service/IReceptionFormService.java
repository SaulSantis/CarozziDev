package com.devoluciones.carozzidev.service;


import com.devoluciones.carozzidev.model.ReceptionForm;

import java.util.List;

public interface IReceptionFormService {

    List<ReceptionForm> receptionFormList();

    ReceptionForm saveReceptionForm(ReceptionForm receptionForm, Long clientId);

}
