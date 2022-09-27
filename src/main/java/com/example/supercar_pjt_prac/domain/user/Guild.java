package com.example.supercar_pjt_prac.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.Identifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@Entity
@Getter
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guildSeq;
    @Column(nullable = false)
    private String guildName;
    @Column(nullable = false)
    private String guildAddress;
    @Column(nullable = false)
    private String guildRegNum;
    @Column(nullable = false)
    private String guildPhone;
    @OneToMany(mappedBy = "guild", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Dealer> dealers = new ArrayList<Dealer>();

    public void addDealer (Dealer dealer){
        this.dealers.add(dealer);
        if(dealer.getGuild() != this){      // 무한루프 방지
            dealer.setGuild(this);
        }
    }
}
