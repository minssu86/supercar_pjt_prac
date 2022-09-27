package com.example.supercar_pjt_prac.domain.user;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Dealer {

    @Id
    private Long userSeq;
    @MapsId     // Dealer.userId 매핑
    @OneToOne
    @JoinColumn(name = "user_seq")
    private User user;
    @Column(nullable = false)
    private String dlrName;
    @Column(nullable = false)
    private String dlrNumber;
    @Column(nullable = false)
    private String dlrAttachment;
    @Column(nullable = false)
    private String dlrAttachment2;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "guild_seq", nullable = false)
    private Guild guild;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "com_seq", nullable = false)
    private Company company;

    public void setGuild(Guild guild){
        this.guild = guild;
        if(!guild.getDealers().contains(this)){ // 무한루프 방지
            guild.getDealers().add(this);
        }
    }

    public void setCompany(Company company){
        this.company = company;
        if(!company.getDealers().contains(this)){ // 무한루프 방지
            company.getDealers().add(this);
        }
    }


}
