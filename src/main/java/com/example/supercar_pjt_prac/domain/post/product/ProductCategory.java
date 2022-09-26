package com.example.supercar_pjt_prac.domain.post.product;

import javax.persistence.*;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caSeq;
    @Column(nullable = false)
    private String caName;

}
