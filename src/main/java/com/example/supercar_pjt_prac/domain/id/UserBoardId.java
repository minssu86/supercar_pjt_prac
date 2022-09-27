package com.example.supercar_pjt_prac.domain.id;

import com.example.supercar_pjt_prac.domain.board.Board;
import com.example.supercar_pjt_prac.domain.user.User;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class UserBoardId implements Serializable {

    @JoinColumn(name = "user_seq")
    @ManyToOne
    private User user;

    @JoinColumn(name = "brd_seq")
    @ManyToOne
    private Board board;

}
