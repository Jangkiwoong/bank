package com.study.bank.dto;

import lombok.Getter;

@Getter
public class SendRequestDto {
    private String myAccount;
    private String relativeAccount;
    private Long transferMoney;
}
