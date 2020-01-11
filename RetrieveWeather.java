import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class RetrieveWeather {

//    String weatherAPIURL = "http://api.openweathermap.org/data/2.5/weather?zip=";
    String APIKey = "8365433bc5b8ac876c7f82b0af27a5e5"; // TODO change this to user input from console
    static String weatherAPIURL = "http://api.openweathermap.org/data/2.5/weather?zip=";

    private static URL createURL(String apiKey, String zipCode) {
        URL url = null;
        try {
            url = new URL(weatherAPIURL + zipCode + ",us" + "&appid=" + apiKey + "&units=imperial");
        } catch (MalformedURLException e) {
            System.out.println("Invalid zipcode, or apiKey provided. Please check and try again.");
        }
        return url;
    }

    private static HashMap<String, Object> jsonToHashMap(String str) {
        HashMap<String, Object> weatherMap = new Gson().fromJson(str,
                new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
        return weatherMap;
    }

    public HashMap<String, String> getWeatherAttributes(String apiKey, String zipCode) throws IOException {
//        URL url = new URL(createURL(apiKey, zipCode));
        URLConnection conn = createURL(apiKey, zipCode).openConnection();
        StringBuilder jsonData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            HashMap<String, Object> responseMap = jsonToHashMap(jsonData.toString());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return String[]; //TODO
    }



    public static void main(String[] args) {
        String my_API_KEY = "8365433bc5b8ac876c7f82b0af27a5e5";
//        System.out.println("Please Enter API Key");
        String zipCode = "45040";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us" + "&appid=" +
                my_API_KEY + "&units=imperial";
        try {
            StringBuilder jsonData = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            reader.close();
            String separator = "==================================================================================" +
                    "=======================";
            System.out.println("JSON data " + '\n' + separator + '\n' + jsonData);
            HashMap<String, Object> responseMap = jsonToHashMap(jsonData.toString());
            HashMap<String, Object> mainMap = jsonToHashMap(responseMap.get("main").toString());
//            HashMap<String, Object> weatherMap = jsonToHashMap(responseMap.get("weather").toString());
            System.out.println('\n' + "JSON to Map" + '\n' +
                    separator + '\n' + responseMap);
            System.out.println('\n' + "Value from Main Key in responseMap" + '\n' +
                    separator + '\n' +mainMap);
            System.out.println('\n' + "Keys in map" + '\n' + responseMap.keySet().toString());
            System.out.println('\n' + "Weather is: " + '\n' + separator + '\n' + responseMap.get("weather"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }





    }
}
