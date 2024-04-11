package br.com.erundio.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
// @RestController = @Controller + @ResponseBody
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return convertToDouble(num1) + convertToDouble(num2);
    }
    @RequestMapping(value = "/subtract/{num1}/{num2}", method = RequestMethod.GET)
    public Double subtract(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return convertToDouble(num1) - convertToDouble(num2);
    }
    @RequestMapping(value = "/mult/{num1}/{num2}", method = RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return convertToDouble(num1) * convertToDouble(num2);
    }

    @RequestMapping("/div/{num1}/{num2}")
    public Double div(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return convertToDouble(num1) / convertToDouble(num2);
    }

    @RequestMapping("/avg/{num1}/{num2}")
    public Double avg(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return (convertToDouble(num1) + convertToDouble(num2)) / 2;
    }

    @RequestMapping("/sqrRoot/{num1}")
    public Double sqrRoot(
            @PathVariable(value = "num1") String num1) throws Exception{

        if (!isNumeric(num1)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return Math.sqrt(convertToDouble(num1));
    }



    private Double convertToDouble(String strNumber) {
        if (strNumber == null){
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null){
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }


}
