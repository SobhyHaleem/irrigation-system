package com.sobhy.system.irrigationsystem.utilities.mappers;

import com.sobhy.system.irrigationsystem.entities.Plot;
import com.sobhy.system.irrigationsystem.models.PlotDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PlotMapper {

    public Plot toPlotEntity(PlotDto plotDto) {
        if (plotDto == null) {
            return null;
        } else {
            ModelMapper modelMapper = new ModelMapper();
            Plot plot = modelMapper.map(plotDto, Plot.class);
            return plot;
        }
    }

    public PlotDto toPlotModel(Plot plot) {
        if (plot == null) {
            return null;
        } else {
            ModelMapper modelMapper = new ModelMapper();
            PlotDto plotDto = modelMapper.map(plot, PlotDto.class);
            return plotDto;
        }
    }
}
