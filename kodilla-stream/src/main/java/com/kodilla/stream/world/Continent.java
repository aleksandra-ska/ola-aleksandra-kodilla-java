package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public class Continent {
    private final String countryName;
    private final Set<Country> countries = new HashSet<>();

    public Continent(String countryName) {
        this.countryName = countryName;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public String getCountryName() {
        return countryName;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        return "Continent{" +
                '\'' +
                ", countries=" + countries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;
        Continent continent = (Continent) o;
        return countryName.equals(continent.countryName);
    }

    @Override
    public int hashCode() {
        return countryName.hashCode();
    }
}
