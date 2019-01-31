package com.example.vehicle;

import java.util.Arrays;
import java.util.List;

class JetBoard implements Vehicle {

	private List<Environment> environments;

	JetBoard() {
		environments = Arrays.asList(Environment.WATER, Environment.GROUND, Environment.AIRSPACE);
	}

	@Override
	public void move(Environment env) {
		if (environments.contains(env)) {
			System.out.println("MOVING IN: " + env);
		}
	}

}
