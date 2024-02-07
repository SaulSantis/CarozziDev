package com.devoluciones.carozzidev.model.repository;

import com.devoluciones.carozzidev.model.entity.RejectionReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRejectionReasonRepository extends JpaRepository<RejectionReason, Long> {
}
