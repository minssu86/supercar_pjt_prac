package com.example.supercar_pjt_prac.repository;

import com.example.supercar_pjt_prac.domain.board.Board;
import com.example.supercar_pjt_prac.domain.board.Download;
import com.example.supercar_pjt_prac.domain.board.magazine.Magazine;
import com.example.supercar_pjt_prac.repository.board.DownloadRepository;
import com.example.supercar_pjt_prac.repository.board.MagazineRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Rollback(value = false)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    DownloadRepository downloadRepository;
//    @Autowired
//    MagazineRepository magazineRepository;

    @Test
    @DisplayName("다운로드 테스트")
    void DownloadTest() {

        // Given
        Download download = Download.builder()
                .brdTitle("게시판 제목")
                .brdContents("게시판 내용")
                .brdLikeCount(10)
                .brdViewCount(11)
                .brdCmtCount(13)
                .brdBlameCount(22)
                .modifiedDate(LocalDateTime.now())
                .build();

        downloadRepository.save(download);

        // When
        Download result = downloadRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("null")
        );

        // Then
        assertThat(result).isEqualTo(download);
        assertThat(result.getBrdTitle()).isEqualTo("게시판 제목");
        assertThat(result.getCreateDate()).isNotNull();

    }

    @Test
    void MagazineTest() {

        // Given


        // When


        // Then


    }
}
