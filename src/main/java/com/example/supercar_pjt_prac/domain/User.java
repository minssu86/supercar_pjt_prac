package com.example.supercar_pjt_prac.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "userInfo")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long userSeq;

    private String userId;
    private String userPassword;
    private String userNickname;
    private String userProfileUrl;
    private String userEmail;
    private String userPhone;
    private String userRating;
    private String userRole;
    private String userSocial;

}
