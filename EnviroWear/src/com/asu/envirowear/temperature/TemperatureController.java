package com.asu.envirowear.temperature;

import javax.swing.JButton;
import com.asu.envirowear.panel.Display;

public class TemperatureController {

	JButton moduleButton;
	JButton actionTakenButton;
	JButton progressStatusButton;
	JButton updatedTemperatureButton;

	Integer minTemperatureThreshold;
	Integer maxTemperatureThreshold;

	Integer currentTemperature;
	String module;
	Display display;

	public static enum TemperatureStatus {
		ABOVE_RANGE, BELOW_RANGE, IN_RANGE
	}

	public TemperatureController(String module, Display display, Integer minTemperatureThreshold, Integer maxTemperatureThreshold) {
		
		this.module = module;
		this.display = display;
		
		this.minTemperatureThreshold = minTemperatureThreshold;
		this.maxTemperatureThreshold = maxTemperatureThreshold;
		
		this.moduleButton = display.getMapInfo().get(module);
		this.actionTakenButton = display.getMapCtrl().get(module);
		this.progressStatusButton = display.getMapProgress().get(module);
		this.updatedTemperatureButton = display.getMapNew().get(module);
		
		this.moduleButton.setText(this.module + " [" + minTemperatureThreshold + ", " + maxTemperatureThreshold + "]");

		this.progressStatusButton.setText("N/A");
		this.updatedTemperatureButton.setText("N/A");
	}

	public Display getDisplay() {
		return this.display;
	}

	public Integer getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(Integer currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public TemperatureStatus getCurrentTemperatureRangeStatus() {
		if (this.currentTemperature < this.minTemperatureThreshold) {
			return TemperatureStatus.BELOW_RANGE;
		} else if (this.currentTemperature > this.maxTemperatureThreshold) {
			return TemperatureStatus.ABOVE_RANGE;
		} else {
			return TemperatureStatus.IN_RANGE;
		}
	}

	public void decreaseTemperature() {
		int unit = this.currentTemperature - this.maxTemperatureThreshold;

		this.actionTakenButton.setText("Decreasing Temperature from " + this.currentTemperature + " to " + this.maxTemperatureThreshold);

		this.progressStatusButton.setText("In Progress...");

		while (unit > 0) {
			try {

				Thread.sleep(1000);
				this.currentTemperature--;
				unit--;

				this.updatedTemperatureButton.setText(Integer.toString(this.currentTemperature));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.progressStatusButton.setText("DONE!");

	}

	public void increaseTemperature() {
		int unit = this.minTemperatureThreshold - this.currentTemperature;

		this.actionTakenButton.setText("Increasing Temperature from " + this.currentTemperature + " to " + this.minTemperatureThreshold);
		this.progressStatusButton.setText("In Progress...");

		while (unit > 0) {
			try {
				Thread.sleep(1000);
				this.currentTemperature++;
				unit--;
				this.updatedTemperatureButton.setText(Integer.toString(this.currentTemperature));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.progressStatusButton.setText("DONE!");
	}

	public void temperatureInRange() {
		this.actionTakenButton.setText("Temperature Is Acceptable. No Action Required.");
		this.updatedTemperatureButton.setText("N/A");
		this.progressStatusButton.setText("N/A");
	}

	public void resetButtonsText() {
		this.actionTakenButton.setText(null);
		this.progressStatusButton.setText(null);
		this.updatedTemperatureButton.setText(null);
	}

}
