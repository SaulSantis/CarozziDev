package com.devoluciones.carozzidev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReceptionForm {

    public static final String ID_COLUMN = "form_id";
    public static final String RECEPTION_TIME_COLUMN = "reception_time";
    public static final String RECEPTION_DATE_COLUMN = "reception_date";
    public static final String INVOICE_NUMBER_COLUMN = "invoice_number";
    public static final String NAME_COLUMN = "client_name";
    public static final String CARRIER_COLUMN = "carrier";
    public static final String INVOICE_DATE_COLUMN = "invoice_date";
    public static final String FULL_REFUND_COLUMN = "full_refund";
    public static final String PARTIAL_REFUND_COLUMN = "partial_refund";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN)
    private Long formId;

    @Column(name = RECEPTION_TIME_COLUMN)
    private LocalDateTime receptionTime;

    @Column(name = RECEPTION_DATE_COLUMN)
    @NotBlank(message = "La fecha de recepción no puede estar en blanco")
    private LocalDate receptionDate;

    @Column(name = INVOICE_NUMBER_COLUMN)
    @NotBlank(message = "El número de factura no puede estar en blanco")
    private String invoiceNumber;

    @Column(name = NAME_COLUMN)
    @NotBlank(message = "El nombre del cliente no puede estar en blanco")
    private String clientName;

    @Column(name = CARRIER_COLUMN)
    @NotBlank(message = "El nombre del transportista no puede estar en blanco")
    private String carrier;

    @Column(name = INVOICE_DATE_COLUMN)
    @NotBlank(message = "La fecha de la factura no puede estar en blanco")
    private LocalDate invoiceDate;

    @Column(name = FULL_REFUND_COLUMN)
    private boolean fullRefund;

    @Column(name = PARTIAL_REFUND_COLUMN)
    private boolean partialRefund;


    @PrePersist
    public void prePersist() {
        // Generar la hora actual al realizar una inserción
        this.receptionTime = LocalDateTime.now();

        // Generar la fecha actual al realizar una inserción
        this.receptionDate = LocalDate.now();

        // Generar la fecha actual al realizar una inserción
        this.invoiceDate = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = Client.ID_COLUMN)  // Asegúrate de usar la columna correcta
    @JsonIgnore
    private Client client;

}
