package refactoring;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;


class FizzBuzz {

    private static final int FIVE = new int[]{0, 0, 0, 0, 0}.length;
    private int fizzBuzzCounter;
    private int fizzDivideThreeCounter;
    private int buzzDivideFiveCounter = FIVE;
    private static final int THREE = 0b11;
    private static final String BUZZ = getHexToString("42757a7a");
    private static final String FIZZ = getHexToString("46697a7a");

    private static final int ONE_HUNDRED = Byte.MAX_VALUE - 27;

    String computeFizzBuzzUpToOneHundred() {
        String result = "";

        for ( ; fizzBuzzCounter < ONE_HUNDRED; fizzBuzzCounter++)
            result += calculateForValue(fizzBuzzCounter) + " ";

        return removeLastCharacter(result);
    }


    private String calculateForValue(int index) {
        fizzDivideThreeCounter++;
        buzzDivideFiveCounter--;
        String addValue = "";

        if (!isDivisibleByThree() && !isDivisibleByFive()) {
            addValue += indexToNumericalValue(index);
        }
        if (isDivisibleByThree()) {
            addValue += fizz();
        }
        if (isDivisibleByFive()) {
            addValue += buzz();
        }

        return addValue;
    }

    private static String getHexToString(String hexValue) {
        return new String(DatatypeConverter.parseHexBinary(hexValue), StandardCharsets.UTF_8);
    }

    private String indexToNumericalValue(int numberToCheck) {
        return String.valueOf(numberToCheck + 1);
    }

    private boolean isDivisibleByFive() {
        return buzzDivideFiveCounter == 0;
    }

    private boolean isDivisibleByThree() {
        return fizzDivideThreeCounter == THREE;
    }

    private String buzz() {
        buzzDivideFiveCounter = FIVE;
        return BUZZ;
    }

    private String fizz() {
        fizzDivideThreeCounter = 0;
        return FIZZ;
    }

    private String removeLastCharacter(String input) {
        return input.substring(0, input.length() - 1);
    }


}
