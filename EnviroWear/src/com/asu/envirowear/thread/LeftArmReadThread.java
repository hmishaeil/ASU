package com.asu.envirowear.thread;

import com.asu.envirowear.runable.LeftArmReadRunnable;

public class LeftArmReadThread {

	private Thread readThread = null;

	public LeftArmReadThread(LeftArmReadRunnable readRunnable) {
		this.readThread = new Thread(readRunnable);
	}

	public void execute() {
		readThread.start();
	}
}
