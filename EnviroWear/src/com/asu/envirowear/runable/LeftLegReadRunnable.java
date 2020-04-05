package com.asu.envirowear.runable;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.input.TemperatureInput;
import com.asu.envirowear.temperature.TemperatureController;

public class LeftLegReadRunnable implements Runnable {

	Object lock = null;
	TemperatureInput leftLegTemperatureInput = null;
	TemperatureController temperatureController = null;

	public LeftLegReadRunnable(Object lock, TemperatureController temperatureController) {
		this.lock = lock;
		this.leftLegTemperatureInput = new TemperatureInput(EnviroWearModule.LEFT_LEG);
		this.temperatureController = temperatureController;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lock) {

				this.temperatureController.setCurrentTemperature(leftLegTemperatureInput.getCurrentTemperature());

				try {
					this.lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
