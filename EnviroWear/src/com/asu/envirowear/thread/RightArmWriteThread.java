package com.asu.envirowear.thread;

import com.asu.envirowear.runable.RightArmWriteRunnable;

public class RightArmWriteThread {

	private Thread writeThread = null;

	public RightArmWriteThread(RightArmWriteRunnable writeRunnable) {
		this.writeThread = new Thread(writeRunnable);
	}

	public void execute() {
		this.writeThread.start();
	}

}
