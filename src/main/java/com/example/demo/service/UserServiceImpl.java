package com.example.demo.service;

import com.example.demo.data.model.UserEntity;
import com.example.demo.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

 @Autowired
 com.example.demo.utils.utils utils;



    @Override
    public UserDto createUser(UserDto user ) {
      UserEntity foundUser =  userRepository.findByEmail(user.getEmail());
      if(foundUser != null)
          throw new RuntimeException("User cannot be found");
      else {
          UserEntity userEntity = new UserEntity();
          BeanUtils.copyProperties(user, userEntity);
          userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
          String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);
     UserEntity savedUser =  userRepository.save(userEntity);
          UserDto returnValue = new UserDto();
          BeanUtils.copyProperties(savedUser, returnValue);
          return returnValue;


      }
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity foundUser = userRepository.findByEmail(email);
        if(foundUser == null) throw new UsernameNotFoundException(email);
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
        if(userEntity == null)
            throw new UsernameNotFoundException(userId);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity foundUser = userRepository.findByEmail(email);
        if(foundUser == null){
            throw new UsernameNotFoundException(email);
        }

        return new User(foundUser.getEmail(), foundUser.getEncryptedPassword(), new ArrayList<>());
   }

}
