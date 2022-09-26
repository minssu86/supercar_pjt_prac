package com.example.supercar_pjt_prac.domain.post.product;

import com.example.supercar_pjt_prac.domain.user.User;

import javax.persistence.*;

@Entity
public class ProductInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pinfSeq;
    private String pinfCarNumber;
    private String pinfRegDate;
    private String pinfYear;
    private int pinfCc;
    @Enumerated(value = EnumType.STRING)
    private PinfTransmissionType pinfTransmissionType;
    private int pinfMileage;
    private String pinfColor;
    private Boolean pinfAccidentHistory;
    private  PinfFuel pinfFuel;
    @OneToOne
    @JoinColumn(name = "model_seq")
    private Model model;
    @OneToOne
    @JoinColumn(name = "brd_seq")
    private Product product;

}
