package com.devoluciones.carozzidev.service.impl;

import com.devoluciones.carozzidev.model.entity.RejectionReason;
import com.devoluciones.carozzidev.model.repository.IRejectionReasonRepository;
import com.devoluciones.carozzidev.service.IRejectionReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RejectionReasonImpl implements IRejectionReasonService {

    @Autowired
    private IRejectionReasonRepository iRejectionReasonRepository;
    @Override
    public List<RejectionReason> rejectionReasonList() {
        return iRejectionReasonRepository.findAll();
    }

    @Override
    public List<RejectionReason> saveAll(List<RejectionReason> rejectionReasons) {
        return iRejectionReasonRepository.saveAll(rejectionReasons);
    }

    @Override
    public RejectionReason save(RejectionReason rejectionReason) {
        return iRejectionReasonRepository.save(rejectionReason);
    }
}
