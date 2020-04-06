package com.asu.envirowear.controller;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import com.asu.envirowear.panel.Display;

public class TemperatureController {

	JButton moduleButton;
	JButton currentTemperatureButton;
	JButton actionTakenButton;
	JButton progressStatusButton;
	JButton updatedTemperatureButton;

	Integer minTemperatureThreshold;
	Integer maxTemperatureThreshold;

	Integer currentTemperature;
	String module;
	Display display;

	String log;

	File file = null;
	FileWriter fileWriter = null;

	public enum TemperatureStatus {
		ABOVE_RANGE, BELOW_RANGE, IN_RANGE
	}

	public TemperatureController(String module, Display display, Integer minTemperatureThreshold,
			Integer maxTemperatureThreshold) {

		file = new File(module.replaceAll("\\s", "") + ".log");
		if (file.exists() && file.isFile()) {
			file.delete();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.module = module;
		this.display = display;

		this.minTemperatureThreshold = minTemperatureThreshold;
		this.maxTemperatureThreshold = maxTemperatureThreshold;

		this.moduleButton = display.getMapInfo().get(module);
		this.currentTemperatureButton = display.getMapReader().get(module);
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

		initButtonsText();

		this.currentTemperature = currentTemperature;

		this.currentTemperatureButton.setText(Integer.toString(currentTemperature));

		switch (getCurrentTemperatureRangeStatus()) {
		case ABOVE_RANGE:
			this.currentTemperatureButton.setForeground(new Color(255, 0, 0));
			break;
		case BELOW_RANGE:
			this.currentTemperatureButton.setForeground(new Color(255, 179, 0));
			break;
		case IN_RANGE:
			this.currentTemperatureButton.setForeground(new Color(0, 179, 0));
			break;
		default:
			throw new RuntimeException("Unknown temperature range category");
		}
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

		log = this.currentTemperature + ";" + unit + ";" + this.maxTemperatureThreshold + ";";

		this.actionTakenButton.setText(
				"Decreasing Temperature from " + this.currentTemperature + " to " + this.maxTemperatureThreshold);

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

		log += this.currentTemperature;
		logger();

	}

	public void increaseTemperature() {
		int unit = this.minTemperatureThreshold - this.currentTemperature;

		log = this.currentTemperature + ";" + unit + ";" + this.minTemperatureThreshold + ";";

		this.actionTakenButton.setText(
				"Increasing Temperature from " + this.currentTemperature + " to " + this.minTemperatureThreshold);
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

		log += this.currentTemperature;
		this.progressStatusButton.setText("DONE!");

		logger();

	}

	public void temperatureInRange() {

		log = this.currentTemperature + ";0;N/A;N/A";

		this.actionTakenButton.setText("Temperature Is Acceptable. No Action Required.");
		this.updatedTemperatureButton.setText("N/A");
		this.progressStatusButton.setText("N/A");

		logger();

	}

	public void initButtonsText() {
		this.actionTakenButton.setText(null);
		this.progressStatusButton.setText(null);
		this.updatedTemperatureButton.setText(null);
	}

	public void adjustTemperature() {
		switch (getCurrentTemperatureRangeStatus()) {
		case ABOVE_RANGE:
			decreaseTemperature();
			break;
		case BELOW_RANGE:
			increaseTemperature();
			break;
		case IN_RANGE:
			temperatureInRange();
			break;
		default:
			throw new RuntimeException("Unknown temperature range category");
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void logger() {
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.write(log + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
