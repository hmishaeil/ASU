package com.asu.envirowear.runable;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.controller.TemperatureController;
import com.asu.envirowear.input.TemperatureInput;

public class RightArmReadRunnable implements Runnable {

	Object lock = null;
	TemperatureInput rightArmTemperatureInput = null;
	TemperatureController temperatureController = null;

	public RightArmReadRunnable(Object lock, TemperatureController temperatureController) {
		this.lock = lock;
		this.rightArmTemperatureInput = new TemperatureInput(EnviroWearModule.RIGHT_ARM);
		this.temperatureController = temperatureController;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lock) {

				this.temperatureController.setCurrentTemperature(rightArmTemperatureInput.getCurrentTemperature());

				try {
					this.lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
}
