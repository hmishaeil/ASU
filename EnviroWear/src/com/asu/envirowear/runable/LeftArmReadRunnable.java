package com.asu.envirowear.runable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.asu.envirowear.temperature.TemperatureInput;

public class LeftArmReadRunnable implements Runnable {

	Object lockObject = null;
	TemperatureInput temperatureInput = null;

	public LeftArmReadRunnable(Object lockObject, TemperatureInput temperatureInput) {
		this.lockObject = lockObject;
		this.temperatureInput = temperatureInput;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lockObject) {
				this.temperatureInput.readCurrentTemperatureInputs();

				try {
					Files.readAllLines(Paths.get("resource/temperature.csv"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				try {
					System.out.println("##### from left arm going to wait mode...");
					this.lockObject.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
