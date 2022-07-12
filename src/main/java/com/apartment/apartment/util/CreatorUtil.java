package com.apartment.apartment.util;

import com.apartment.apartment.dao.PlotDao;
import com.apartment.apartment.dao.UserDao;
import com.apartment.apartment.dto.ApartmentInsertionRequest;
import com.apartment.apartment.dto.UserDTO;
import com.apartment.apartment.entity.Apartment;
import com.apartment.apartment.entity.Plot;
import com.apartment.apartment.service.PlotService;
import com.apartment.apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CreatorUtil {

    @Autowired
    private UserService userService;
    @Autowired
    private PlotService plotService;

    public Apartment createApartment(ApartmentInsertionRequest apartmentInsertionRequest) {
        UserDTO userDTO = userService.getUserFromEmail(apartmentInsertionRequest.getOwnerEmail());
        Plot plot = plotService.getPlotFromPlotName(apartmentInsertionRequest.getPlotName());
        if (Objects.isNull(userDTO)) {
            throw new RuntimeException("User not found with given email address");
        }
        if (Objects.isNull(plot)) {
            throw new RuntimeException("Plot not found with given plot name");
        }
        int ownerId = userDTO.getId();
        int plotId = plot.getId();

        Apartment apartment = new Apartment();
        apartment.setName(apartmentInsertionRequest.getName());
        apartment.setOwnerId(String.valueOf(ownerId));
        apartment.setPlotId(String.valueOf(plotId));
        apartment.setDeposit(apartmentInsertionRequest.getDeposit());
        apartment.setRent(apartmentInsertionRequest.getRent());
        apartment.setMaintenance(apartmentInsertionRequest.getMaintenance());
        apartment.setPerUnitChargeElectricity(apartmentInsertionRequest.getPerUnitChargeElectricity());
        apartment.setPerUnitChargeWater(apartmentInsertionRequest.getPerUnitChargeWater());
        apartment.setDetails(apartmentInsertionRequest.getDetails());
        apartment.setBhk(apartmentInsertionRequest.getBhk());
        apartment.setLocation(apartmentInsertionRequest.getLocation());
        return apartment;
    }
}
