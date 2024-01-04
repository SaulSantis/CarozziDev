package com.devoluciones.carozzidev.repository;

import com.devoluciones.carozzidev.model.ReceptionForm;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IReceptionFormRepository extends JpaRepository<ReceptionForm, Long> {

   }
