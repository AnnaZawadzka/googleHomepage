package com.google.helpers;

import com.github.javafaker.Faker;
import org.slf4j.Logger;

import static java.lang.String.*;
import static org.slf4j.LoggerFactory.getLogger;

public class DataGenerator {
    private static final Logger LOGGER = getLogger(DataGenerator.class);

    public static String generateRandomCapital() {
        Faker faker = new Faker();
        String capital = faker.country().capital();
        LOGGER.info(format("Generated string: %s", capital.toUpperCase()));
        return capital;
    }


}
