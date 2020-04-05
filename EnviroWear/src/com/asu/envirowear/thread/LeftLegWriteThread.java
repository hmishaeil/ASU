package com.asu.envirowear.thread;

import com.asu.envirowear.runable.LeftLegWriteRunnable;

public class LeftLegWriteThread {

	private Thread writeThread = null;

	public LeftLegWriteThread(LeftLegWriteRunnable writeRunnable) {
		this.writeThread = new Thread(writeRunnable);
	}

	public void execute() {
		this.writeThread.start();
	}

}
