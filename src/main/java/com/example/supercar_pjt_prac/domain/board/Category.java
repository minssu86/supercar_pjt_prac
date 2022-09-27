package com.example.supercar_pjt_prac.domain.board;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caSeq;
    @Column(nullable = false)
    private String caName;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Board> boards = new ArrayList<Board>();

    public void addBoard (Board board){
        this.boards.add(board);
        if(board.getCategory() != this){ // 무한루프 방지
            board.setCategory(this);
        }
    }
}
