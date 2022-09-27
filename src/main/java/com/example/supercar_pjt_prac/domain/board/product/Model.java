package com.example.supercar_pjt_prac.domain.board.product;

import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelSeq;
    @Column(nullable = false)
    private String modelName;
    private String modelTrim;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_seq", nullable = false)
    private Brand brand;
}
