package com.example.supercar_pjt_prac.domain.board;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@AllArgsConstructor
//@NoArgsConstructor
//@SuperBuilder
//@RequiredArgsConstructor
@Entity
@DiscriminatorValue("D")
public class Download extends Board{

}
