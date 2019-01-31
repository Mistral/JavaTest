package com.example.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class VehicleManager {

	private List<Vehicle> vehicles = new ArrayList<>();

	public VehicleManager() {
		createSomeVehicles();
	}

	private void createSomeVehicles() {
		vehicles.add(new Car());
		vehicles.add(new Amphibia());
		vehicles.add(new JetBoard());
		vehicles.add(new Airplane());
	}

	public void moveAllVehicles() {
		vehicles.forEach(vehicle -> {
			System.out.println(vehicle.getClass().getName().replace("com.example.vehicle.", "") + " OUTPUT: ");
			Stream.of(Environment.WATER, Environment.GROUND, Environment.AIRSPACE)
				  .forEach(vehicle::move);
			System.out.println();
		});
	}

}
