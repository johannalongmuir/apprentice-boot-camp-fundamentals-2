package refactoring;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;


class FizzBuzz {

    private int number;
    private int FizzDivideThreeCheck;
    private int BuzzDivideFiveCheck = new int[]{0, 0, 0, 0, 0}.length;


    String fizzBuzzConversion() {
        String output = "";
        int oneHundred = Byte.MAX_VALUE - 27;
        for (; number < oneHundred; number++)
            output += checkForValue(number) + " ";
        return output.substring(0, output.length() - 1);
    }

    private String checkForValue(int numberToCheck) {
        FizzDivideThreeCheck++;
        BuzzDivideFiveCheck--;
        int binaryNumberThree = 0b11;
        boolean divisibleByThree = FizzDivideThreeCheck == binaryNumberThree;
        boolean divisibleByFive = BuzzDivideFiveCheck == 0;
        String addValue = divisibleByThree || divisibleByFive ? "" : String.valueOf(numberToCheck + 1);
        if (divisibleByThree) addValue += fizz();
        if (divisibleByFive) addValue += buzz();
        return addValue;
    }

    private String buzz() {
        BuzzDivideFiveCheck = new int[]{0, 0, 0, 0, 0}.length;
        String buzz = new String(DatatypeConverter.parseHexBinary("42757a7a"), StandardCharsets.UTF_8);
        return buzz;
    }

    private String fizz() {
        FizzDivideThreeCheck = 0;
        String fizz = new String(DatatypeConverter.parseHexBinary("46697a7a"), StandardCharsets.UTF_8);
        return fizz;
    }


}
