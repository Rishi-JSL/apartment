package com.apartment.apartment.service;

import com.apartment.apartment.entity.Apartment;

import java.util.List;

public interface ApartmentService {

    long insertApartment(Apartment apartment);
    List<Apartment> fetchAllApartments(String ownerId);
}
