package com.devoluciones.carozzidev.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    public static final String ID_COLUMN = "product_id";
    public static final String PRODUCT_CODE_COLUMN = "product_code";
    public static final String PRODUCT_NAME_COLUMN = "product_name";
    public static final String EXPIRATION_DATE_COLUMN = "expiration_date";
    public static final String PRODUCT_AMOUNT_COLUMN = "amount";
    public static final String PRODUCT_SALES_UNIT_COLUMN = "sales_unit";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID_COLUMN)
    private Long productId;

    @Column(name = PRODUCT_CODE_COLUMN)
    private String productCode;

    @Column(name = PRODUCT_NAME_COLUMN)
    private String productName;

    @Column(name = EXPIRATION_DATE_COLUMN)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;

    @Column(name = PRODUCT_AMOUNT_COLUMN)
    private int amount;

    @Column(name = PRODUCT_SALES_UNIT_COLUMN)
    private String salesUnit;

    @OneToMany(targetEntity = ReceptionForm.class,
            fetch = FetchType.LAZY,
            mappedBy = "products")
    @JsonIgnore
    private List<ReceptionForm> receptionForms;
}
