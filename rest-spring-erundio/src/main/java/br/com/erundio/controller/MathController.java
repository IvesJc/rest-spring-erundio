package br.com.erundio.controller;

import br.com.erundio.math.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
// @RestController = @Controller + @ResponseBody
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private SimpleMath simpleMath;

    @RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!simpleMath.isNumeric(num1) || !simpleMath.isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return simpleMath.sum(num1, num2);
    }
    @RequestMapping(value = "/sub/{num1}/{num2}", method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!simpleMath.isNumeric(num1) || !simpleMath.isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return simpleMath.sub(num1, num2);
    }
    @RequestMapping(value = "/mult/{num1}/{num2}", method = RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!simpleMath.isNumeric(num1) || !simpleMath.isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return simpleMath.mult(num1, num2);

    }

    @RequestMapping("/div/{num1}/{num2}")
    public Double div(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{

        if (!simpleMath.isNumeric(num1) || !simpleMath.isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return simpleMath.div(num1, num2);

    }

    @RequestMapping("/avg/{num1}/{num2}")
    public Double avg(
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2) throws Exception{
        if (!simpleMath.isNumeric(num1) || !simpleMath.isNumeric(num2)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return simpleMath.avg(num1, num2);

    }

    @RequestMapping("/sqrRoot/{num1}")
    public Double sqrRoot(
            @PathVariable(value = "num1") String num1) throws Exception{

        if (!simpleMath.isNumeric(num1)){
            throw new UnsupportedOperationException("Set a numeric value");
        }
        return simpleMath.sqrRoot(num1);

    }






}
