package com.example.supercar_pjt_prac.domain;

import com.example.supercar_pjt_prac.domain.id.UserBoardId;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class UserBoardMapping {
    @EmbeddedId
    private UserBoardId userBoardId;

}
