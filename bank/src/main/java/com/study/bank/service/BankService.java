package com.study.bank.service;
import com.study.bank.common.Message;
import com.study.bank.dto.AccountRequestDto;
import com.study.bank.dto.DepositsRequestDto;
import com.study.bank.dto.TransferRequestDto;
import com.study.bank.dto.WithdrawalsRequestDto;
import com.study.bank.entity.Bank;
import com.study.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    //계좌 정보 생성
    @Transactional
    public ResponseEntity<Message> addAccount(AccountRequestDto bankRequestDto) {
        Bank bank = new Bank(bankRequestDto);
        bankRepository.save(bank);
        return new ResponseEntity<>(new Message("계좌가 생성되었습니다.", null), HttpStatus.OK);
    }
    //계좌조회
    @Transactional
    public ResponseEntity<Message> getAccount(Long id) {
        Bank bank = bankRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("계좌를 찾을 수 없습니다.")
        );
        return new ResponseEntity<>(new Message("계좌를 찾았습니다.", bank), HttpStatus.OK);
    }
    //계좌이체
    @Transactional
    public ResponseEntity<Message> transferMoney(TransferRequestDto transferRequestDto) {
        Bank myAccount = bankRepository.findByAccount(transferRequestDto.getMyAccount()).orElseThrow(
                () -> new IllegalArgumentException("계좌를 찾을 수 없습니다.")
        );
        Bank relativeAccount = bankRepository.findByAccount(transferRequestDto.getRelativeAccount()).orElseThrow(
                () -> new IllegalArgumentException("계좌를 찾을 수 없습니다.")
        );
        myAccount.transferMyMoney(transferRequestDto.getTransferMoney());
        relativeAccount.transferRelativeAccount(transferRequestDto.getTransferMoney());
        bankRepository.saveAndFlush(myAccount);
        bankRepository.saveAndFlush(relativeAccount);
        return new ResponseEntity<>(new Message("이체가 완료되었습니다.", myAccount), HttpStatus.OK);
    }
    //입금
    @Transactional
    public ResponseEntity<Message> depositsMoney(DepositsRequestDto depositsRequestDto) {
        Bank bank = bankRepository.findByAccount(depositsRequestDto.getAccount()).orElseThrow(
                () -> new IllegalArgumentException("계좌를 찾을 수 없습니다.")
        );
        bank.depositsMoney(depositsRequestDto);
        bankRepository.saveAndFlush(bank);
        return new ResponseEntity<>(new Message("입금이 완료 되었습니다.", bank), HttpStatus.OK);
    }
    //출금
    @Transactional
    public ResponseEntity<Message> withdrawalsMoney(WithdrawalsRequestDto withdrawalsRequestDto) {
        Bank bank = bankRepository.findByAccount(withdrawalsRequestDto.getAccount()).orElseThrow(
                () -> new IllegalArgumentException("계좌를 찾을 수 없습니다.")
        );
        bank.withdrawalsMoney(withdrawalsRequestDto);
        return new ResponseEntity<>(new Message("출금이 완료 되었습니다.", null), HttpStatus.OK);
    }
    //모든 계좌 조회
    public ResponseEntity<Message> getAllAccount() {
        List<Bank> bankList = bankRepository.findAll();
        return new ResponseEntity<>(new Message("모든 계좌를 조회 하였습니다.", bankList), HttpStatus.OK);
    }
}
