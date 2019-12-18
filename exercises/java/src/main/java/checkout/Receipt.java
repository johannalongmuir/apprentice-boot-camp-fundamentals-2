package checkout;

class Receipt {

    private String text = "";

    String text(int total) {
        return text + "Total: " + total;
    }

    protected void scannedA(int numberOfA) {
        text += "A: 50";
        if (isDivisibleBy(numberOfA, Checkout.NUMBER_OF_A_REQUIRED_FOR_DISOUNT)) {
            text += " - 30 (5 for 220)";
        }
        text += "\n";
    }



    void scannedB(int numberOfB) {
        text += "B: 30";
        if (isDivisibleBy(numberOfB, Checkout.NUMBER_OF_B_REQUIRED_FOR_DISCOUNT)) {
            text += " - 15 (2 for 45)";
        }
        text += "\n";
    }

    void scannedC() {
        text += "C: 20\n";
    }

    void scannedD() {
        text += "D: 15\n";
    }



    private boolean isDivisibleBy(int productCounter, int numberRequiredForDiscount) {
        return productCounter % numberRequiredForDiscount == 0;
    }


}
