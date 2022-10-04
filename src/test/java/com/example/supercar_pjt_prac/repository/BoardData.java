package com.example.supercar_pjt_prac.repository;

import com.example.supercar_pjt_prac.domain.board.Category;
import com.example.supercar_pjt_prac.domain.board.Download;
import com.example.supercar_pjt_prac.repository.board.CategoryRepository;
import com.example.supercar_pjt_prac.repository.board.DownloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class BoardData {

    @Autowired
    DownloadRepository downloadRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public void createCategory(){

        String[] categoryList = {"자료실","매거진","매물","파파라치"};

        for (String categoryName:categoryList){
            Category category = Category.builder()
                    .caName(categoryName)
                    .boards(new ArrayList<>())
                    .build();
            categoryRepository.save(category);
        }

    }

    public void createDownload(Long categoryNo){
        Category category = categoryRepository.findByCaSeq(categoryNo);
        for(int i=1; i<=10; i++){
            Download download = Download.builder()
                    .brdTitle("게시판 제목"+i)
                    .brdContents("게시판 내용"+i)
                    .brdLikeCount(i)
                    .brdViewCount(i)
                    .brdCmtCount(i)
                    .brdBlameCount(i)
                    .modifiedDate(LocalDateTime.now())
                    .build();
            download.setCategory(category);
            downloadRepository.save(download);
        }

    }

}
