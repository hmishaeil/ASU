package com.asu.envirowear.temperature;

import javax.swing.JButton;

public class TemperatureThreshold {

	JButton buttonInfo;
	JButton buttonCtrl;
	JButton buttonProgress;
	JButton buttonNew;
	private Integer minTemperature = 0;
	private Integer maxTemperature = 0;
	private Integer currentTemperature = 0;

	public static enum TemperatureStatus {
		ABOVE_RANGE, BELOW_RANGE, IN_RANGE
	}

	public TemperatureThreshold(JButton buttonInfo, JButton buttonCtrl, JButton buttonProgress, JButton buttonNew,
			Integer min, Integer max) {
		this.buttonInfo = buttonInfo;
		this.buttonCtrl = buttonCtrl;
		this.buttonProgress = buttonProgress;
		this.buttonNew = buttonNew;
		this.minTemperature = min;
		this.maxTemperature = max;

		this.buttonInfo
				.setText(this.buttonInfo.getText() + " [" + this.minTemperature + ", " + this.maxTemperature + "]");

		this.buttonProgress.setText("N/A");
		this.buttonNew.setText("N/A");
	}

	public Integer getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(Integer currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	public Integer getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(Integer minTemperature) {
		this.minTemperature = minTemperature;
	}

	public Integer getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(Integer maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public TemperatureStatus getCurrentTemperatureRangeStatus() {
		if (this.currentTemperature < this.minTemperature) {
			return TemperatureStatus.BELOW_RANGE;
		} else if (this.currentTemperature > this.maxTemperature) {
			return TemperatureStatus.ABOVE_RANGE;
		} else {
			return TemperatureStatus.IN_RANGE;
		}
	}

	public void decreaseTemperature() {
		int unit = this.currentTemperature - this.maxTemperature;

		this.buttonCtrl
				.setText("Decreasing Temperature from " + this.currentTemperature + " to " + this.maxTemperature);

		this.buttonProgress.setText("In Progress...");

		while (unit > 0) {
			try {
				System.out
						.println("decreasing: current: " + this.currentTemperature + " target: " + this.maxTemperature);

				Thread.sleep(1000);
				this.currentTemperature--;
				unit--;

				this.buttonNew.setText(Integer.toString(this.currentTemperature));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.buttonProgress.setText("DONE!");
		this.buttonNew.setText(Integer.toString(this.maxTemperature));

	}

	public void increaseTemperature() {
		int unit = this.minTemperature - this.currentTemperature;

		this.buttonCtrl
				.setText("Increasing Temperature from " + this.currentTemperature + " to " + this.minTemperature);
		this.buttonProgress.setText("In Progress...");

		while (unit > 0) {
			try {
				Thread.sleep(1000);
				System.out
						.println("increasing: current: " + this.currentTemperature + " target: " + this.minTemperature);
				this.currentTemperature++;
				unit--;
				this.buttonNew.setText(Integer.toString(this.currentTemperature));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.buttonNew.setText(Integer.toString(this.minTemperature));
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
