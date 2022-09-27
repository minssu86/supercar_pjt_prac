package com.example.supercar_pjt_prac.domain.board.magazine;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "magazine_attachment")
public class MagazineAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mattSeq;
    @Column(nullable = false)
    private String mattAttachmentUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brd_seq", nullable = false)
    private Magazine magazine;

    public void setMagazine(Magazine magazine){
        this.magazine = magazine;
        if(!magazine.getMagazineAttachments().contains(this)){ // 무한루프 방지
            magazine.getMagazineAttachments().add(this);
        }
    }

}
