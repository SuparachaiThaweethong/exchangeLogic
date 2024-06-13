package com.protosstechnology.train.bootapplication.controller

import com.protosstechnology.train.bootapplication.entity.Account
import com.protosstechnology.train.bootapplication.entity.Response
import com.protosstechnology.train.bootapplication.entity.exchangeMoney
import com.protosstechnology.train.bootapplication.repository.accountRepository
import com.protosstechnology.train.bootapplication.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException.BadRequest
import kotlin.random.Random


@RestController
class AccountController {

    @Autowired
    private lateinit var accountService: AccountService

    @Autowired
    lateinit var accountRepository: accountRepository

    @PostMapping("/create")
    fun createAccount(@RequestBody account: Account) : ResponseEntity<Any> {
        val ac = accountService.createAccount(account)
        if (ac =="A") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Age need to older than  or equal 10 years.")
        }else if(ac =="AM"){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Amount need to more than 1000 baht.")
        }
        else {
            account.accountNo = Random.nextLong(1000000000, 9999999999)
            accountRepository.save(account)
            val text = accountService.miniDetail(account)
            return ResponseEntity.ok(text)
        }
    }
    @PostMapping("/detail")
    fun checkDetails(@RequestBody account: exchangeMoney) : ResponseEntity<Any> {
        val dt = accountService.checkDetail(account)
        if( dt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }else{
            return ResponseEntity.ok(dt)
        }
    }

    @PutMapping("/withdraw")
    fun withdrawAccount(@RequestBody account: exchangeMoney) : ResponseEntity<Any> {
        val ac = accountService.checkDetail(account)
        if(ac == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }else{
            if(accountService.withDraw(account)!=null) {
                val left = accountService.withDraw(account)
                return ResponseEntity.ok(left)
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
            }
        }
    }

    @GetMapping("/checkAmount/{accountNo}")
    fun getAmount(@PathVariable accountNo: Long) : ResponseEntity<Any> {
        val result = accountService.AMDetail(accountNo)
       if(result == null){
           println("Account not found for accountNo: $accountNo")
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
       }else {
           return ResponseEntity.ok(result)
       }
    }
    @PostMapping("/delete")
    fun deleteAccount(@RequestBody account: exchangeMoney) : ResponseEntity<Any> {
        val result = accountService.checkDetail(account)
        if(result == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }else{
            val anum = account.accountNo
            val resultShow = accountService.deleteDetail(anum!!)
            return ResponseEntity.ok(resultShow)
        }
    }

}