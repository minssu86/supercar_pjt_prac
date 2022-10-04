package com.example.supercar_pjt_prac.repository;

import com.example.supercar_pjt_prac.domain.board.Board;
import com.example.supercar_pjt_prac.domain.board.Category;
import com.example.supercar_pjt_prac.domain.board.Download;
import com.example.supercar_pjt_prac.domain.board.magazine.Magazine;
import com.example.supercar_pjt_prac.repository.board.CategoryRepository;
import com.example.supercar_pjt_prac.repository.board.DownloadRepository;
import com.example.supercar_pjt_prac.repository.board.MagazineRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardData boardData;
    @Autowired
    DownloadRepository downloadRepository;
    @Autowired
    CategoryRepository categoryRepository;
//    @Autowired
//    MagazineRepository magazineRepository;

    @Test
    @DisplayName("다운로드 테스트")
    @Transactional
    void DownloadTest() {

        // Given
        boardData.createCategory();
        boardData.createDownload(1L);

        // When
        List<Download> result = downloadRepository.findAllByOrderByBrdSeqDesc();

        // Then
        assertThat(result).hasSize(10);
        assertThat(result.get(0).getBrdTitle()).isEqualTo("게시판 제목10");
        assertThat(result.get(0).getBrdContents()).isEqualTo("게시판 내용10");
        assertThat(result.get(0).getBrdLikeCount()).isEqualTo(10);
        assertThat(result.get(0).getBrdViewCount()).isEqualTo(10);
        assertThat(result.get(0).getBrdCmtCount()).isEqualTo(10);
        assertThat(result.get(0).getBrdBlameCount()).isEqualTo(10);
        assertThat(result.get(0).getModifiedDate()).isNotNull();

    }

    @DisplayName("카테고리 테스트")
    @Test
    void createCategory() {

        // Given
        boardData.createCategory();

        // When
        List<Category> categoryList = categoryRepository.findAll();

        // Then
        assertThat(categoryList).hasSize(4);
        assertThat(categoryList.get(0).getCaSeq()).isEqualTo(1);
        assertThat(categoryList.get(0).getCaName()).isEqualTo("자료실");
        assertThat(categoryList.get(1).getCaSeq()).isEqualTo(2);
        assertThat(categoryList.get(1).getCaName()).isEqualTo("매거진");
        assertThat(categoryList.get(2).getCaSeq()).isEqualTo(3);
        assertThat(categoryList.get(2).getCaName()).isEqualTo("매물");
        assertThat(categoryList.get(3).getCaSeq()).isEqualTo(4);
        assertThat(categoryList.get(3).getCaName()).isEqualTo("파파라치");


    }

}
