package com.study.bank.dto;

import lombok.Getter;

@Getter
public class WithdrawalsRequestDto {
    private String account;
    private Long withdrawalsMoney;
}
