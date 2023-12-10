package com.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    final private FraudCheckService fraudCheckService;


    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
         boolean isFradulentCustomer =  fraudCheckService.isFraudulentCustomer(customerId);

         return new FraudCheckResponse(isFradulentCustomer);
    }
}
