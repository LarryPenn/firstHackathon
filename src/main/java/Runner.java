import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in your phone number");
        String phoneNumber = sc.next();
        System.out.println("Thank you! Now, please type in your zipcode.");
        String zipCode = sc.next();
        RetrieveWeather rw = new RetrieveWeather();
        try {
            SendTexts.sendMessage(phoneNumber, rw.formatWeatherDetails(rw.getWeatherAttributes(zipCode)));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
