package com.asu.envirowear.thread;

import com.asu.envirowear.runable.ChestReadRunnable;

public class ChestReadThread {

	private Thread readThread = null;

	public ChestReadThread(ChestReadRunnable readRunnable) {
		this.readThread = new Thread(readRunnable);
	}

	public void execute() {
		readThread.start();
	}
}
