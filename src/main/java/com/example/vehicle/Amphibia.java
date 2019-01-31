package com.example.vehicle;

import java.util.Arrays;
import java.util.List;

class Amphibia implements Vehicle {

	private List<Environment> environments;

	Amphibia() {
		environments = Arrays.asList(Environment.WATER, Environment.GROUND);
	}

	@Override
	public void move(Environment env) {
		if (environments.contains(env)) {
			System.out.println("MOVING IN: " + env);
		}
	}

}
