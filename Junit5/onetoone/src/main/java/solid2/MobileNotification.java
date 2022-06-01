package solid2;

public class MobileNotification implements NotificationService {
    @Override
    public void sendOTP(String medium) {
        // write Logic using Twilio SMS API
    }

    @Override
    public void sendTransactionNotification(String medium) {
    }
}
