package com.protosstechnology.train.bootapplication.repository

import com.protosstechnology.train.bootapplication.entity.Account
import com.protosstechnology.train.bootapplication.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface accountRepository: JpaRepository<Account, Long> {
    fun findByAccountNo(accountNo : Long) : Account?

    fun deleteByAccountNo(accountNo : Long)

}