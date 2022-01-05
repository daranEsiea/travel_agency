package fr.lernejo.travelsite;

public class Travel {
    private final String country;
    private final float temperature;

    public Travel(String country, float temperature) {
        this.country = country;
        this.temperature = temperature;
    }

    public Travel() {
        this.country = "";
        this.temperature = 0;
    }

    public String getCountry() {
        return country;
    }

    public float getTemperature() {
        return temperature;
    }
}
