//package weatherText;
//
//import java.io.*;
//import java.util.*;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;
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
//		// Scan user name, phone number, and location
//		Scanner scan = new Scanner(System.in);
//
//		System.out.println("Please input user name: ");
//		name = scan.nextLine();
//		user.setName(name);
//
//
//		System.out.println("Please input user phone number: ");
//		user.setPhoneNumber(scan.nextLine());
//
//		System.out.println("Please input user zipcode: ");
//		user.setZipCode(scan.nextLine());
//
//		// Retrieve weather info
//
//
//
//        // parsing file "JSONExample.json"
//        Object obj = null;
//		try {
//			obj = new JSONParser().parse(new FileReader("api.openweathermap.org/data/2.5/weather?zip="+user.getZipCode()+",us&units=imperial&appid=49b96c058384bf0defca868c4cfc1932"));
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
//        // getting weather and temperature
//        weather.setMain((String) jo.get("main"));
//
//        System.out.println("weather is " + weather.getMain());
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
