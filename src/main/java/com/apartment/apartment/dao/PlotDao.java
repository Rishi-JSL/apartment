package com.apartment.apartment.dao;

import com.apartment.apartment.entity.Plot;

public interface PlotDao {
    Plot getPlotFromPlotName(String plotName);
}
