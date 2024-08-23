package com.example.supplierapi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Supplier {
    @Id
    private String supplier_id = UUID.randomUUID().toString();
    private String company_name;
    private String website;
    @NotBlank
    private String location;
    @NotBlank
    @Enumerated(EnumType.STRING) //to store enum as string in db so no errors
    private NatureOfBusiness nature_of_business;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private ManufacturingProcess manufacturing_processes;
}

