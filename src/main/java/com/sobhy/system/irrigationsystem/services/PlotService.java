package com.sobhy.system.irrigationsystem.services;

import com.google.common.base.Strings;
import com.sobhy.system.irrigationsystem.contracts.IPlotService;
import com.sobhy.system.irrigationsystem.entities.Plot;
import com.sobhy.system.irrigationsystem.models.PlotDto;
import com.sobhy.system.irrigationsystem.repositories.PlotRepository;
import com.sobhy.system.irrigationsystem.utilities.mappers.PlotMapper;
import com.sobhy.system.irrigationsystem.utilities.validators.PlotValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlotService implements IPlotService {

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private PlotMapper plotMapper;

    @Autowired
    private PlotValidator plotValidator;

    @Override
    public PlotDto createPlot(PlotDto plotDto) throws Exception {
        plotValidator.validate(plotDto);
        Plot plot = plotMapper.toPlotEntity(plotDto);
        plotRepository.save(plot);
        return plotMapper.toPlotModel(plot);
    }

    @Override
    public PlotDto updatePlot(PlotDto plotDto) throws Exception {
        Plot existingPlot = plotRepository.findById(plotDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Plot not found with ID: " + plotDto.getId()));
        existingPlot.setPlotName(plotDto.getPlotName());
        return plotMapper.toPlotModel(plotRepository.save(existingPlot));
    }

    @Override
    public List<PlotDto> getAllPlots() {
        List<PlotDto> plotDtoList =  plotRepository.findAll().stream().map(plot -> plotMapper.toPlotModel(plot)).collect(Collectors.toList());
        return plotDtoList;
    }

    @Override
    public List<PlotDto> getPlotsList(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            pageNum = 0;
            pageSize = Integer.MAX_VALUE;
        }
        PageRequest pageData = PageRequest.of(pageNum, pageSize, Sort.by("id").ascending());
        List<PlotDto> plotDtoList;
        plotDtoList = plotRepository.search(pageData).stream().map(plot -> plotMapper.toPlotModel(plot)).collect(Collectors.toList());
        return plotDtoList;
    }

    @Override
    public long getCountPlotList() {
        return plotRepository.countWithSearch();
    }

}
