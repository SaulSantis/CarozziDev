package com.devoluciones.carozzidev.controller;

import com.devoluciones.carozzidev.model.entity.RejectionReason;
import com.devoluciones.carozzidev.model.repository.IRejectionReasonRepository;
import com.devoluciones.carozzidev.service.impl.RejectionReasonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RejectionReasonController {

    @Autowired
    private RejectionReasonImpl rejectionReasonImpl;

    @Autowired
    private IRejectionReasonRepository iRejectionReasonRepository;

    @GetMapping("/rejections")
    public ResponseEntity<List<RejectionReason>> rejectionReasonList() {
        List<RejectionReason> clients = rejectionReasonImpl.rejectionReasonList();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping("/rejections")
    public ResponseEntity<List<RejectionReason>> saveRejectionReasonsList(@RequestBody List<RejectionReason> rejectionReason) {
        List<RejectionReason> savedRejectionReasons = rejectionReasonImpl.saveAll(rejectionReason);
        return new ResponseEntity<>(savedRejectionReasons, HttpStatus.CREATED);
    }

    @PostMapping("/rejection")
    public RejectionReason save(@RequestBody RejectionReason rejectionReason) {
        return iRejectionReasonRepository.save(rejectionReason );
    }

}


