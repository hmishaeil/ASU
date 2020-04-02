package com.asu.envirowear.temperature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TemperatureInput3 {

	private Integer lineNumber = 1;
	private String temperatureInputs = null;

	private Integer leftArmTemperatureInput;
	private Integer rightArmTemperatureInput;
	private Integer leftlegTemperatureInput;
	private Integer rightLegTemperatureInput;
	private Integer chestTemperatureInput;

	public void readCurrentTemperatureInputs() {
		try {
			this.temperatureInputs = Files.readAllLines(Paths.get("resource/temperature.csv")).get(this.lineNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String temperatures[] = this.temperatureInputs.split(",");

		this.chestTemperatureInput = Integer.parseInt(temperatures[1]);
		this.leftArmTemperatureInput = Integer.parseInt(temperatures[2]);
		this.rightArmTemperatureInput = Integer.parseInt(temperatures[3]);
		this.leftlegTemperatureInput = Integer.parseInt(temperatures[4]);
		this.rightLegTemperatureInput = Integer.parseInt(temperatures[5]);

		if (this.lineNumber == 10) {
			this.lineNumber = 1;
		} else {
			this.lineNumber++;
		}
		
		System.out.println("line number is: " + this.lineNumber);

	}

	public Integer getLeftArmTemperatureInput() {
		return leftArmTemperatureInput;
	}

	public Integer getRightArmTemperatureInput() {
		return rightArmTemperatureInput;
	}

	public Integer getLeftlegTemperatureInput() {
		return leftlegTemperatureInput;
	}

	public Integer getRightLegTemperatureInput() {
		return rightLegTemperatureInput;
	}

	public Integer getChestTemperatureInput() {
		return chestTemperatureInput;
	}

}
