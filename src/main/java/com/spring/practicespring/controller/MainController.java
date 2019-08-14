package com.spring.practicespring.controller;

import com.spring.practicespring.dto.EmiDto;
import com.spring.practicespring.dto.EmiOperator2Dto;
import com.spring.practicespring.dto.Restdto;
import com.spring.practicespring.rest.RESTResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class MainController {

    private double amount_month = 0;
    @RequestMapping(method = RequestMethod.POST, value = "operator1")
    public ResponseEntity<Object> operation1(@RequestBody EmiDto emiDto) {
        double amount = calculate(emiDto.getLoan(), emiDto.getRate(), emiDto.getTerm());
        amount_month = amount;
        return new ResponseEntity<Object>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Success!")
                .setData(new Restdto(amount))
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "operator2")
    public ResponseEntity<Object> operation2(@RequestBody EmiOperator2Dto emiOperator2Dto) {
        double x = amount_month * emiOperator2Dto.getMonth() + emiOperator2Dto.getFee();
        return new ResponseEntity<Object>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Success!")
                .setData(new Restdto(x))
                .build(), HttpStatus.OK);
    }

    public double calculate(long l, double r, int t) {
        r = (r/12)/100;
        return l * ((r*Math.pow(1+r,t)) / (Math.pow(1+r,t) - 1));
    }
}
