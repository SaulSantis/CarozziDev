package com.devoluciones.carozzidev.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RejectionReason {

    // Constantes para los nombres de las columnas en la base de datos
    public static final String ID_COLUMN = "rejection_reason_id";
    public static final String REJECTION_REASON_COLUMN = "rejection";
    public static final String OTHER_COLUMN = "other_reason";

    // Identificador único autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN)
    private Long rejectionId;

    @Column(name = REJECTION_REASON_COLUMN)
    private String rejection;

    @Column(name = OTHER_COLUMN)
    private String otherReason;

    // Relación con la entidad ReceptionForm
    @JsonIgnore
    @OneToMany(targetEntity = ReceptionForm.class,
            fetch = FetchType.LAZY,
            mappedBy = "rejectionReason")
    private List<ReceptionForm> receptionForms;

}
