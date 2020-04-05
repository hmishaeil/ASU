package com.asu.envirowear.runable;

import javax.swing.JButton;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.input.TemperatureInput;
import com.asu.envirowear.temperature.TemperatureController;
import com.asu.envirowear.temperature.TemperatureController.TemperatureStatus;

public class ChestWriteRunnable implements Runnable {

	Object lockObject = null;
	TemperatureInput temperatureInput = null;
	TemperatureController temperatureController = null;
	JButton buttonCtrl = null;

	public ChestWriteRunnable(Object lockObject, TemperatureInput temperatureInput,
			TemperatureController temperatureController) {
		this.lockObject = lockObject;
		this.temperatureInput = temperatureInput;
		this.temperatureController = temperatureController;
		this.buttonCtrl = this.temperatureController.getDisplay().getMapCtrl().get(EnviroWearModule.CHEST);
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (this.lockObject) {
				TemperatureStatus temperatureStatusRange = this.temperatureController
						.getCurrentTemperatureRangeStatus();
				switch (temperatureStatusRange) {
				case ABOVE_RANGE:
					temperatureController.decreaseTemperature();
					break;
				case BELOW_RANGE:
					temperatureController.increaseTemperature();
					break;
				case IN_RANGE:
					temperatureController.temperatureInRange();
					break;
				default:
					throw new RuntimeException("Unknown temperature range category");
				}

				this.lockObject.notify();
			}
		}
	}
}
