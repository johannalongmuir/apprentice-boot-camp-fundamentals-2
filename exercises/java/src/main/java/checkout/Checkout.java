package checkout;

class Checkout {
    public static final int DISCOUNT_VALUE_A = 30;
    public static final int DISCOUNT_VALUE_B = 15;
    protected int totalCost;
    private int numberOfA = 0;
    private int numberOfB = 0;
    private Receipt receipt = new Receipt();


    void scan(String sku) {
        if ("A".equals(sku)) {
            updateTotalCost(50);
            ++numberOfA;
            applyADiscounts(numberOfA, 5, DISCOUNT_VALUE_A);
            receipt.scannedA(numberOfA);
        } else if ("B".equals(sku)) {
            updateTotalCost(30);
            ++numberOfB;
            applyADiscounts(numberOfB, 2, DISCOUNT_VALUE_B);
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
