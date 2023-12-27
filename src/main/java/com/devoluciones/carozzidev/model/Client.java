package com.devoluciones.carozzidev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Clase que representa a un cliente en el sistema.
 * Esta clase mapea la entidad Cliente en la base de datos y proporciona la estructura de datos necesaria para
 * interactuar con la información del cliente.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    /**
     * Utilización de constantes, esto facilita la refactorización si los nombres de las columnas cambian.
     */
    public static final String ID_COLUMN = "client_id";
    public static final String NAME_COLUMN = "client_name";
    public static final String RUT_COLUMN = "client_rut";

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN)
    private Long clientId;

    /**
     * Nombre del cliente.
     */
    @Column(name = NAME_COLUMN)
    @NotBlank(message = "El nombre del cliente no puede estar en blanco")
    private String clientName;

    /**
     * Rut (Rol Único Tributario) del cliente.
     */
    @Column(name = RUT_COLUMN)
    @NotBlank(message = "El rut del cliente no puede estar en blanco")
    private String clientRut;
}
