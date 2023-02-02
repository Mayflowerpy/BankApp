package com.bank.profile.service;

import com.bank.profile.entity.Profile;
import java.util.List;

public interface ProfileService {
    Profile getById(long id);
    List<Profile> getProfilesList();
//    Profile getbyEmail(String email);
}
