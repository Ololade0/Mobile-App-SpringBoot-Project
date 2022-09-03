package com.example.demo.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;


@Setter
@Getter
@Entity
public class UserEntity implements Serializable {
    private static final long serialVersionUid = 1L;
    @javax.persistence.Id
    @Id
    @GeneratedValue
    private long id;

@Column(nullable = false)
    private String userId;

@Column(nullable = false, length = 50)
    private  String firstName;

    @Column(nullable = false, length = 50)
    private  String lastName;

    @Column(nullable = false, length = 1200, unique = true)
    private  String email;

    @Column(nullable = false)
    private  String encryptedPassword;

    private  String emailVerificationToken;

    @Column(nullable = false)
    private  Boolean emailVerificationStatus = false ;
}
