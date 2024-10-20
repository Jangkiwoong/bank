package com.study.bank.service;
import com.study.bank.common.Message;
import com.study.bank.dto.UserRequestDto;
import com.study.bank.dto.DepositsRequestDto;
import com.study.bank.dto.SendRequestDto;
import com.study.bank.dto.WithdrawalsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService {
    //유저 정보 생성
    public ResponseEntity<Message> addUser(UserRequestDto bankRequestDto) {
        return new ResponseEntity<>(new Message("", null), HttpStatus.OK);
    }
    //계좌조회
    public ResponseEntity<Message> getAccounts() {
        return new ResponseEntity<>(new Message("", null), HttpStatus.OK);
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
