package solid1;

public class BankServiceImpl implements BankService, NotificationService, LoanService, PrinterService {

    @Override
    public long deposit(long amount, String accountNo) {
        return 0;
    }

    @Override
    public long withDraw(long amount, String accountNo) {
        return 0;
    }

    @Override
    public void printPassbook() {
    }

    @Override
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }

    @Override
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
}
