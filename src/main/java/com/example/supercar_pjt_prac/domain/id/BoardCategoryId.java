package com.example.supercar_pjt_prac.domain.id;

import com.example.supercar_pjt_prac.domain.post.product.ProductCategory;
import com.example.supercar_pjt_prac.domain.post.product.Product;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class BoardCategoryId implements Serializable {

    @JoinColumn(name = "brd_seq")
    @ManyToOne
    private Product product;

    @JoinColumn(name = "ca_seq")
    @ManyToOne
    private ProductCategory productCategory;

}
