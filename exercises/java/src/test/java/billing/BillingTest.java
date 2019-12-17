package billing;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BillingTest {

    private int ratePerAdvert;
    private int numberOfAdverts;
    private int numberOfPromotionProducts;
    private int promotionProductRate = 10;
    private int result;


    @Test
    public void givenDealerWithAvertsAndOneProduct() {
        givenADealerHas20AdvertsWithTheAdvertPromotionProduct();
        whenTheMonthsBillIsGenerated();
        thenTheTotalWillBe£1200();
        thenTheTotalWillBe(1200);
    }

    @Test
    public void givenDealerWithAdvertsandTwoProducts() {
        givenADealerHas1000AdvertsWithTheFinanceAndValuationProduct();
        whenTheMonthsBillIsGenerated();
        thenTheTotalWillBe£70000();
    }

    @Test
    public void givenPrivateSellerWithThreeAdvertsAndNoProducts() {
        givenAPrivateSellerWith3AdvertsAndNoAdditionalProducts();
        whenTheMonthsBillIsGenerated();
        thenTheTotalWillBe£60();
    }

    @Test
    public void givenPrivateSellerWithOneCarandOneProduct() {
        givenAPrivateSellerWith1AdvertAndOneProduct();
        whenTheMonthsBillIsGenerated();
        thenTheTotalWillBe£30();
    }


    private void givenAPrivateSellerWith1AdvertAndOneProduct() {
        ratePerAdvert = 20;
        numberOfAdverts = 1;
        numberOfPromotionProducts = 1;
    }

    // TODO add final one if want.

    private void givenAPrivateSellerWith3AdvertsAndNoAdditionalProducts() {
        ratePerAdvert = 20;
        numberOfAdverts = 3;
        numberOfPromotionProducts = 0;
    }

    private void givenADealerHas20AdvertsWithTheAdvertPromotionProduct() {
        ratePerAdvert = 50;
        numberOfAdverts = 20;
        numberOfPromotionProducts = 1;
    }

    private void givenADealerHas1000AdvertsWithTheFinanceAndValuationProduct() {
        ratePerAdvert = 50;
        numberOfAdverts = 1000;
        numberOfPromotionProducts = 2;
    }

    private void whenTheMonthsBillIsGenerated() {
        Billing billing = new Billing();
        result = billing.generateBill(ratePerAdvert, numberOfAdverts, numberOfPromotionProducts, promotionProductRate);
    }

    private void thenTheTotalWillBe£1200() {
        Assertions.assertThat(result).isEqualTo(1200);
    }

    private void thenTheTotalWillBe£70000() {
        Assertions.assertThat(result).isEqualTo(70000);
    }

    private void thenTheTotalWillBe£60() {
        Assertions.assertThat(result).isEqualTo(60);
    }

    private void thenTheTotalWillBe£30() {
        Assertions.assertThat(result).isEqualTo(30);
    }

    private void thenTheTotalWillBe(int total) {
        Assertions.assertThat(result).isEqualTo(total);
    }


}
