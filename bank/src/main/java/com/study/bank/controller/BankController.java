package com.study.bank.controller;

import com.study.bank.common.Message;
import com.study.bank.dto.UserRequestDto;
import com.study.bank.dto.DepositsRequestDto;
import com.study.bank.dto.SendRequestDto;
import com.study.bank.dto.WithdrawalsRequestDto;
import com.study.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;
    //계좌 정보 생성
    @PostMapping("/add/account")
    public ResponseEntity<Message> addAccount (@RequestBody UserRequestDto bankRequestDto) {
        return bankService.addAccount(bankRequestDto);
    }
    //계좌 조회
    @GetMapping("/get/accounts")
    public ResponseEntity<Message> getAccounts () {
        return bankService.getAccounts();
    }
    //계좌 이체
    @PutMapping("/update/send/money")
    public ResponseEntity<Message> sendMoney (@RequestBody SendRequestDto sendRequestDto) {
        return bankService.sendMoney(sendRequestDto);
    }
    //입금
    @PutMapping("/update/deposits/money")
    public ResponseEntity<Message> depositsMoney (@RequestBody DepositsRequestDto depositsRequestDto) {
        return bankService.depositsMoney(depositsRequestDto);
    }
    //출금
    @PutMapping("/update/withdrawals/money")
    public ResponseEntity<Message> withdrawalsMoney (@RequestBody WithdrawalsRequestDto withdrawalsRequestDto) {
        return bankService.withdrawalsMoney(withdrawalsRequestDto);
    }
}
