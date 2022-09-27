package com.example.supercar_pjt_prac.domain.board.paparazzi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "paparazi_attachement")
public class PaparazziAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pattSeq;
    @Column(nullable = false)
    private String pattAttachementUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brd_seq", nullable = false)
    private Paparazzi paparazzi;

    public void setPaparazzi(Paparazzi paparazzi){
        this.paparazzi = paparazzi;
        if(!paparazzi.getPaparazziAttachments().contains(this)){ // 무한루프 방지
            paparazzi.getPaparazziAttachments().add(this);
        }
    }

}
