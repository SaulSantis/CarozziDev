package com.devoluciones.carozzidev.service;

import com.devoluciones.carozzidev.model.entity.RejectionReason;

import java.util.List;

public interface IRejectionReasonService {

    List<RejectionReason> rejectionReasonList();

    List<RejectionReason> saveAll(List<RejectionReason> rejectionReasons);
    RejectionReason save(RejectionReason rejectionReason);
}
