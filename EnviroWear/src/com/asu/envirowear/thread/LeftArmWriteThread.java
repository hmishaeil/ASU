package com.asu.envirowear.thread;

import com.asu.envirowear.runable.LeftArmWriteRunnable;

public class LeftArmWriteThread {

	private Thread writeThread = null;

	public LeftArmWriteThread(LeftArmWriteRunnable writeRunnable) {
		this.writeThread = new Thread(writeRunnable);
	}

	public void execute() {
		this.writeThread.start();
	}

}
