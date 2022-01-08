package fr.lernejo.travelsite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    final int MAX_WEATHER = 40;
    final int MIN_WEATHER = 0;
    private final String userEmail;
    private final String userName;
    private final String userCountry;
    private final String weatherExpectation;
    private final int minimumTemperatureDistance;

    public User(String userEmail, String userName, String userCountry, String weatherExpectation, int minimumTemperatureDistance) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userCountry = userCountry;
        this.weatherExpectation = weatherExpectation;
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }

    public User() {
        this.userEmail = "";
        this.userName = "";
        this.userCountry = "";
        this.weatherExpectation = "";
        this.minimumTemperatureDistance = MIN_WEATHER;
    }

    public boolean isValidInscription() {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.userEmail); // check si c'est un mail
        if (
            (this.weatherExpectation.equals(weatherType.valueOf("WARMER")) || this.weatherExpectation.equals(weatherType.valueOf("COLDER")))
                || (!this.userEmail.equals("") && matcher.matches())
                || (!this.userName.equals(""))
                || (!this.weatherExpectation.equals(""))
                || (!this.userCountry.equals(""))
                || ((this.minimumTemperatureDistance >= MIN_WEATHER) || (this.minimumTemperatureDistance <= MAX_WEATHER))
        ) {
            return true;
        } else {
            return false;
        }
    }
}
