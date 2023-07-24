package com.sobhy.system.irrigationsystem.repositories;

import com.sobhy.system.irrigationsystem.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
}
