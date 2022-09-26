package com.example.supercar_pjt_prac.domain.post.magazine;

import com.example.supercar_pjt_prac.domain.post.Board;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorValue("M")
public class Magazine extends Board {

    @Column(nullable = false)
    private String mgzBannerImageUrl;
    @OneToMany(mappedBy = "magazine")
    private List<MagazineAttachment> magazineAttachments = new ArrayList<MagazineAttachment>();

    public void addMgzAttachment (MagazineAttachment magazineAttachment){
        this.magazineAttachments.add(magazineAttachment);
        if(magazineAttachment.getMagazine() != this){ // 무한루프 방지
            magazineAttachment.setMagazine(this);
        }
    }
}
