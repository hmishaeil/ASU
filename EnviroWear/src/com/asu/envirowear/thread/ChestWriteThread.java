package com.asu.envirowear.thread;

import com.asu.envirowear.runable.ChestWriteRunnable;

public class ChestWriteThread {

	private Thread writeThread = null;

	public ChestWriteThread(ChestWriteRunnable writeRunnable) {
		this.writeThread = new Thread(writeRunnable);
	}

	public void execute() {
		this.writeThread.start();
	}

}
