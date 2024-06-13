package com.protosstechnology.train.bootapplication.service

import com.protosstechnology.train.bootapplication.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CalculateService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun calculateNumber(a: Int,b: Int): Int {
        return a+b
    }


}