import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RetrieveWeather {

    String weatherDescription;
    String currentTemp;
    String minTemp;
    String maxTemp;
    String tempFeelsLike;
//    my key 8365433bc5b8ac876c7f82b0af27a5e5
    String APIKey = "49b96c058384bf0defca868c4cfc1932"; // TODO change this to user input from console
    static String weatherAPIURL = "http://api.openweathermap.org/data/2.5/weather?zip=";

    /***
     * Helper method used to create URL to pass to API with given API key, and zipcode.
     * @param apiKey - users API key
     * @param zipCode - users zip code
     * @return - URL in properly encoded format to query API.
     */
    private static URL createURL(String apiKey, String zipCode) {
        URL url = null;
        try {
            url = new URL(weatherAPIURL + zipCode + ",us" + "&appid=" + apiKey + "&units=imperial");
        } catch (MalformedURLException e) {
            System.out.println("Invalid zipcode, or apiKey provided. Please check and try again.");
        }
        return url;
    }

    /***
     * Helper method used from com.google.gson.Gson library that parses JSON objects and returns
     * them as HashMap
     * @param str JSON object as string
     * @return JSON object to hashmap
     */
    private static HashMap<String, Object> jsonToHashMap(String str) {
        HashMap<String, Object> weatherMap = new Gson().fromJson(str,
                new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
        return weatherMap;
    }

    /***
     * This method takes in the apiKey to be used as well as the user's zipcode and queries the
     * openweather.org website for weather data for that user's zipcode, using the apikey.
     * @param apiKey
     * @param zipCode
     * @return
     * @throws IOException
     */
    public HashMap<String, String> getWeatherAttributes(String apiKey, String zipCode) throws IOException {
        URLConnection conn = createURL(apiKey, zipCode).openConnection();
        StringBuilder jsonData = new StringBuilder();
        HashMap<String, String> weatherInfo = new HashMap<String, String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            HashMap<String, Object> responseMap = jsonToHashMap(jsonData.toString());
            ArrayList<Map> weather = (ArrayList) responseMap.get("weather");
            weatherDescription = weather.get(0).get("description").toString();

            Map<String, Double> temps = (Map<String, Double>) responseMap.get("main");
            currentTemp = temps.get("temp").toString();
            minTemp = temps.get("temp_min").toString();
            maxTemp = temps.get("temp_max").toString();
            tempFeelsLike = temps.get("feels_like").toString();

            // add attributes to hashmap, which we'll output & format nicely for sending text message.
            weatherInfo.put("weather description", weatherDescription);
            weatherInfo.put("current temperature", currentTemp);
            weatherInfo.put("low temperature", minTemp);
            weatherInfo.put("maximum temperature", maxTemp);
            weatherInfo.put("temp feels like", tempFeelsLike);

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return weatherInfo;
    }


    public static void main(String[] args) {
        RetrieveWeather w = new RetrieveWeather();
        try {
            HashMap<String, String> pleaseWork = w.getWeatherAttributes("8365433bc5b8ac876c7f82b0af27a5e5",
                    "45040");
            System.out.println(pleaseWork);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
