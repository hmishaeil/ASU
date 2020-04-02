package com.asu.envirowear.app;

import com.asu.envirowear.panel.Display;
import com.asu.envirowear.runable.ChestReadRunnable;
import com.asu.envirowear.runable.ChestWriteRunnable;
import com.asu.envirowear.temperature.TemperatureInput;
import com.asu.envirowear.temperature.TemperatureThreshold;
import com.asu.envirowear.thread.ChestReadThread;
import com.asu.envirowear.thread.ChestWriteThread;

public class EnviroWear {

	public static void main(String[] args) throws InterruptedException {

		Display display = new Display();

		Object chestLockObject = new Object();
		TemperatureInput chestTemperatureInput = new TemperatureInput("chest");

		TemperatureThreshold chestTemperatureThreshold = new TemperatureThreshold(display.getMapInfo().get("chest"),
				display.getMapCtrl().get("chest"), display.getMapProgress().get("chest"),
				display.getMapNew().get("chest"), 97, 99);

		ChestReadRunnable chestReadRunnable = new ChestReadRunnable(chestLockObject, chestTemperatureInput,
				chestTemperatureThreshold, display.getMapReader().get("chest"));
		ChestReadThread chestReadThread = new ChestReadThread(chestReadRunnable);
		chestReadThread.execute();

		ChestWriteRunnable chestWriteRunnable = new ChestWriteRunnable(chestLockObject, chestTemperatureInput,
				chestTemperatureThreshold, display.getMapCtrl().get("chest"));
		ChestWriteThread chestWriteThread = new ChestWriteThread(chestWriteRunnable);
		chestWriteThread.execute();

	}
}
