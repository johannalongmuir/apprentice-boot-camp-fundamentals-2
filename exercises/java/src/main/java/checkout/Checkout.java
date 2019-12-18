package checkout;

class Checkout {
    public static final int DISCOUNT_VALUE_A = 30;
    public static final int DISCOUNT_VALUE_B = 15;
    public static final int NUMBER_OF_A_REQUIRED_FOR_DISOUNT = 5;
    public static final int NUMBER_OF_B_REQUIRED_FOR_DISCOUNT = 2;
    public static final int NO_DISCOUNT_FOR_PRODUCT = 0;
    protected int totalCost;
    protected int discountATracker = 0; // cannot be static
    protected int discountBTracker = 0;
    private Receipt receipt = new Receipt();

    void scan(String stockKeepingUnit) {
        if ("A".equals(stockKeepingUnit)) {
            updateTotalCost(50);
            ++discountATracker;
            applyADiscounts(discountATracker, NUMBER_OF_A_REQUIRED_FOR_DISOUNT, DISCOUNT_VALUE_A);
            receipt.getLine(stockKeepingUnit, 50, discountATracker);
        } else if ("B".equals(stockKeepingUnit)) {
            updateTotalCost(30);
            ++discountBTracker;
            applyADiscounts(discountBTracker, NUMBER_OF_B_REQUIRED_FOR_DISCOUNT, DISCOUNT_VALUE_B);
            receipt.getLine(stockKeepingUnit, 30, discountBTracker);
        } else if ("C".equals(stockKeepingUnit)) {
            updateTotalCost(20);
            receipt.getLine(stockKeepingUnit, 20, NO_DISCOUNT_FOR_PRODUCT);
        } else if ("D".equals(stockKeepingUnit)) {
            updateTotalCost(15);
            receipt.getLine(stockKeepingUnit, 15, NO_DISCOUNT_FOR_PRODUCT);
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
