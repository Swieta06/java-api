package solid2;

public interface NotificationService {

    public void sendOTP(String medium);
    public void sendTransactionNotification(String medium);
}
