package com.asu.envirowear.runable;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.controller.TemperatureController;
import com.asu.envirowear.input.TemperatureInput;

public class ChestReadRunnable implements Runnable {

	Object lock = null;
	TemperatureInput chestTemperatureInput = null;
	TemperatureController temperatureController = null;

	public ChestReadRunnable(Object lock, TemperatureController temperatureController) {
		this.lock = lock;
		this.chestTemperatureInput = new TemperatureInput(EnviroWearModule.CHEST);
		this.temperatureController = temperatureController;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lock) {

				this.temperatureController.setCurrentTemperature(chestTemperatureInput.getCurrentTemperature());

				try {
					this.lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
