package com.asu.envirowear.thread;

import com.asu.envirowear.runable.LeftLegReadRunnable;

public class LeftLegReadThread {

	private Thread readThread = null;

	public LeftLegReadThread(LeftLegReadRunnable readRunnable) {
		this.readThread = new Thread(readRunnable);
	}

	public void execute() {
		readThread.start();
	}
}
