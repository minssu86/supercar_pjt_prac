package com.example.supercar_pjt_prac.domain.post.product;

import com.example.supercar_pjt_prac.domain.id.BoardCategoryId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class BoardCategoryMapping {

    @EmbeddedId
    private BoardCategoryId boardCategoryId;

}
