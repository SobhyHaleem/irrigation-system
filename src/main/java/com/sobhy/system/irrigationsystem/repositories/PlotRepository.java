package com.sobhy.system.irrigationsystem.repositories;

import com.sobhy.system.irrigationsystem.entities.Plot;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {

    Plot findByPlotName(String name);
    @Query(value = "select distinct p from Plot p")
    List<Plot> search(PageRequest pageData);

    @Query(value = "select distinct p from Plot p")
    long countWithSearch();
}
