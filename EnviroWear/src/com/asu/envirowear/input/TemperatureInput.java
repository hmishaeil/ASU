package com.asu.envirowear.input;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.asu.envirowear.common.EnviroWearModule;

public class TemperatureInput {

	String module = "";
	private Integer lineNumber = 1;
	private String temperatureInputs = null;

	public TemperatureInput(String module) {
		this.module = module;
	}

	private String[] readCurrentTemperatureInputs() {
		try {
			this.temperatureInputs = Files.readAllLines(Paths.get("resource/temperature.csv")).get(this.lineNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (this.lineNumber == 10) {
			this.lineNumber = 1;
		} else {
			this.lineNumber++;
		}

		return this.temperatureInputs.split(",");

	}

	public Integer getCurrentTemperature() {
		Integer module_index = 0;
		String[] temperatures = readCurrentTemperatureInputs();

		switch (module) {
		case EnviroWearModule.CHEST:
			module_index = 1;
			break;
		case EnviroWearModule.LEFT_ARM:
			module_index = 2;
			break;
		case EnviroWearModule.RIGHT_ARM:
			module_index = 3;
			break;
		case EnviroWearModule.LEFT_LEG:
			module_index = 4;
			break;
		case EnviroWearModule.RIGHT_LEG:
			module_index = 5;
			break;
		default:
			System.out.println("somthing bad happened!");
			break;
		}

		return Integer.parseInt(temperatures[module_index]);
	}

}
