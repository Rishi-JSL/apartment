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
public class Plot {
    private int id;
    private String name;
    private String location;
    private String apartmentId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
