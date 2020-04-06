package com.asu.envirowear.runable;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.controller.TemperatureController;
import com.asu.envirowear.input.TemperatureInput;

public class LeftArmReadRunnable implements Runnable {

	Object lock = null;
	TemperatureInput leftArmTemperatureInput = null;
	TemperatureController temperatureController = null;

	public LeftArmReadRunnable(Object lock, TemperatureController temperatureController) {
		this.lock = lock;
		this.leftArmTemperatureInput = new TemperatureInput(EnviroWearModule.LEFT_ARM);
		this.temperatureController = temperatureController;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lock) {

				this.temperatureController.setCurrentTemperature(leftArmTemperatureInput.getCurrentTemperature());

				try {
					this.lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
}
