package com.asu.envirowear.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		readCurrentTemperatureInputs();
		switch (module) {
		case "chest":
			module_index = 1;
			break;
		case "left_arm":
			module_index = 2;
			break;
		case "right_arm":
			module_index = 3;
			break;
		case "left_leg":
			module_index = 4;
			break;
		case "right_leg":
			module_index = 5;
			break;
		default:
			System.out.println("somthing bad happened!");
			break;
		}

		return Integer.parseInt(readCurrentTemperatureInputs()[module_index]);
	}

}
