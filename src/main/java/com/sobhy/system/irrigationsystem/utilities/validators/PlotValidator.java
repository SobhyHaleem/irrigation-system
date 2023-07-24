package com.sobhy.system.irrigationsystem.utilities.validators;

import com.google.common.base.Strings;
import com.sobhy.system.irrigationsystem.entities.Plot;
import com.sobhy.system.irrigationsystem.models.PlotDto;
import com.sobhy.system.irrigationsystem.repositories.PlotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class PlotValidator {
    @Autowired
    PlotRepository plotRepository;

    public final void validate(PlotDto plotDto) throws Exception {
        validateName(plotDto);
        validateTimeSlots(plotDto);
    }

    private void validateTimeSlots(PlotDto plotDto) throws Exception {
        if(plotDto.getTimeSlots().size() == 0 || plotDto.getTimeSlots() == null ) {
            throw new Exception("Please add permissions");
        }
    }

    private void validateName(PlotDto plotDto) throws Exception {
        log.info("Validating Plot Name");
        if (Strings.isNullOrEmpty(plotDto.getPlotName())) {
            throw new Exception("Please enter plot name");
        }
        Plot plot = plotRepository.findByPlotName(plotDto.getPlotName());
        if ((plot != null) && (plot.getId() != null)) {
            throw new Exception("This role name already exists");
        }
    }
}
