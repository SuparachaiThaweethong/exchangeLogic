package com.protosstechnology.train.bootapplication.controller

import com.protosstechnology.train.bootapplication.repository.UserRepository
import com.protosstechnology.train.bootapplication.service.CalculateService
import com.protosstechnology.train.bootapplication.service.GradingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController
class HelloController {

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var calculateService: CalculateService
    @Autowired
    lateinit var gradingService: GradingService

    @GetMapping("/hello")
    fun helloWorld(): ResponseEntity<String>{
        return ResponseEntity.ok().body("Hello World")
    }
    @GetMapping("/calculate/{a}/{b}")
    fun calculate(@PathVariable("a")a:Int,@PathVariable("b")b:Int): ResponseEntity<Int>{
        return ResponseEntity.ok().body(calculateService.calculateNumber(a,b))
    }
    @GetMapping("/grading/{g}")
    fun grading(@PathVariable("g")g:String): ResponseEntity<String>{
        return ResponseEntity.ok().body(gradingService.gradingService(g))
    }


}