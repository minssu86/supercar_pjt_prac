package com.example.supercar_pjt_prac.domain.board.product;

import javax.persistence.*;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caSeq;
    @Column(nullable = false)
    private String caName;

}
