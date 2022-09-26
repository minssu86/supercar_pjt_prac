package com.example.supercar_pjt_prac.domain.post;

import com.example.supercar_pjt_prac.domain.Comment;
import com.example.supercar_pjt_prac.domain.Timestamped;
import com.example.supercar_pjt_prac.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brdSeq;
    private String brdTitle;
    private String brdContents;
    private int brdLikeCount;
    private int brdViewCount;
    private int brdCmtCount;
    private int brdBlameCount;
    private LocalDateTime modifiedDate;
    @ManyToOne
    @JoinColumn(name = "ca_seq")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<Comment>();

    public void setCategory(Category category){
        this.category = category;
        if(!category.getBoards().contains(this)){ // 무한루프 방지
            category.getBoards().add(this);
        }
    }

    public void addComment (Comment comment){
        this.comments.add(comment);
        if(comment.getBoard() != this){ // 무한루프 방지
            comment.setBoard(this);
        }
    }

}
