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
public class Owner {
    private String id;
    private String name;
    private String plotId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
