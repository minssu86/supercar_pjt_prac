package com.example.supercar_pjt_prac.domain;

import com.example.supercar_pjt_prac.domain.board.Board;
import com.example.supercar_pjt_prac.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmtSeq;
    private Long likeCount;
    @Column(nullable = false)
    private String cmtContents;
    @Column(nullable = false)
    private Boolean isDelete;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brd_seq", nullable = false)
    private Board board;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;

    public void setBoard(Board board){
        this.board = board;
        if(!board.getComments().contains(this)){ // 무한루프 방지
            board.getComments().add(this);
        }
    }
}
