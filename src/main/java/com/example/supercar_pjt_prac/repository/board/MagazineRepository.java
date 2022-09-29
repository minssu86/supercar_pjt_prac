package com.example.supercar_pjt_prac.repository.board;

import com.example.supercar_pjt_prac.domain.board.magazine.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {
}
