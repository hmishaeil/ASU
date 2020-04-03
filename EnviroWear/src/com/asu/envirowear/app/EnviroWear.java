package com.asu.envirowear.app;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.input.TemperatureInput;
import com.asu.envirowear.panel.Display;
import com.asu.envirowear.runable.ChestReadRunnable;
import com.asu.envirowear.runable.ChestWriteRunnable;
import com.asu.envirowear.temperature.TemperatureController;
import com.asu.envirowear.thread.ChestReadThread;
import com.asu.envirowear.thread.ChestWriteThread;

public class EnviroWear {

	public static void main(String[] args) throws InterruptedException {

		Display display = new Display();

		Object chestLockObject = new Object();
		
		TemperatureInput chestTemperatureInput = new TemperatureInput(EnviroWearModule.CHEST);
		TemperatureController chestTemperatureController = new TemperatureController(EnviroWearModule.CHEST, display);

		ChestReadRunnable chestReadRunnable = new ChestReadRunnable(chestLockObject, chestTemperatureInput,chestTemperatureController);
		ChestReadThread chestReadThread = new ChestReadThread(chestReadRunnable);
		chestReadThread.execute();

		ChestWriteRunnable chestWriteRunnable = new ChestWriteRunnable(chestLockObject, chestTemperatureInput, chestTemperatureController);
		ChestWriteThread chestWriteThread = new ChestWriteThread(chestWriteRunnable);
		chestWriteThread.execute();

	}
}
