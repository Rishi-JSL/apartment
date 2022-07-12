package com.apartment.apartment.controller;

import com.apartment.apartment.dto.ApartmentInsertionRequest;
import com.apartment.apartment.dto.UserDTO;
import com.apartment.apartment.entity.Apartment;
import com.apartment.apartment.service.ApartmentService;
import com.apartment.apartment.service.UserService;
import com.apartment.apartment.util.CreatorUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/apartment")
public class ApartmentAPI {

    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private CreatorUtil creatorUtil;
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public ModelAndView addApartment() {
        ApartmentInsertionRequest apartmentInsertionRequest = new ApartmentInsertionRequest();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("apartmentAdditionRequest", apartmentInsertionRequest);
        modelAndView.setViewName("apartmentAdd");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addApartment(ApartmentInsertionRequest apartmentInsertionRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String email = user.getUsername();
        apartmentInsertionRequest.setOwnerEmail(email);
        Apartment apartment = creatorUtil.createApartment(apartmentInsertionRequest);
        long row = apartmentService.insertApartment(apartment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("apartmentAdditionRequest", apartment);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView fetchAllApartments() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String email = user.getUsername();
        UserDTO userDTO = userService.getUserFromEmail(email);
        if (Objects.isNull(userDTO)) {
            throw new RuntimeException("User not found with given email address");
        }
        String ownerId = String.valueOf(userDTO.getId());
        List<Apartment> imageDTOS = apartmentService.fetchAllApartments(ownerId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("apartments", imageDTOS);
        modelAndView.setViewName("apartments");
        return modelAndView;
    }
}
