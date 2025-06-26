package com.bank.profile.service;

import com.bank.profile.entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile getById(long id);

    List<Profile> getProfilesList();

    Optional<Profile> getByEmail(String email);

    void addProfile(Profile profile);
}
