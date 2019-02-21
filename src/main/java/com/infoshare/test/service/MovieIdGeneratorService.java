package com.infoshare.test.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MovieIdGeneratorService {

    private final Random random = new Random();

    public long generateId() {
        return random.nextLong();
    }

}
