package com.study.bank.service;
import com.study.bank.common.Message;
import com.study.bank.dto.UserRequestDto;
import com.study.bank.dto.DepositsRequestDto;
import com.study.bank.dto.SendRequestDto;
import com.study.bank.dto.WithdrawalsRequestDto;
import com.study.bank.entity.Bank;
import com.study.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    //계좌 정보 생성
    public ResponseEntity<Message> addAccount(UserRequestDto bankRequestDto) {
        Bank bank = new Bank(bankRequestDto);
        bankRepository.save(bank);
        return new ResponseEntity<>(new Message("계좌가 생성되었습니다.", null), HttpStatus.OK);
    }
    //계좌조회
    public ResponseEntity<Message> getAccounts(Long id) {
        Bank bank = bankRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("계좌를 찾을 수 없습니다.")
        );
        return new ResponseEntity<>(new Message("계좌를 찾았습니다.", bank), HttpStatus.OK);
    }
    //계좌이체
    public ResponseEntity<Message> sendMoney(SendRequestDto sendRequestDto) {
        return new ResponseEntity<>(new Message("", null), HttpStatus.OK);
    }
    //입금
    public ResponseEntity<Message> depositsMoney(DepositsRequestDto depositsRequestDto) {
        return new ResponseEntity<>(new Message("", null), HttpStatus.OK);
    }
    //출금
    public ResponseEntity<Message> withdrawalsMoney(WithdrawalsRequestDto withdrawalsRequestDto) {
        return new ResponseEntity<>(new Message("", null), HttpStatus.OK);
    }
}
