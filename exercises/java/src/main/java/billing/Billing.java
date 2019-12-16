package billing;

public class Billing {


    public static int generateBill(int ratePerAdvert, int numberOfAdverts, int numberOfPromotionProducts, int promotionProductRate) {
        return ((ratePerAdvert + (promotionProductRate * numberOfPromotionProducts)) * numberOfAdverts);
    }
}
