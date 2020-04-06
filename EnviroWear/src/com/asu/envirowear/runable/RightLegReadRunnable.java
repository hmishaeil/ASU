package com.asu.envirowear.runable;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.controller.TemperatureController;
import com.asu.envirowear.input.TemperatureInput;

public class RightLegReadRunnable implements Runnable {

	Object lock = null;
	TemperatureInput rightLegTemperatureInput = null;
	TemperatureController temperatureController = null;

	public RightLegReadRunnable(Object lock, TemperatureController temperatureController) {
		this.lock = lock;
		this.rightLegTemperatureInput = new TemperatureInput(EnviroWearModule.RIGHT_LEG);
		this.temperatureController = temperatureController;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lock) {

				this.temperatureController.setCurrentTemperature(rightLegTemperatureInput.getCurrentTemperature());

				try {
					this.lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
