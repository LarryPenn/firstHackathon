# MOSA Hackathon Project
Hi! Welcome to our project for the MOSA Hackathon. 

## Important items to note: 
  - The source code is written in Java, using SDK 1.8 and Java SE 8
  - The project uses external libraries, which are included in the .idea folder, as well as the .libs folder 
  - The libraries are the twilio library used for sending text messages (library built done with Maven) and the google JSON library for     reading and parsing JSON into a Java HashMap
  - You will need all of the external libraries to properly run the project. 
  
## How to run the project 
  - Clone the repository, and ensure that you have registered on https://openweathermap.org/ to get your API key, which is used in the RetrieveWeather.java file.
  - If you do not have a Twilio account or openweathermap.org account, you will need to create one in order to get an API key for openweathermap.org as well as a Twilio phone
  number and authentication token. 
    - For the purposes of the Hackathon, (we can supply both the openweathermap.org API key and Twilio authentication token so the program can be run properly). At the moment,
    the program requests an API key and Authentication Token via console input from the Runner.java file.  
  
  
## Final Notes
  - Twilio does NOT allow you to send text messages to phone numbers which are not "verified" from the Twilio account being
  used. So, if you would like to receive a text message to your phone, you will have to give us your phone number, and we will
  add it to the list of verified numbers (this involves receiving a text from Twilio, and you will have to give us the 5 digit code).
  
  - The main cause(s) for errors would be: 
    1. Inputting a phone number that has not been verified when compiling Runner.Java
    2. Incorrect API key for openweathermap.org, or failure to supply an API key
    3. Incorrect Authentication Token for Twilio, or failure to supply the token. 
    
  - If you have any questions, please let us know.
  
  ##### Enjoy! 
