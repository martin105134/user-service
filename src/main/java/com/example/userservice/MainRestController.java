package com.example.userservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class MainRestController {
    @Autowired
    UserDetailRepo userDetailRepo;

    @Autowired
    AuthService authService;

    @PostMapping("/update")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserDetail userDetail, @RequestHeader("Authorization") String token) {
      log.debug("Enter updateUserInfo");
      log.debug("token: " + token);
        if (!authService.authenticate(token)) {
            return ResponseEntity.badRequest().body("Invalid token");
        }
        userDetailRepo.save(userDetail);
        log.debug("Existing updateUserInfo");
        return ResponseEntity.ok(userDetail);
    }
}
