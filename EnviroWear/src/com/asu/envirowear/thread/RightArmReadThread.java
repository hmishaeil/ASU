package com.asu.envirowear.thread;

import com.asu.envirowear.runable.RightArmReadRunnable;

public class RightArmReadThread {

	private Thread readThread = null;

	public RightArmReadThread(RightArmReadRunnable readRunnable) {
		this.readThread = new Thread(readRunnable);
	}

	public void execute() {
		readThread.start();
	}
}
