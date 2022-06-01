package solid5;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMall {
    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void doPayment(Object order, int amount){
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        //
        BankCard bankCard = new DebitCard();

        ShoppingMall shoppingMall = new ShoppingMall(bankCard);

        shoppingMall.doPayment("some order",5000);
    }
}
