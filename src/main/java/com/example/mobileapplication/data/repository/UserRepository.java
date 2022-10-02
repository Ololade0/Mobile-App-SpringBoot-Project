package com.example.mobileapplication.data.repository;

import com.example.mobileapplication.data.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository  extends CrudRepository<UserEntity, Long> {

        UserEntity findByEmail(String email);

        UserEntity findUserById(String userId);


    }
