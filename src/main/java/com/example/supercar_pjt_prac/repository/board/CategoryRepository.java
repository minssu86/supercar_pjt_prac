package com.example.supercar_pjt_prac.repository.board;

import com.example.supercar_pjt_prac.domain.board.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCaSeq(Long categoryNo);
}
