package com.devoluciones.carozzidev.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;




/**
 * Clase que representa a un cliente en el sistema
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {

    /**
     * Utilización de constantes, esto facilita la refactorización si los nombres de las columnas cambian.
     */
    public static final String ID_COLUMN = "id_cliente";
    public static final String NOMBRE_COLUMN = "nombre_cliente";
    public static final String RUT_COLUMN = "rut_cliente";

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN)
    private Long idCliente;

    /**
     * Nombre del cliente.
     */
    @Column(name = NOMBRE_COLUMN)
    @NotBlank(message = "El nombre del cliente no puede estar en blanco")
    private String nombreCliente;

    /**
     * Rut (Rol Único Tributario) del cliente.
     */
    @Column(name = RUT_COLUMN)
    @NotBlank(message = "El rut del cliente no puede estar en blanco")
    private String rutCliente;
}
