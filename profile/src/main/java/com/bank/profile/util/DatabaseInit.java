//package com.bank.profile.util;
//
//import com.bank.profile.entity.Profile;
//import com.bank.profile.service.ProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import javax.annotation.PostConstruct;
//
///**
// * Класс для инициализации баз данных
// *
// * @author Vladislav Shilov
// */
//
//@Component
//public class DatabaseInit {
//    private final ProfileService profileService;
//    @Autowired
//    public DatabaseInit(ProfileService profileService) {
//        this.profileService = profileService;
//    }
//
//    @PostConstruct
//    public void initDbUsers() {
//
//        if (profileService.getProfilesList().isEmpty()) {
//            final Profile admin = new Profile(88_005_553_535L, "Admin@mail.ru", "Admin", 777L, 777L, 1L, 1L);
//            profileService.addProfile(admin);
//
//            final Profile user = new Profile(88_005_553_535L, "User@mail.ru", "User", 7777L, 7777L, 2L, 2L);
//            profileService.addProfile(user);
//        }
//    }
//}
