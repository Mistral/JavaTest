package com.example;

import com.example.arrayIterator.Task;
import com.example.arrayIterator.ArrayIterator;
import com.example.vehicle.VehicleManager;

class Application {

	public static void main(String[] args) {
		runArrayIteratorTask();
		runVehicleTask();
	}

	private static void runArrayIteratorTask() {
		int[][] exampleArray = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};

		ArrayIterator<Integer> iterator = new Task().getIterator(exampleArray);

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	private static void runVehicleTask() {
		VehicleManager vehicleManager = new VehicleManager();
		vehicleManager.moveAllVehicles();
	}

}
