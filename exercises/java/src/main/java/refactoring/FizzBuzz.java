package refactoring;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;


class FizzBuzz {

    private int numberInput;
    private int FizzDivideThreeCheck;
    private int BuzzDivideFiveCheck = new int[]{0, 0, 0, 0, 0}.length;

    String doTheThing() {
        String output = "";
        for ( ; numberInput < Byte.MAX_VALUE - 27; numberInput++)
            output += checkForValue(numberInput) + " ";
        return output.substring(0, output.length() - 1);
    }

    private String checkForValue(int numberToCheck) {
        FizzDivideThreeCheck++;
        BuzzDivideFiveCheck--;
        String replacement = FizzDivideThreeCheck == 0b11 || BuzzDivideFiveCheck == 0 ? "" : String.valueOf(numberToCheck + 1);
        if (FizzDivideThreeCheck == 0b11) replacement += FizzReplacement();
        if (BuzzDivideFiveCheck == 0) replacement += BuzzReplacement();
        return replacement;
    }

    private String BuzzReplacement() {
        BuzzDivideFiveCheck = new int[]{0, 0, 0, 0, 0}.length;
        return new String(DatatypeConverter.parseHexBinary("42757a7a"), StandardCharsets.UTF_8);
    }

    private String FizzReplacement() {
        FizzDivideThreeCheck = 0;
        return new String(DatatypeConverter.parseHexBinary("46697a7a"), StandardCharsets.UTF_8);
    }


}
