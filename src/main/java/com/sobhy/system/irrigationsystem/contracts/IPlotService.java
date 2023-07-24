package com.sobhy.system.irrigationsystem.contracts;

import com.sobhy.system.irrigationsystem.models.PlotDto;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface IPlotService {

    PlotDto createPlot(PlotDto plotDto) throws Exception;

    PlotDto updatePlot(PlotDto plotDto) throws Exception;

    List<PlotDto> getAllPlots();

    List<PlotDto> getPlotsList(Integer pageNum, Integer pageSize);

    long getCountPlotList();

}
