package com.study.bank.dto;

import lombok.Getter;

@Getter
public class DepositsRequestDto {
    private String account;
    private Long depositsMoney;
}
