package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country country1 = new Country("Germany", "23878455");
        Country country2 = new Country("Italy", "5485454545");
        Country country3 = new Country("France", "2154845145");
        Country country4 = new Country("Canada", "5648645231218");
        Country country5 = new Country("USA", "565654575245");

        Continent europe = new Continent("Europe");
        europe.addCountry(country1);
        europe.addCountry(country2);
        europe.addCountry(country3);

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(country4);
        northAmerica.addCountry(country5);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(northAmerica);

        //When
        BigDecimal result = world.getPeopleQuantity();
        BigDecimal expected = new BigDecimal("6221963984608");

        //Then
        Assertions.assertEquals(expected, result);
    }
}
