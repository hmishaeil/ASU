package com.asu.envirowear.runable;

import java.awt.Color;
import javax.swing.JButton;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.input.TemperatureInput;
import com.asu.envirowear.temperature.TemperatureController;

public class ChestReadRunnable implements Runnable {

	Object lock = null;
	TemperatureInput chestTemperatureInput = null;

	TemperatureController temperatureController = null;
	JButton currentTemperatureButton = null;

	Integer currentChessTemperature = 0;

	public ChestReadRunnable(Object lock, TemperatureInput chestTemperatureInput,
			TemperatureController temperatureController) {
		this.lock = lock;
		this.chestTemperatureInput = chestTemperatureInput;
		this.temperatureController = temperatureController;
		this.currentTemperatureButton = this.temperatureController.getDisplay().getMapReader()
				.get(EnviroWearModule.CHEST);

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lock) {

				this.temperatureController.resetButtonsText();

				currentChessTemperature = chestTemperatureInput.getCurrentTemperature();

				this.temperatureController.setCurrentTemperature(currentChessTemperature);

				this.currentTemperatureButton.setText(Integer.toString(currentChessTemperature));

				switch (this.temperatureController.getCurrentTemperatureRangeStatus()) {
				case ABOVE_RANGE:
					this.currentTemperatureButton.setForeground(new Color(255, 0, 0));
					break;
				case BELOW_RANGE:
					this.currentTemperatureButton.setForeground(new Color(255, 179, 0));
					break;
				case IN_RANGE:
					this.currentTemperatureButton.setForeground(new Color(0, 179, 0));
					break;
				default:
					throw new RuntimeException("Unknown temperature range category");
				}

				try {
					this.lock.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		}
	}
}
