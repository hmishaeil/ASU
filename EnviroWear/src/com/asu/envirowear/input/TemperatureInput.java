package com.asu.envirowear.input;

import com.asu.envirowear.common.EnviroWearModule;

public class TemperatureInput {

	String module = "";
	private Integer index = 0;

	public TemperatureInput(String module) {
		this.module = module;
	}

	public Integer getCurrentTemperature() {

		Integer currentTemperature = 0;

		switch (module) {
		case EnviroWearModule.CHEST:
			currentTemperature = EnviroWearModule.ChestInputTemperatures[this.index];
			break;
		case EnviroWearModule.LEFT_ARM:
			currentTemperature = EnviroWearModule.LeftArmInputTemperatures[this.index];
			break;
		case EnviroWearModule.RIGHT_ARM:
			currentTemperature = EnviroWearModule.RightArmInputTemperatures[this.index];
			break;
		case EnviroWearModule.LEFT_LEG:
			currentTemperature = EnviroWearModule.LeftLegInputTemperatures[this.index];
			break;
		case EnviroWearModule.RIGHT_LEG:
			currentTemperature = EnviroWearModule.RightLegInputTemperatures[this.index];
			break;
		default:
			throw new RuntimeException("Unknown module category");
		}

		if (this.index == 9) {
			this.index = 0;
		} else {
			this.index++;
		}

		return currentTemperature;
	}

}
