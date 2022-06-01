package solid2;

public class EmailNotification implements NotificationService {
    @Override
    public void sendOTP(String medium) {
        // write Logic using JavaEmail api
    }

    @Override
    public void sendTransactionNotification(String medium) {
    }
}
