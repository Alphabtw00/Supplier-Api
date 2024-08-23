package com.example.supplierapi.controller;

import com.example.supplierapi.entity.ManufacturingProcess;
import com.example.supplierapi.entity.NatureOfBusiness;
import com.example.supplierapi.entity.Supplier;
import com.example.supplierapi.repository.SupplierRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> returnQuerySuppliers(@RequestParam String location,
                                                               @RequestParam ManufacturingProcess manufacturingProcess,
                                                               @RequestParam NatureOfBusiness natureOfBusiness,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);

        Page<Supplier> supplierPage = supplierRepository.findSupplierByLocationAndNatureOfBusinessAndManufacturingProcesses(
                location, natureOfBusiness, manufacturingProcess, pageable);

        if (supplierPage.isEmpty()) {
            throw new RuntimeException("No suppliers found for the given criteria");
        }

        return ResponseEntity.ok(supplierPage);

    }

}
