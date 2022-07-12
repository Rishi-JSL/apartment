package com.apartment.apartment.dao;

import com.apartment.apartment.entity.Apartment;

import java.util.List;

public interface ApartmentDao {

    long insertApartment(Apartment apartment);
    List<Apartment> fetchAllApartments(String ownerId);
}
