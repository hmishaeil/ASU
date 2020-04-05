package com.asu.envirowear.thread;

import com.asu.envirowear.runable.RightLegReadRunnable;

public class RightLegReadThread {

	private Thread readThread = null;

	public RightLegReadThread(RightLegReadRunnable readRunnable) {
		this.readThread = new Thread(readRunnable);
	}

	public void execute() {
		readThread.start();
	}
}
