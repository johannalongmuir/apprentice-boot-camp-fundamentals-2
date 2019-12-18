package checkout;

class Checkout {
    public static final int DISCOUNT_VALUE_A = 30;
    public static final int DISCOUNT_VALUE_B = 15;
    public static final int NUMBER_OF_A_REQUIRED_FOR_DISOUNT = 5;
    public static final int NUMBER_OF_B_REQUIRED_FOR_DISCOUNT = 2;

    protected int totalCost;
    private int numberOfA = 0;
    private int numberOfB = 0;
    private Receipt receipt = new Receipt();

    void scan(String sku) {
        if ("A".equals(sku)) {
            updateTotalCost(50);
            ++numberOfA;
            applyADiscounts(numberOfA, NUMBER_OF_A_REQUIRED_FOR_DISOUNT, DISCOUNT_VALUE_A);
            receipt.scannedA(numberOfA);
        } else if ("B".equals(sku)) {
            updateTotalCost(30);
            ++numberOfB;
            applyADiscounts(numberOfB, NUMBER_OF_B_REQUIRED_FOR_DISCOUNT, DISCOUNT_VALUE_B);
            receipt.scannedB(numberOfB);
        } else if ("C".equals(sku)) {
            updateTotalCost(20);
            receipt.scannedC();
        } else if ("D".equals(sku)) {
            updateTotalCost(15);
            receipt.scannedD();
        }
    }

    private void updateTotalCost(int cost) {
        totalCost += cost;
    }

    private void applyADiscounts(int product, int discountNumber, int discountValue) {
        if (product % discountNumber == 0) {
            totalCost -= discountValue;
        }
    }

    int total() {
        return totalCost;
    }

    String receipt() {
        return receipt.text(totalCost);
    }
}
