package com.example.supercar_pjt_prac.domain.board.product;

import com.example.supercar_pjt_prac.domain.board.Board;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@DiscriminatorValue("PD")
public class Product extends Board {

    @Column(nullable = false)
    private String pdtSubtitle;
    @Column(nullable = false)
    private Long pdtPrice;
    private String pdtPerformanceUrl;
    @Column(nullable = false)
    private String pdtInsuranceUrl;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PdtStatus pdtStatus;
    @Column(nullable = false)
    private Boolean pdtAppear;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PdtRating pdtRating;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PdtSellType pdtSellType;
    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
    private ProductInformation productInformation;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ProductImage> productImages = new ArrayList<ProductImage>();

    public void addProductImage (ProductImage productImage){
        this.productImages.add(productImage);
        if(productImage.getProduct() != this){      // 무한루프 방지
            productImage.setProduct(this);
        }
    }
}
