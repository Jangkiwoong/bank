package com.study.bank.repository;

import com.study.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {
    //계좌이체
    Optional<Bank> findByAccount(String myAccount);
}
