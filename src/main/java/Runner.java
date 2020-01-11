import java.io.IOException;
import java.util.Scanner;

/***
 * Use this class to run the program. Takes in 2 user inputs: 1) Phone number 2) Zipcode. Sends a text message
 * to user and outputs a success code.
 */
public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = null;
        do {
            System.out.println("Please type in your phone number");
            phoneNumber = sc.next();
        }
        while (phoneNumber.length() != 10);
        String zipCode = null;
        do {
            System.out.println("Thank you! Now, please type in your zipcode.");
            zipCode = sc.next();
        }
        while (Integer.parseInt(zipCode) <= 0 || Integer.parseInt(zipCode) > 99999 || zipCode.length() != 5);
        System.out.println("Please enter twilio authentication token");
        String AUTH_TOKEN = sc.next();
        System.out.println("Please enter openweather.org API Key");
        String weatherAPIKey = sc.next();
        RetrieveWeather rw = new RetrieveWeather();
        rw.setApiKey(weatherAPIKey);
        try {
            SendTexts.sendMessage(phoneNumber, rw.formatWeatherDetails(rw.getWeatherAttributes(zipCode)), AUTH_TOKEN);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}