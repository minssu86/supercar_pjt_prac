package com.example.supercar_pjt_prac.repository.board;

import com.example.supercar_pjt_prac.domain.board.Download;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DownloadRepository extends JpaRepository<Download, Long> {
    List<Download> findAllByOrderByBrdSeqDesc();
}
