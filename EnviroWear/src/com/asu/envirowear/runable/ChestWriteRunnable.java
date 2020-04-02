package com.asu.envirowear.runable;

import javax.swing.JButton;

import com.asu.envirowear.temperature.TemperatureInput;
import com.asu.envirowear.temperature.TemperatureThreshold;
import com.asu.envirowear.temperature.TemperatureThreshold.TemperatureStatus;

public class ChestWriteRunnable implements Runnable {

	Object lockObject = null;
	TemperatureInput temperatureInput = null;
	TemperatureThreshold temperatureThreshold = null;
	JButton buttonCtrl = null;

	public ChestWriteRunnable(Object lockObject, TemperatureInput temperatureInput,
			TemperatureThreshold temperatureThreshold, JButton buttonCtrl) {
		this.lockObject = lockObject;
		this.temperatureInput = temperatureInput;
		this.temperatureThreshold = temperatureThreshold;
		this.buttonCtrl = buttonCtrl;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (this.lockObject) {
//				temperatureThreshold.setCurrentTemperature(this.temperatureInput.getChestTemperatureInput());

				TemperatureStatus temperatureStatusRange = this.temperatureThreshold.getCurrentTemperatureRangeStatus();
				switch (temperatureStatusRange) {

				case ABOVE_RANGE:
					System.out.println("above range detected");
					temperatureThreshold.decreaseTemperature();
					break;
				case BELOW_RANGE:
					System.out.println("below range detected");
					temperatureThreshold.increaseTemperature();
					break;
				case IN_RANGE:
					System.out.println("in-range detected");
					temperatureThreshold.temperatureInRange();

					break;
				default:
					System.out.println("something bad happened!!!");
					break;
				}

				System.out.println("let me wake him up!");
				this.lockObject.notify();
			}
		}
	}
}
