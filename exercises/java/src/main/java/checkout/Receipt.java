package checkout;

class Receipt {

    private String text = "";
    //private Checkout checkout = new Checkout();

    String text(int total) {
        return text + "Total: " + total;
    }

    void getLine(String stockKeepingUnit, int cost, int discount) {
        text += stockKeepingUnit + ": " + cost;
        discountLine(stockKeepingUnit, discount);
        newLine();
    }

    private void discountLine(String stockKeepingUnit, int discount) {
        if ("A".equals(stockKeepingUnit) && discount % Checkout.NUMBER_OF_A_REQUIRED_FOR_DISOUNT == 0) {
            text += " - 30 (5 for 220)";
        } else if ("B".equals(stockKeepingUnit) && discount % Checkout.NUMBER_OF_B_REQUIRED_FOR_DISCOUNT == 0) {
            text += " - 15 (2 for 45)";
        }
    }

    private void newLine() {
        text += "\n";
    }


//    void scannedB(int numberOfB) {
//        getLine("B: 30", 30);
//        if (isDivisibleBy(numberOfB, Checkout.NUMBER_OF_B_REQUIRED_FOR_DISCOUNT)) {
//            text += " - 15 (2 for 45)";
//        }
//        newLine();
//    }


//    if (isDivisibleBy(Checkout.numberOfA, Checkout.NUMBER_OF_A_REQUIRED_FOR_DISOUNT)) {
//                text += " - 30 (5 for 220)";


    private boolean isDivisibleBy(int productCounter, int numberRequiredForDiscount) {
        return productCounter % numberRequiredForDiscount == 0;
    }


}
