package com.bank.profile.controller;

import com.bank.profile.entity.Profile;
import com.bank.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileRestController {
    private final ProfileService profileService;

    @Autowired
    public ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> showAllUsers() {
        return new ResponseEntity<>(profileService.getProfilesList(), HttpStatus.OK);
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<Profile> getUserById(@PathVariable("id") long id) {
        return new ResponseEntity<>(profileService.getById(id), HttpStatus.OK);
    }
}
