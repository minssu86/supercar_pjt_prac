package com.example.supercar_pjt_prac.domain.board.magazine;

import com.example.supercar_pjt_prac.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@AllArgsConstructor
//@SuperBuilder
//@RequiredArgsConstructor
@Entity
@Getter
@DiscriminatorValue("M")
public class Magazine extends Board {

    @Column(nullable = false)
    private String mgzBannerImageUrl;
    @OneToMany(mappedBy = "magazine", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<MagazineAttachment> magazineAttachments = new ArrayList<MagazineAttachment>();

    public void addMgzAttachment (MagazineAttachment magazineAttachment){
        this.magazineAttachments.add(magazineAttachment);
        if(magazineAttachment.getMagazine() != this){ // 무한루프 방지
            magazineAttachment.setMagazine(this);
        }
    }
}
