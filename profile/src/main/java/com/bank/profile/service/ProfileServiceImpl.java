package com.bank.profile.service;

import com.bank.profile.entity.Profile;
import com.bank.profile.repository.ProfileRepository;
import com.bank.profile.util.ProfileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile getById(long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        profile.orElseThrow(ProfileNotFoundException::new);
        return profile.get();
    }

    @Override
    public List<Profile> getProfilesList() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> getByEmail(String email) {
        return profileRepository.getProfileByEmail(email);
    }

    @Override
    public void addProfile(Profile profile) {
        profileRepository.saveAndFlush(profile);
    }
}
