package solid1;

public interface BankService {

    public long deposit(long amount, String accountNo);
    public long withDraw(long amount, String accountNo);
}
