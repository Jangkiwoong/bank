package com.study.bank.service;

import com.study.bank.dto.TransferRequestDto;
import com.study.bank.entity.Bank;
import com.study.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final BankRepository bankRepository;
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void trasferMoney2(TransferRequestDto transferRequestDto) {
        Bank relativeAccount = bankRepository.findByAccount(transferRequestDto.getRelativeAccount()).orElseThrow(
                () -> new IllegalArgumentException("계좌를 찾을 수 없습니다.")
        );
        System.out.println( "현재 상대 잔고 : "+ relativeAccount.getMoney());
        relativeAccount.transferRelativeAccount(transferRequestDto.getTransferMoney());
        System.out.println( "현재 상대 잔고 : "+ relativeAccount.getMoney());
        bankRepository.save(relativeAccount); // 상대방 계좌에 금액을 저장
    }
}
