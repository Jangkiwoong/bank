package com.study.bank.entity;

import com.study.bank.dto.AccountRequestDto;
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
    private Long money;

    //유저 정보 생성
    public Bank(AccountRequestDto bankRequestDto) {
        this.userName = bankRequestDto.getUserName();
        this.accountNumber = bankRequestDto.getAccountNumber();
        this.money = bankRequestDto.getMoney();
    }
    //계좌이체(내 계좌)
    public void setMyMoney(Long transferMoney) {
        if (transferMoney <= 0) {
            throw new IllegalArgumentException("이체 금액은 0보다 커야 합니다.");
        }
        if (this.money < transferMoney) {
            throw new IllegalStateException("잔액이 부족합니다.");
        }
        this.money -= transferMoney;
    }
    //계좌이체(상대 계좌)
    public void setRelativeAccount(Long transferMoney) {
        if (transferMoney <= 0) {
            throw new IllegalArgumentException("이체 금액은 0보다 커야 합니다.");
        }
        this.money += transferMoney;
    }
}
