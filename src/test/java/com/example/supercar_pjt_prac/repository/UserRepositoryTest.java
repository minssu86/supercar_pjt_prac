package com.example.supercar_pjt_prac.repository;

import com.example.supercar_pjt_prac.domain.user.Company;
import com.example.supercar_pjt_prac.domain.user.Dealer;
import com.example.supercar_pjt_prac.domain.user.Guild;
import com.example.supercar_pjt_prac.domain.user.User;
import com.example.supercar_pjt_prac.repository.user.CompanyRepository;
import com.example.supercar_pjt_prac.repository.user.DealerRepository;
import com.example.supercar_pjt_prac.repository.user.GuildRepository;
import com.example.supercar_pjt_prac.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@Rollback(value = false)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DealerRepository dealerRepository;
    @Autowired
    GuildRepository guildRepository;
    @Autowired
    CompanyRepository companyRepository;

    User user = User.builder()
            .userId("tester1")
            .userPassword("123123")
            .userNickname("nickname")
            .userProfileUrl("profileurl")
            .userEmail("naver@naver.com")
            .userPhone("010-0101-0001")
            .userRating("등급")
            .userRole("권한")
            .build();

    Guild guild = Guild.builder()
            .guildName("조합명")
            .guildAddress("조합 주소")
            .guildRegNum("조합 등록번호")
            .guildPhone("조합 사무실 번호")
            .dealers(new ArrayList<>())
            .build();

    Company company = Company.builder()
            .comName("회사명")
            .comAddress("회사 주소")
            .comRegNum("사업자 등록번호")
            .comPhone("사무실 번호")
            .dealers(new ArrayList<>())
            .build();

    @BeforeEach
    void beforeEach(){
        userRepository.save(user);
        guildRepository.save(guild);
        companyRepository.save(company);
    }

    @Test
    @DisplayName("유저 테스트")
    void userTest() {
        // Given
        // When
        User result = userRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("널")
        );

        // Then
        assertThat(result).isSameAs(user);
        assertThat(result.getUserId()).isEqualTo(user.getUserId());
        assertThat(result.getUserPassword()).isEqualTo(user.getUserPassword());
        assertThat(result.getUserNickname()).isEqualTo(user.getUserNickname());
        assertThat(result.getUserProfileUrl()).isEqualTo(user.getUserProfileUrl());
        assertThat(result.getUserEmail()).isEqualTo(user.getUserEmail());
        assertThat(result.getUserPhone()).isEqualTo(user.getUserPhone());
        assertThat(result.getUserRating()).isEqualTo(user.getUserRating());
        assertThat(result.getUserRole()).isEqualTo(user.getUserRole());
        assertThat(result.getUserSocial()).isEqualTo(null);



    }


    @DisplayName("딜러,상사,조합 테스트")
    @Test
    void dealerAndCompanyAndGuildTest() {

        // Given
        User user = userRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("널")
        );

        guild = guildRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("null")
        );

        company = companyRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("null")
        );

        Dealer dealer = Dealer.builder()
                .user(user)
                .dlrName("딜러이름")
                .dlrNumber("딜러번호")
                .dlrAttachment("딜러증 앞")
                .dlrAttachment2("딜러증 뒤")
                .build();
        dealer.setGuild(guild);
        dealer.setCompany(company);

        dealerRepository.save(dealer);

        // When
        Dealer result = dealerRepository.findById(user.getUserSeq()).orElseThrow(
                () -> new NullPointerException("null")
        );
        // Then
        assertThat(result).isEqualTo(dealer);
        assertThat(result.getDlrName()).isEqualTo("딜러이름");
        assertThat(result.getCompany()).isEqualTo(company);
        assertThat(result.getGuild()).isEqualTo(guild);
        assertThat(result.getCompany().getComName()).isEqualTo("회사명");
        assertThat(result.getGuild().getGuildName()).isEqualTo("조합명");
    }

}
