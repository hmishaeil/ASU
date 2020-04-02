package com.asu.envirowear.runable;

import java.awt.Color;
import javax.swing.JButton;
import com.asu.envirowear.temperature.TemperatureInput;
import com.asu.envirowear.temperature.TemperatureThreshold;

public class ChestReadRunnable implements Runnable {

	Object lockObject = null;
	TemperatureInput temperatureInput = null;
	TemperatureThreshold temperatureThreshold = null;
	JButton button = null;

	String text = "";
	Integer currentChessTemperature = 0;

	public ChestReadRunnable(Object lockObject, TemperatureInput temperatureInput,
			TemperatureThreshold temperatureThreshold, JButton button) {
		this.lockObject = lockObject;
		this.temperatureInput = temperatureInput;
		this.temperatureThreshold = temperatureThreshold;
		this.button = button;
		this.text = "Chest";

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (this.lockObject) {


				this.temperatureThreshold.resetButtonsText();
				
				this.temperatureInput.readCurrentTemperatureInputs();

				currentChessTemperature = temperatureInput.getChestTemperatureInput();

				this.temperatureThreshold.setCurrentTemperature(currentChessTemperature);

				this.button.setText(Integer.toString(currentChessTemperature));

				switch (this.temperatureThreshold.getCurrentTemperatureRangeStatus()) {
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
					this.lockObject.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
}
