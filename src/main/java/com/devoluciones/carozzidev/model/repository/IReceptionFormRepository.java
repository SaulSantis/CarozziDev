package com.devoluciones.carozzidev.model.repository;

import com.devoluciones.carozzidev.model.entity.ReceptionForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceptionFormRepository extends JpaRepository<ReceptionForm, Long> {

   }
