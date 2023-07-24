package com.sobhy.system.irrigationsystem.repositories;

import com.sobhy.system.irrigationsystem.entities.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
