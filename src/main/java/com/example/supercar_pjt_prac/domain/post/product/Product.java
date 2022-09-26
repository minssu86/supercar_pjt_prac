package com.example.supercar_pjt_prac.domain.post.product;

import com.example.supercar_pjt_prac.domain.post.Board;
import com.example.supercar_pjt_prac.domain.user.Dealer;
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
    @OneToOne(mappedBy = "product")
    private ProductInformation productInformation;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<ProductImage>();

    public void addProductImage (ProductImage productImage){
        this.productImages.add(productImage);
        if(productImage.getProduct() != this){      // 무한루프 방지
            productImage.setProduct(this);
        }
    }
}
