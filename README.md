# MOSA Hackathon Project
Hi! Welcome to our project for the MOSA Hackathon. The program we've created does a couple key things. It takes input in from a user for their phone number and zipcode, in order to send them a text message with details about the current weather conditions at their location. 

The Runner.java class is only file that needs to be run in order for the project to work. We query openweathermap.org for the weather data for the zip code supplied by a user, and then we send a text message with all of the weather details to the phone number provided. The project makes use of querying an API, retrieving the data in JSON format, parsing it, and extracting the necessary attributes from the data to provide to the user.    

## Important items to note: 
  - The source code is written in Java, using SDK 1.8 and Java SE 8
  - The project uses external libraries, which are included in the .idea folder, as well as the .libs folder 
  - The libraries are the twilio library used for sending text messages (library built done with Maven) and the google JSON library for     reading and parsing JSON into a Java HashMap
  - You will need all of the external libraries to properly run the project. 
  
## How to run the project 
  - Clone the repository, and ensure that you have registered on https://openweathermap.org/ to get your API key, which is used in the RetrieveWeather.java file. <b> For judging purposes, we will supply the openweathermap API key. </b>
  - If you do not have a Twilio account or openweathermap.org account, you will need to create one in order to get an API key for openweathermap.org as well as a Twilio phone
  number and authentication token. <b> For judging purposes, we will supply the Twilio Authentication Token. </b>
    - For the purposes of the Hackathon, (we can supply both the openweathermap.org API key and Twilio authentication token so the program can be run properly). At the moment,
    the program requests an API key and Authentication Token via console input from the Runner.java file.  
- Open the Runner.java file, and compile it. It will prompt you for your phone number, zipcode, openweathermap.org API key, and a Twilio Authentication Token. Once these are provided, the program will retrieve the weather data for your zipcode, and send a text message to the phone number provided.  
  
  
## Final Notes
  - We did not want to make our Twilio Authentication Token public, as this would be a privacy issue. For judging purposes if you'd like to test the program, we will provide you with the Authentication Token, and you can send a text to any phone number you'd like. 
  
  - The main cause(s) for errors would be: 
    1. Inputting a phone number that has not been verified when compiling Runner.Java
    2. Incorrect API key for openweathermap.org, or failure to supply an API key
    3. Incorrect Authentication Token for Twilio, or failure to supply the token. 
    
  - If you have any questions, please let us know.
  
  ##### Enjoy! 
