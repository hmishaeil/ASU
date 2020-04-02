package com.asu.envirowear.temperature;

import javax.swing.JButton;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.panel.Display;

public class TemperatureController {

	JButton buttonInfo;
	JButton buttonCtrl;
	JButton buttonProgress;
	JButton buttonNew;
	private Integer currentTemperature = 0;
	String module = "";

	public static enum TemperatureStatus {
		ABOVE_RANGE, BELOW_RANGE, IN_RANGE
	}

	public TemperatureController(String module, Display display) {
		this.buttonInfo = display.getMapInfo().get(EnviroWearModule.CHEST);
		this.buttonCtrl = display.getMapCtrl().get(EnviroWearModule.CHEST);
		this.buttonProgress = display.getMapProgress().get(EnviroWearModule.CHEST);
		this.buttonNew = display.getMapNew().get(EnviroWearModule.CHEST);
		this.module = module;

		this.buttonInfo.setText(this.module + " [" + EnviroWearModule.CHEST_MIN_TEMEPERATURE_THRESHOLD + ", "
				+ EnviroWearModule.CHEST_MAX_TEMEPERATURE_THRESHOLD + "]");

		this.buttonProgress.setText("N/A");
		this.buttonNew.setText("N/A");
	}

	public Integer getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(Integer currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public TemperatureStatus getCurrentTemperatureRangeStatus() {
		if (this.currentTemperature < EnviroWearModule.CHEST_MIN_TEMEPERATURE_THRESHOLD) {
			return TemperatureStatus.BELOW_RANGE;
		} else if (this.currentTemperature > EnviroWearModule.CHEST_MAX_TEMEPERATURE_THRESHOLD) {
			return TemperatureStatus.ABOVE_RANGE;
		} else {
			return TemperatureStatus.IN_RANGE;
		}
	}

	public void decreaseTemperature() {
		int unit = this.currentTemperature - EnviroWearModule.CHEST_MAX_TEMEPERATURE_THRESHOLD;

		this.buttonCtrl.setText("Decreasing Temperature from " + this.currentTemperature + " to "
				+ EnviroWearModule.CHEST_MAX_TEMEPERATURE_THRESHOLD);

		this.buttonProgress.setText("In Progress...");

		while (unit > 0) {
			try {

				Thread.sleep(1000);
				this.currentTemperature--;
				unit--;

				this.buttonNew.setText(Integer.toString(this.currentTemperature));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.buttonProgress.setText("DONE!");

	}

	public void increaseTemperature() {
		int unit = EnviroWearModule.CHEST_MIN_TEMEPERATURE_THRESHOLD - this.currentTemperature;

		this.buttonCtrl
				.setText("Increasing Temperature from " + this.currentTemperature + " to " + EnviroWearModule.CHEST_MIN_TEMEPERATURE_THRESHOLD);
		this.buttonProgress.setText("In Progress...");

		while (unit > 0) {
			try {
				Thread.sleep(1000);
				System.out
						.println("increasing: current: " + this.currentTemperature + " target: " + EnviroWearModule.CHEST_MIN_TEMEPERATURE_THRESHOLD);
				this.currentTemperature++;
				unit--;
				this.buttonNew.setText(Integer.toString(this.currentTemperature));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.buttonProgress.setText("DONE!");
	}

	public void temperatureInRange() {
		this.buttonCtrl.setText("Temperature Is Acceptable. No Action Required.");
		this.buttonNew.setText("N/A");
		this.buttonProgress.setText("N/A");
	}

	public void resetButtonsText() {
		this.buttonCtrl.setText("N/A");
		this.buttonNew.setText("N/A");
		this.buttonProgress.setText("N/A");
	}

}
