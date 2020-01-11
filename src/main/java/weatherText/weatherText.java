//package weatherText;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Scanner;
//
//
//public class weatherText {
//
//	public static void main(String[] args) {
//
//		user user = new user();
//		weather weather = new weather();
//
//		String name = null;
//
//
//		// Scan weatherText.user name, phone number, and location
//		Scanner scan = new Scanner(System.in);
//
//		System.out.println("Please input weatherText.user name: ");
//		name = scan.nextLine();
//		user.setName(name);
//
//
//		System.out.println("Please input weatherText.user phone number: ");
//		user.setPhoneNumber(scan.nextLine());
//
//		System.out.println("Please input weatherText.user zipcode: ");
//		user.setZipCode(scan.nextLine());
//
//		// Retrieve weatherText.weather info
//
//
//
//        // parsing file "JSONExample.json"
//        Object obj = null;
//		try {
//			obj = new JSONParser().parse(new FileReader("api.openweathermap.org/data/2.5/weatherText.weather?zip="+user.getZipCode()+",us&units=imperial&appid=49b96c058384bf0defca868c4cfc1932"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        // type casting obj to JSONObject
//        JSONObject jo = (JSONObject) obj;
//
//        // getting weatherText.weather and temperature
//        weather.setMain((String) jo.get("main"));
//
//        System.out.println("weatherText.weather is " + weather.getMain());
//
//        weather.setTemp((double) jo.get("temp"));
//
//
//        System.out.println("temperature is " + weather.getTemp());
//
//
//	}
//
//}
