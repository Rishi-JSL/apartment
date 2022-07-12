package com.apartment.apartment.controller;

import com.apartment.apartment.dto.UserDTO;
import com.apartment.apartment.service.RoleService;
import com.apartment.apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@RestController
public class AuthenticationAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) boolean error) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) || authentication instanceof AnonymousAuthenticationToken) {
            if (error) {
                modelAndView.setViewName("errorPage");
            } else {
                modelAndView.setViewName("login");
            }
        } else {
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) || authentication instanceof AnonymousAuthenticationToken) {
            UserDTO userDTO = new UserDTO();
            modelAndView.addObject("userDTO", userDTO);
            modelAndView.setViewName("register");
        } else {
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(UserDTO userDTO) {
        int userId = userService.insertUser(userDTO);
        System.out.println(userId);
        roleService.mapUserAndRole(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userDTO", userDTO);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView loginSignup(@RequestParam (required = false) String action) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) || authentication instanceof AnonymousAuthenticationToken) {
            modelAndView.setViewName("loginSignup");
        } else {
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }
}
