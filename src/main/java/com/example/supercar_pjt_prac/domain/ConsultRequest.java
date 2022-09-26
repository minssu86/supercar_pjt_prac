package com.example.supercar_pjt_prac.domain;

import com.example.supercar_pjt_prac.domain.id.UserBoardId;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ConsultRequest {

    @EmbeddedId
    private UserBoardId userBoardId;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ConsultStatus consultStatus;

}
