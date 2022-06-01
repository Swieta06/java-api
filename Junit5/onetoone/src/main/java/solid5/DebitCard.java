package solid5;

public class DebitCard implements BankCard{

    @Override
    public void doTransaction(int amount){
        System.out.println("Transaction done with DebitCard");
    }
}
