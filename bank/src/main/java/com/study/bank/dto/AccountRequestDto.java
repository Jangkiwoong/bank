package com.study.bank.dto;

import lombok.Getter;

@Getter
public class AccountRequestDto {
    private String userName;
    private String accountNumber;
    private Long money;
}