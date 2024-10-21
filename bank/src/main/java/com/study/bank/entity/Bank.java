package com.study.bank.entity;

import com.study.bank.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String accountNumber;

    @Column
    private String money;

    //유저 정보 생성
    public Bank(UserRequestDto bankRequestDto) {
        this.userName = bankRequestDto.getUserName();
        this.accountNumber = bankRequestDto.getAccountNumber();
        this.money = bankRequestDto.getMoney();
    }
}
