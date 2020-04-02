package com.asu.envirowear.runable;

import java.awt.Color;
import javax.swing.JButton;

import com.asu.envirowear.input.TemperatureInput;
import com.asu.envirowear.temperature.TemperatureController;

public class ChestReadRunnable implements Runnable {

	Object lock = null;
	TemperatureInput chestTemperatureInput = null;

	TemperatureController temperatureController = null;
	JButton button = null;

	String text = "";
	Integer currentChessTemperature = 0;

	public ChestReadRunnable(Object lock, TemperatureInput chestTemperatureInput,
			TemperatureController temperatureController, JButton button) {
		this.lock = lock;
		this.chestTemperatureInput = chestTemperatureInput;
		this.temperatureController = temperatureController;
		this.button = button;
		this.text = "Chest";

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lock) {

				this.temperatureController.resetButtonsText();

				currentChessTemperature = chestTemperatureInput.getCurrentTemperature();

				this.temperatureController.setCurrentTemperature(currentChessTemperature);

				this.button.setText(Integer.toString(currentChessTemperature));

				switch (this.temperatureController.getCurrentTemperatureRangeStatus()) {
				case ABOVE_RANGE:
					this.button.setForeground(new Color(255, 0, 0));
					break;
				case BELOW_RANGE:
					this.button.setForeground(new Color(255, 179, 0));
					break;
				case IN_RANGE:
					this.button.setForeground(new Color(0, 179, 0));
					break;
				default:
					System.out.println("something bad happened!!!");
					break;
				}

				try {
					System.out.println("going to wait mode...");
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
