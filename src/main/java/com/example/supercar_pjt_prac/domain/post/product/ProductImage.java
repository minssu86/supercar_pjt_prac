package com.example.supercar_pjt_prac.domain.post.product;


import lombok.Getter;

import javax.persistence.*;
@Getter
@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdiSeq;
    @Column(nullable = false)
    private String pdiUrl;
    @ManyToOne
    @JoinColumn(name = "brd_seq", nullable = false)
    private Product product;

    public void setProduct(Product product){
        this.product = product;
        if(!product.getProductImages().contains(this)){ // 무한루프 방지
            product.getProductImages().add(this);
        }
    }
}
