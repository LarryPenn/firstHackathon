import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SendTexts {
    // Install the Java helper library from twilio.com/docs/java/install

    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACd2a83fbfbea92c00e25a54b9b8466f7f";
    public static final String AUTH_TOKEN = "353de2ebdb036ffd25e44621ee9e78df";

    public static void sendMessage(String phoneNumber, String weatherMessage) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+1" + phoneNumber),
                new com.twilio.type.PhoneNumber("+1 201 903 9808"),
                weatherMessage)
                .create();
        System.out.println(message.getSid());
    }

}

