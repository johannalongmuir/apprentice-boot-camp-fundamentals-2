package refactoring;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;


class FizzBuzz {

    private int number;
    private int FizzDivideThreeCounter;
    private int BuzzDivideFiveCounter = new int[]{0, 0, 0, 0, 0}.length;


    String computeFizzBuzzUpToOneOuthundred() {
        String result = "";
        int maxFizzBuzz = Byte.MAX_VALUE - 27;

        for (; number < maxFizzBuzz; number++)
            result += calculateForValue(number) + " ";
        String trimmedResult = result.substring(0, result.length() - 1);
        return trimmedResult;
    }

    private String calculateForValue(int numberToCheck) {
        FizzDivideThreeCounter++;
        BuzzDivideFiveCounter--;
        int three = 0b11;
        boolean divisibleByThree = FizzDivideThreeCounter == three;
        boolean divisibleByFive = BuzzDivideFiveCounter == 0;
        String numericalValue = String.valueOf(numberToCheck + 1);
        String addValue = divisibleByThree || divisibleByFive ? "" : numericalValue;
        if (divisibleByThree) addValue += fizz();
        if (divisibleByFive) addValue += buzz();
        return addValue;
    }

    private String buzz() {
        BuzzDivideFiveCounter = new int[]{0, 0, 0, 0, 0}.length;
        String buzz = new String(DatatypeConverter.parseHexBinary("42757a7a"), StandardCharsets.UTF_8);
        return buzz;
    }

    private String fizz() {
        FizzDivideThreeCounter = 0;
        String fizz = new String(DatatypeConverter.parseHexBinary("46697a7a"), StandardCharsets.UTF_8);
        return fizz;
    }


}
