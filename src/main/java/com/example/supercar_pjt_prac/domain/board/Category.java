package com.example.supercar_pjt_prac.domain.board;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caSeq;
    @Column(nullable = false)
    private String caName;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Board> boards = new ArrayList<>();

    public void addBoard (Board board){
        this.boards.add(board);
        if(board.getCategory() != this){ // 무한루프 방지
            board.setCategory(this);
        }
    }
}
