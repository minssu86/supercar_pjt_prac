package com.example.supercar_pjt_prac.domain.board.product;

import javax.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandSeq;
    @Column(nullable = false)
    private String brandName;

}
