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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Rollback(value = false)
@DataJpaTest
public class RepositoryTest {

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

    @BeforeEach
    void beforeEach(){
        userRepository.save(user);
    }

    @Test
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

    @Test
    void dealerTest() {

        // Given
        User user = userRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("널")
        );

        Guild guild = Guild.builder()
                .guildName("조합명")
                .guildAddress("조합 주소")
                .guildRegNum("조합 등록번호")
                .guildPhone("조합 사무실 번호")
                .build();
        guildRepository.save(guild);
        guild = guildRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("null")
        );

        Company company = Company.builder()
                .comName("회사명")
                .comAddress("회사 주소")
                .comRegNum("사업자 등록번호")
                .comPhone("사무실 번호")
                .build();
        companyRepository.save(company);
        company = companyRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("null")
        );

        Dealer dealer = Dealer.builder()
                .user(user)
                .dlrName("딜러이름")
                .dlrNumber("딜러번호")
                .dlrAttachment("딜러증 앞")
                .dlrAttachment2("딜러증 뒤")
                .guild(guild)
                .company(company)
                .build();
//        dealer.setGuild(guild);
//        dealer.setCompany(company);

        dealerRepository.save(dealer);

        // When

        // Then

    }


}
