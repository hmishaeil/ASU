package com.asu.envirowear.runable;

import com.asu.envirowear.controller.TemperatureController;

public class ChestWriteRunnable implements Runnable {

	Object lock = null;
	TemperatureController temperatureController = null;

	public ChestWriteRunnable(Object lockObject, TemperatureController temperatureController) {
		this.lock = lockObject;
		this.temperatureController = temperatureController;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (this.lock) {
				this.temperatureController.adjustTemperature();
				this.lock.notify();
			}
		}
	}
}
