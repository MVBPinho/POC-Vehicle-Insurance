package com.pinho.vehicle.insurance.repositories;

import com.pinho.vehicle.insurance.entities.TypeInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<TypeInsurance, Long> {

}