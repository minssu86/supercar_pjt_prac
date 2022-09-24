package com.example.supercar_pjt_prac.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    @GetMapping("/getmapping")
    public void getTest(){

    }


}
