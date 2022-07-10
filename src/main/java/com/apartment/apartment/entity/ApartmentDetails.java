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
public class ApartmentDetails {
    private String id;
    private String apartmentId;
    private LocalDate tenureStartDate;
    private LocalDate tenureEndDate;
    private String electricityBill;
    private String waterBill;
    private String rent;
    private String tenant;
    private String members;
    private boolean occupancy;
    private String status;
    private String overdue;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
