package com.example.supercar_pjt_prac.domain.post.product;

import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelSeq;
    @Column(nullable = false)
    private String modelName;
    private String modelTrim;
    @ManyToOne
    @JoinColumn(name = "brand_seq", nullable = false)
    private Brand brand;
}
