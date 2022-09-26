package com.example.supercar_pjt_prac.domain;

import com.example.supercar_pjt_prac.domain.id.UserProductId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class UserProductMapping {

    @EmbeddedId
    private UserProductId userProductId;

}
