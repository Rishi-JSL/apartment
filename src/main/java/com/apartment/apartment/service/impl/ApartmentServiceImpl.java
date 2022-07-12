package com.apartment.apartment.service.impl;

import com.apartment.apartment.dao.ApartmentDao;
import com.apartment.apartment.entity.Apartment;
import com.apartment.apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentDao apartmentDao;

    @Override
    public long insertApartment(Apartment apartment) {
        return apartmentDao.insertApartment(apartment);
    }

    @Override
    public List<Apartment> fetchAllApartments(String ownerId) {
        return apartmentDao.fetchAllApartments(ownerId);
    }
}
