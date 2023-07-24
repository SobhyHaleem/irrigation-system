package com.sobhy.system.irrigationsystem.repositories;

import com.sobhy.system.irrigationsystem.entities.SensorStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorStatusRepository extends JpaRepository<SensorStatus, Long> {
}
