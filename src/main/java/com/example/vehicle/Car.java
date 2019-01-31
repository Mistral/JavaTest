package com.example.vehicle;

import java.util.Arrays;
import java.util.List;

class Car implements Vehicle {

    private List<Environment> environments;

    Car() {
        environments = Arrays.asList(Environment.GROUND);
    }

    @Override
    public void move(Environment env) {
        if (environments.contains(env)) {
            System.out.println("MOVING IN: " + env);
        }
    }

}
