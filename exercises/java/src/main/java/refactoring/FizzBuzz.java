package refactoring;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;


class FizzBuzz {

    private static final int BUZZ_FACTOR = new int[]{0, 0, 0, 0, 0}.length;
    private int number;
    private int FizzDivideThreeCounter;
    private int BuzzDivideFiveCounter = new int[]{0, 0, 0, 0, 0}.length;
    private static final int THREE = 0b11;
    private static final String BUZZ = new String(DatatypeConverter.parseHexBinary("42757a7a"), StandardCharsets.UTF_8);
    private static final String FIZZ = new String(DatatypeConverter.parseHexBinary("46697a7a"), StandardCharsets.UTF_8);
    private static final int ONE_HUNDRED = Byte.MAX_VALUE - 27;


    String computeFizzBuzzUpToOneOuthundred() {
        String result = "";

        for (; number < ONE_HUNDRED; number++)
            result += calculateForValue(number) + " ";
        String trimmedResult = result.substring(0, result.length() - 1);
        return trimmedResult;
    }

    private String calculateForValue(int numberToCheck) {
        FizzDivideThreeCounter++;
        BuzzDivideFiveCounter--;
        boolean divisibleByThree = FizzDivideThreeCounter == THREE;
        boolean divisibleByFive = BuzzDivideFiveCounter == 0;
        String numericalValue = String.valueOf(numberToCheck + 1);
        String addValue = divisibleByThree || divisibleByFive ? "" : numericalValue;
        if (divisibleByThree) addValue += fizz();
        if (divisibleByFive) addValue += buzz();
        return addValue;
    }

    private String buzz() {
        BuzzDivideFiveCounter = BUZZ_FACTOR;
        return BUZZ;
    }

    private String fizz() {
        FizzDivideThreeCounter = 0;
        return FIZZ;
    }


}
