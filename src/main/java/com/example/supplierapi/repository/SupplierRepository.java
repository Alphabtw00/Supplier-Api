package com.example.supplierapi.repository;



import com.example.supplierapi.entity.ManufacturingProcess;
import com.example.supplierapi.entity.NatureOfBusiness;
import com.example.supplierapi.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
    @Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.nature_of_business = :natureOfBusiness AND s.manufacturing_processes = :manufacturingProcess")
    Page<Supplier> findSupplierByLocationAndNatureOfBusinessAndManufacturingProcesses(
            String location, NatureOfBusiness natureOfBusiness,
            ManufacturingProcess manufacturingProcess, Pageable pageable);
}
