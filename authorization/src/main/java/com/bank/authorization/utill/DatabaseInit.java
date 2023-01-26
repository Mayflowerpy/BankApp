//package com.bank.authorization.utill;
//
//import com.bank.authorization.entity.User;
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.bank.authorization.service.UserService;
//import javax.annotation.PostConstruct;
//
//@Component
//public class DatabaseInit {
//    private final UserService userService;
//    @Autowired
//    public DatabaseInit(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostConstruct
//    public void initDbUsers() {
//        if (userService.getUsersList().isEmpty()) {
//            User admin = new User("Admin", 1L, "admin");
//            User user = new User("User", 2L, "user");
//            userService.addUser(admin);
//            userService.addUser(user);
//        }
//    }
//}
