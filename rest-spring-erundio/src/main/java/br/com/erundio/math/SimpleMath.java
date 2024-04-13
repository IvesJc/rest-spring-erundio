package br.com.erundio.math;

import org.springframework.stereotype.Service;

@Service
public class SimpleMath {

    public Double convertToDouble(String strNumber) {
        if (strNumber == null){
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null){
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    public Double sum(String num1, String  num2){
        return convertToDouble(num1) + convertToDouble(num2);
    }

    public Double sub(String num1, String  num2){
        return convertToDouble(num1) - convertToDouble(num2);
    }
    public Double mult(String num1, String  num2){
        return convertToDouble(num1) * convertToDouble(num2);
    }
    public Double div(String num1, String  num2){
        return convertToDouble(num1) / convertToDouble(num2);
    }

    public Double avg(String num1, String  num2){
        return (convertToDouble(num1) + convertToDouble(num2)) / 2;
    }

    public Double sqrRoot(String num1){
        return Math.sqrt(convertToDouble(num1));
    }
}
