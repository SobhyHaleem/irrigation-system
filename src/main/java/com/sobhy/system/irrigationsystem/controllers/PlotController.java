package com.sobhy.system.irrigationsystem.controllers;

import com.sobhy.system.irrigationsystem.common.Pagination;
import com.sobhy.system.irrigationsystem.common.Response;
import com.sobhy.system.irrigationsystem.contracts.IPlotService;
import com.sobhy.system.irrigationsystem.models.PlotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plots")
public class PlotController extends BaseController{

    @Autowired
    private IPlotService iPlotService;

    @PostMapping
    public ResponseEntity<Response<PlotDto>> createAttributeGroup(@RequestBody PlotDto plotDto) throws Exception {
        return formatResponse(iPlotService.createPlot(plotDto));
    }

    @PutMapping()
    public ResponseEntity<Response<PlotDto>> updatePlot(@RequestBody PlotDto plotDto) throws Exception {
        return formatResponse(iPlotService.updatePlot(plotDto));
    }

    @GetMapping(value = "/{pageNum}/{pageSize}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<List<PlotDto>>> getRoleList(@PathVariable Integer pageNum,
                                                               @PathVariable Integer pageSize) throws Exception {

        List<PlotDto> plotDtoList = iPlotService.getPlotsList(pageNum, pageSize);
        Pagination pagination = new Pagination(iPlotService.getCountPlotList(), pageSize, pageNum);
        return formatResponse(plotDtoList, pagination);
    }
}
