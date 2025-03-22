package com.example.userservice;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserDetailRepo extends MongoRepository<UserDetail, String> {
}
