package com.apartment.apartment.service.impl;

import com.apartment.apartment.dao.PlotDao;
import com.apartment.apartment.entity.Plot;
import com.apartment.apartment.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlotServiceImpl implements PlotService {

    @Autowired
    private PlotDao plotDao;

    @Override
    public Plot getPlotFromPlotName(String plotName) {
        return plotDao.getPlotFromPlotName(plotName);
    }
}
