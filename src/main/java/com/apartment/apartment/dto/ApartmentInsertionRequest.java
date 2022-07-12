package com.apartment.apartment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ApartmentInsertionRequest {
    private String name;
    private String ownerEmail;
    private String plotName;
    private String deposit;
    private String rent;
    private String maintenance;
    private String perUnitChargeElectricity;
    private String perUnitChargeWater;
    private String details;
    private String bhk;
    private String location;
}
