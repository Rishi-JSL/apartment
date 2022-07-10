package com.apartment.apartment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Apartment {
    private String id;
    private String name;
    private String ownerId;
    private String plotId;
    private String deposit;
    private String rent;
    private String maintenance;
    private String perUnitChargeElectricity;
    private String perUnitChargeWater;
    private String details;
    private String bhk;
    private String location;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}