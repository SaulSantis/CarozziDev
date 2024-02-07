package com.devoluciones.carozzidev.model.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionForm {

    // Constantes para los nombres de las columnas en la base de datos
    public static final String ID_COLUMN = "reception_form_id";
    public static final String RECEPTION_TIME_COLUMN = "reception_time";
    public static final String RECEPTION_DATE_COLUMN = "reception_date";
    public static final String INVOICE_NUMBER_COLUMN = "invoice_number";
    public static final String RUT_COLUMN = "client_rut";
    public static final String NAME_COLUMN = "client_name";
    public static final String CARRIER_COLUMN = "carrier";
    public static final String INVOICE_DATE_COLUMN = "invoice_date";
    public static final String FULL_REFUND_COLUMN = "full_refund";
    public static final String PARTIAL_REFUND_COLUMN = "partial_refund";

    // Identificador único autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN)
    private Long formId;

    // Hora de recepción generada automáticamente al realizar una inserción
    @CreatedDate
    @JsonFormat(pattern = "HH:mm")
    @Column(name = RECEPTION_TIME_COLUMN)
    private LocalTime receptionTime;

    // Fecha de recepción generada automáticamente al realizar una inserción
    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = RECEPTION_DATE_COLUMN)
    private LocalDate receptionDate;

    // Número de factura, obligatorio y no puede estar en blanco
    @Column(name = INVOICE_NUMBER_COLUMN)
    @NotBlank(message = "El número de factura no puede estar en blanco")
    private String invoiceNumber;

    // Rut del cliente, obligatorio y no puede estar en blanco
    @Column(name = RUT_COLUMN)
    @NotBlank(message = "El rut del cliente no puede estar en blanco")
    private String clientRut;

    // Nombre del cliente, obligatorio y no puede estar en blanco
    @Column(name = NAME_COLUMN)
    @NotBlank(message = "El nombre del cliente no puede estar en blanco")
    private String clientName;

    // Nombre del transportista, obligatorio y no puede estar en blanco
    @Column(name = CARRIER_COLUMN)
    @NotBlank(message = "El nombre del transportista no puede estar en blanco")
    private String carrier;

    // Fecha de la factura
    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = INVOICE_DATE_COLUMN)
    private LocalDate invoiceDate;

    // Indicador de reembolso completo
    @Column(name = FULL_REFUND_COLUMN)
    private Boolean fullRefund;

    // Indicador de reembolso parcial
    @Column(name = PARTIAL_REFUND_COLUMN)
    private Boolean partialRefund;

    // Método ejecutado antes de la persistencia para establecer la hora y fecha de recepción
    @PrePersist
    public void prePersist() {
        // Generar la hora actual al realizar una inserción
        this.receptionTime = LocalTime.now();

        // Generar la fecha actual al realizar una inserción
        this.receptionDate = LocalDate.now();
    }

    // Relación con la entidad Client
    @ManyToOne(targetEntity = Client.class)
    private Client client;

    // Relación con la entidad RejectedReason
    @ManyToOne(targetEntity = RejectionReason.class)
    private RejectionReason rejectionReason;

//    @OneToMany(targetEntity = Products.class,
//            mappedBy = "receptionForms",
//            fetch = FetchType.EAGER)
//    private List<Products> products;

    // Relación con la entidad RejectedReason
    @ManyToOne(targetEntity = Products.class)
    private Products products;
}

