import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;

/***
 * Class is taken as is from twilio.com to send text messages. Simply just redesigned method to take in a phone
 * number and message when creating a message instance.
 */
public class SendTexts {
    // Install the Java helper library from twilio.com/docs/java/install

    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "AC45fb1f4efeee096c7ec211bdc4fba70c";

    public static void sendMessage(String phoneNumber, String weatherMessage, String AUTH_TOKEN) {
        try{
        	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+1" + phoneNumber),
                new com.twilio.type.PhoneNumber("+1 901 209 5374"),
                weatherMessage)
                .create();
        System.out.println("Success");
        }
        catch(ApiException e) {
            System.out.println(e.getMessage() + '\n');
        	System.out.println("Test failed: please check if your inputs are correct");
        }
        
    }

}