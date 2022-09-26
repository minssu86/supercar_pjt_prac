package com.example.supercar_pjt_prac.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comSeq;
    @Column(nullable = false)
    private String comName;
    @Column(nullable = false)
    private String comAddress;
    @Column(nullable = false)
    private String comRegNum;
    @Column(nullable = false)
    private String comPhone;
    @OneToMany(mappedBy = "company")
    private List<Dealer> dealers = new ArrayList<Dealer>();

    public void addDealer (Dealer dealer){
        this.dealers.add(dealer);
        if(dealer.getCompany() != this){      // 무한루프 방지
            dealer.setCompany(this);
        }
    }
}
