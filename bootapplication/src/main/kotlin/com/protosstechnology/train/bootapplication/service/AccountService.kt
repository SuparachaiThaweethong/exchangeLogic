package com.protosstechnology.train.bootapplication.service

import com.protosstechnology.train.bootapplication.entity.*
import com.protosstechnology.train.bootapplication.repository.accountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {
    @Autowired
    lateinit var accountRepository: accountRepository

    fun createAccount(account: Account): String{
        if(account.age!! < 10){
            return "A"
        }else if(account.amount!!< 1000){
            return "AM"
        }else{
            return "P"
        }

    }

    fun checkDetail(account: exchangeMoney) : Response? {
        return accountRepository.findByAccountNo(account.accountNo)?.let{
            Response(
                accountNo = it.accountNo!!,
                gender = it.gender,
                firstName = it.firstName!!,
                lastName = it.lastName,
                age = it.age!!,
                tel = it.tel,
                amount = it.amount!!
            )
        }
    }
    fun miniDetail(account: Account) : ResponseM? {
        return accountRepository.findByAccountNo(account.accountNo!!)?.let{
            ResponseM(
                accountNo = it.accountNo!!,
                firstName = it.firstName!!,
                lastName = it.lastName
            )
        }
    }

    fun AMDetail(accountNo: Long) : ResponseAM? {
        return accountRepository.findByAccountNo(accountNo)?.let{
            ResponseAM(
                amount = it.amount!!,
                accountNo = it.accountNo!!,
            )
        }
    }

    fun withDraw(account: exchangeMoney) : exchangeMoney?{
        if(account.currency > account.amount){
            return null;
        }else {
            val left = account.amount - account.currency
            var changing = accountRepository.findByAccountNo(account.accountNo)
            val current = accountRepository.findByAccountNo(account.accountNo)?.let {
                changing?.amount = left
                accountRepository.save(changing!!)
                exchangeMoney(
                    accountNo = it.accountNo!!,
                    amount = left,
                    currency = account.currency,
                )
            }
            return current
        }

    }

    fun deleteDetail(accountNo: Long):deleteStatus?{
        return accountRepository.findByAccountNo(accountNo)?.let{
            accountRepository.deleteByAccountNo(accountNo)
            deleteStatus(
                status = true!!,
                accountNo = accountNo,
            )
        }
    }


}