package com.example.supercar_pjt_prac.domain.user;

import com.example.supercar_pjt_prac.domain.Timestamped;
import com.example.supercar_pjt_prac.domain.user.Dealer;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "\"user\"")
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userNickname;
    private String userProfileUrl;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String userPhone;
    @Column(nullable = false)
    private String userRating;
    @Column(nullable = false)
    private String userRole;
    private String userSocial;
    @OneToOne(mappedBy =  "user", fetch = FetchType.LAZY)
    private Dealer dealer;

}
