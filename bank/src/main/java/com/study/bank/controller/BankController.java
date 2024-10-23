package com.study.bank.controller;

import com.study.bank.common.Message;
import com.study.bank.dto.AccountRequestDto;
import com.study.bank.dto.DepositsRequestDto;
import com.study.bank.dto.TransferRequestDto;
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
    public ResponseEntity<Message> addAccount (@RequestBody AccountRequestDto bankRequestDto) {
        return bankService.addAccount(bankRequestDto);
    }
    @GetMapping("/get/all/accounts")
    public ResponseEntity<Message> getAllAccounts () {
        return bankService.getAllAccounts();
    }
    //계좌 조회
    @GetMapping("/get/accounts")
    public ResponseEntity<Message> getAccounts (@RequestParam Long id) {
        return bankService.getAccounts(id);
    }
    //계좌 이체
    @PutMapping("/update/send/money")
    public ResponseEntity<Message> transferMoney (@RequestBody TransferRequestDto transferRequestDto) {
        return bankService.transferMoney(transferRequestDto);
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
