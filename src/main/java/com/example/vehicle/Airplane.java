package com.example.vehicle;

import java.util.Arrays;
import java.util.List;

class Airplane implements Vehicle {

    private List<Environment> environments;

    Airplane() {
        environments = Arrays.asList(Environment.AIRSPACE);
    }

    @Override
    public void move(Environment env) {
        if (environments.contains(env)) {
            System.out.println("MOVING IN: " + env);
        }
    }

}
