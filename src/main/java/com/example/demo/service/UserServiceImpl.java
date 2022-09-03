package com.example.demo.service;

import com.example.demo.Exception.UserDoesNotExistException;
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
 com.example.demo.utils.utils utils;

 @Autowired
 BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user ) {
      UserEntity foundUser =  userRepository.findByEmail(user.getEmail());
      if(foundUser != null) {
          throw new UserDoesNotExistException("User cannot be found");
      }
      else {
          //create an object
          UserEntity userEntity = new UserEntity();
          //copy from source to the target
          BeanUtils.copyProperties(user, userEntity);
          String publicUserId = utils.generateUserId(30);

          userEntity.setEncryptedPassword(publicUserId);
          userEntity.setUserId(bCryptPasswordEncoder.encode(user.getPassword()));
          //saving the user to repository
          UserEntity savedUser = userRepository.save(userEntity);
          //create object of Dto
          UserDto returnValue = new UserDto();
          //copy from source to target
          BeanUtils.copyProperties(savedUser, returnValue);
          return returnValue;


      }
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
