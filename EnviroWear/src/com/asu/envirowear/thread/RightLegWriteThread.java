package com.asu.envirowear.thread;

import com.asu.envirowear.runable.RightLegWriteRunnable;

public class RightLegWriteThread {

	private Thread writeThread = null;

	public RightLegWriteThread(RightLegWriteRunnable writeRunnable) {
		this.writeThread = new Thread(writeRunnable);
	}

	public void execute() {
		this.writeThread.start();
	}

}
