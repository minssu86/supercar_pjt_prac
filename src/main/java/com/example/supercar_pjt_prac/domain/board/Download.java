package com.example.supercar_pjt_prac.domain.board;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("D")
public class Download extends Board{

}
