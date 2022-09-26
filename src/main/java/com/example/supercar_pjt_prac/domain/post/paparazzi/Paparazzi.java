package com.example.supercar_pjt_prac.domain.post.paparazzi;

import com.example.supercar_pjt_prac.domain.post.Board;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorValue("PP")
public class Paparazzi extends Board {

    @Enumerated(value = EnumType.STRING)
    private PrzRating przRating;
    @OneToMany(mappedBy = "paparazzi")
    private List<PaparazziAttachment> paparazziAttachments = new ArrayList<PaparazziAttachment>();

    public void addPattAttachment (PaparazziAttachment paparazziAttachment){
        this.paparazziAttachments.add(paparazziAttachment);
        if(paparazziAttachment.getPaparazzi() != this){ // 무한루프 방지
            paparazziAttachment.setPaparazzi(this);
        }
    }
}
