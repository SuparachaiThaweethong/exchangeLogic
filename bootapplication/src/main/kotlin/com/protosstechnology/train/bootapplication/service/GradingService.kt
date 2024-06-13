package com.protosstechnology.train.bootapplication.service

import org.springframework.stereotype.Service
import java.awt.GraphicsDevice

@Service
class GradingService {

    fun gradingService(g:String):String{
        var Grade: String
        try {

            if (g.toBigDecimal() < 50.toBigDecimal()) {
                Grade = "F"
            } else if (g.toBigDecimal() >= 50.toBigDecimal() && g.toBigDecimal() < 60.toBigDecimal()) {
                Grade = "D"
            } else if (g.toBigDecimal() >= 60.toBigDecimal() && g.toBigDecimal() < 70.toBigDecimal()) {
                Grade = "C"
            } else if (g.toBigDecimal() >= 70.toBigDecimal() && g.toBigDecimal() < 80.toBigDecimal()) {
                Grade = "B"
            } else {
                Grade = "A"
            }
        }catch(e:Exception){
            Grade = "You Put The Wrong One!"
        }
        return Grade
    }
}