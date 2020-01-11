import java.io.IOException;
import java.util.Scanner;

/***
 * Use this class to run the program. Takes in 2 user inputs: 1) Phone number 2) Zipcode. Sends a text message
 * to user and outputs a success code.
 */
public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in your phone number");
        String phoneNumber = sc.next();
        System.out.println("Thank you! Now, please type in your zipcode.");
        String zipCode = sc.next();
        System.out.println("Please enter twilio authentication token");
        String AUTH_TOKEN = sc.next();
        System.out.println("Please enter openweather.org API Key");
        String weatherAPIKey = sc.next();
        RetrieveWeather rw = new RetrieveWeather();
        rw.setApiKey(weatherAPIKey);
        try {
            SendTexts.sendMessage(phoneNumber, rw.formatWeatherDetails(rw.getWeatherAttributes(zipCode)), AUTH_TOKEN);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}