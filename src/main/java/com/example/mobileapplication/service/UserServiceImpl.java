package com.example.mobileapplication.service;


import com.example.mobileapplication.dao.UserDto;
import com.example.mobileapplication.data.model.UserEntity;
import com.example.mobileapplication.data.repository.UserRepository;

import com.example.mobileapplication.exception.UsernameNotFoundException;
import com.example.mobileapplication.dto.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    Utils utils;

    public UserDto createUser(UserDto user) {
        UserEntity foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null)
            throw new RuntimeException("User cannot be found");
        else {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            String publicUserId = utils.generateUserId(30);
            userEntity.setUserId(publicUserId);
            UserEntity savedUser = userRepository.save(userEntity);
            UserDto returnValue = new UserDto();
            BeanUtils.copyProperties(savedUser, returnValue);
            return returnValue;

        }
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity foundUser = userRepository.findUserById(userId);
        if (foundUser == null) {
            throw new UsernameNotFoundException(userId);
        }
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(foundUser, returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity foundUser = userRepository.findByEmail(email);
        if (foundUser == null) {
            throw new UsernameNotFoundException(email);
        }
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(foundUser, returnValue);
        return returnValue;
    }

    @Override
    public long TotalUsers() {
        return userRepository.count();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserDto getUserById(String userId) {
        UserEntity userEntity = userRepository.findUserById(userId);
        if (userEntity == null)
            throw new UsernameNotFoundException("User with Id" + userId + "not found");
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        UserEntity foundUser = userRepository.findByEmail(email);
        if (foundUser == null) {
            throw new org.springframework.security.core.userdetails.UsernameNotFoundException(email);
        }
        return new User(foundUser.getEmail(), foundUser.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        UserEntity userEntity = userRepository.findUserById(userId);
        if (userEntity == null)
            throw new UsernameNotFoundException("No record found");
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        UserEntity updateUserDetails = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(updateUserDetails, returnValue);
        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userRepository.findUserById(userId);
        if (userEntity == null)
            throw new UsernameNotFoundException("No record found");
        userRepository.delete(userEntity);
    }
    @Override
    public List<UserDto> getUsers(int page, int limit) {
        List<UserDto> returnValue = new ArrayList<>();
        if (page> 0) page -=1;
        org.springframework.data.domain.Pageable pageableRequest = PageRequest.of(page, limit);
        Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);
        List<UserEntity> users = usersPage.getContent();
        for(UserEntity userEntities : users) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntities, userDto);
            returnValue.add(userDto);
        }
        return returnValue;
    }
}