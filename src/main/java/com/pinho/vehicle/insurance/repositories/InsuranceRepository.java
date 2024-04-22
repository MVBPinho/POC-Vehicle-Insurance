package com.pinho.vehicle.insurance.repositories;

import com.pinho.vehicle.insurance.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}