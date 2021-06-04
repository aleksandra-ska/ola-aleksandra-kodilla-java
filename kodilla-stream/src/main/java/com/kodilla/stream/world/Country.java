package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String continentName;
    private final String bigNumbers;

    public Country(final String continentName, final String bigNumbers) {
        this.continentName = continentName;
        this.bigNumbers = bigNumbers;
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = new BigDecimal(bigNumbers);
        return peopleQuantity;
    }
}
