package com.asu.envirowear.app;

import com.asu.envirowear.common.EnviroWearModule;
import com.asu.envirowear.controller.TemperatureController;
import com.asu.envirowear.panel.Display;
import com.asu.envirowear.runable.ChestReadRunnable;
import com.asu.envirowear.runable.ChestWriteRunnable;
import com.asu.envirowear.runable.LeftArmReadRunnable;
import com.asu.envirowear.runable.LeftArmWriteRunnable;
import com.asu.envirowear.runable.LeftLegReadRunnable;
import com.asu.envirowear.runable.LeftLegWriteRunnable;
import com.asu.envirowear.runable.RightArmReadRunnable;
import com.asu.envirowear.runable.RightArmWriteRunnable;
import com.asu.envirowear.runable.RightLegReadRunnable;
import com.asu.envirowear.runable.RightLegWriteRunnable;
import com.asu.envirowear.thread.ChestReadThread;
import com.asu.envirowear.thread.ChestWriteThread;
import com.asu.envirowear.thread.LeftArmReadThread;
import com.asu.envirowear.thread.LeftArmWriteThread;
import com.asu.envirowear.thread.LeftLegReadThread;
import com.asu.envirowear.thread.LeftLegWriteThread;
import com.asu.envirowear.thread.RightArmReadThread;
import com.asu.envirowear.thread.RightArmWriteThread;
import com.asu.envirowear.thread.RightLegReadThread;
import com.asu.envirowear.thread.RightLegWriteThread;

public class EnviroWear {

	public static void main(String[] args) {

		Display display = new Display();

		// chest
		Object chestLockObject = new Object();

		TemperatureController chestTemperatureController = new TemperatureController(EnviroWearModule.CHEST, display,
				EnviroWearModule.CHEST_MIN_TEMEPERATURE_THRESHOLD, EnviroWearModule.CHEST_MAX_TEMEPERATURE_THRESHOLD);

		ChestReadRunnable chestReadRunnable = new ChestReadRunnable(chestLockObject, chestTemperatureController);
		ChestReadThread chestReadThread = new ChestReadThread(chestReadRunnable);
		chestReadThread.execute();

		ChestWriteRunnable chestWriteRunnable = new ChestWriteRunnable(chestLockObject, chestTemperatureController);
		ChestWriteThread chestWriteThread = new ChestWriteThread(chestWriteRunnable);
		chestWriteThread.execute();

		// left arm
		Object leftArmLockObject = new Object();

		TemperatureController leftArmTemperatureController = new TemperatureController(EnviroWearModule.LEFT_ARM,
				display, EnviroWearModule.LEFT_ARM_MIN_TEMEPERATURE_THRESHOLD,
				EnviroWearModule.LEFT_ARM_MAX_TEMEPERATURE_THRESHOLD);

		LeftArmReadRunnable leftArmReadRunnable = new LeftArmReadRunnable(leftArmLockObject,
				leftArmTemperatureController);
		LeftArmReadThread leftArmReadThread = new LeftArmReadThread(leftArmReadRunnable);
		leftArmReadThread.execute();

		LeftArmWriteRunnable leftArmWriteRunnable = new LeftArmWriteRunnable(leftArmLockObject,
				leftArmTemperatureController);
		LeftArmWriteThread leftArmWriteThread = new LeftArmWriteThread(leftArmWriteRunnable);
		leftArmWriteThread.execute();

		// right arm
		Object rightArmLockObject = new Object();

		TemperatureController rightArmTemperatureController = new TemperatureController(EnviroWearModule.RIGHT_ARM,
				display, EnviroWearModule.RIGHT_ARM_MIN_TEMEPERATURE_THRESHOLD,
				EnviroWearModule.RIGHT_ARM_MAX_TEMEPERATURE_THRESHOLD);

		RightArmReadRunnable rightArmReadRunnable = new RightArmReadRunnable(rightArmLockObject,
				rightArmTemperatureController);
		RightArmReadThread rightArmReadThread = new RightArmReadThread(rightArmReadRunnable);
		rightArmReadThread.execute();

		RightArmWriteRunnable rightArmWriteRunnable = new RightArmWriteRunnable(rightArmLockObject,
				rightArmTemperatureController);
		RightArmWriteThread rightArmWriteThread = new RightArmWriteThread(rightArmWriteRunnable);
		rightArmWriteThread.execute();

		// left leg
		Object leftLegLockObject = new Object();

		TemperatureController leftLegTemperatureController = new TemperatureController(EnviroWearModule.LEFT_LEG,
				display, EnviroWearModule.LEFT_LEG_MIN_TEMEPERATURE_THRESHOLD,
				EnviroWearModule.LEFT_LEG_MAX_TEMEPERATURE_THRESHOLD);

		LeftLegReadRunnable leftLegReadRunnable = new LeftLegReadRunnable(leftLegLockObject,
				leftLegTemperatureController);
		LeftLegReadThread leftLegReadThread = new LeftLegReadThread(leftLegReadRunnable);
		leftLegReadThread.execute();

		LeftLegWriteRunnable leftLegWriteRunnable = new LeftLegWriteRunnable(leftLegLockObject,
				leftLegTemperatureController);
		LeftLegWriteThread leftLegWriteThread = new LeftLegWriteThread(leftLegWriteRunnable);
		leftLegWriteThread.execute();

		// right leg
		Object rightLegLockObject = new Object();

		TemperatureController rightLegTemperatureController = new TemperatureController(EnviroWearModule.RIGHT_LEG,
				display, EnviroWearModule.RIGHT_LEG_MIN_TEMEPERATURE_THRESHOLD,
				EnviroWearModule.RIGHT_LEG_MAX_TEMEPERATURE_THRESHOLD);

		RightLegReadRunnable rightLegReadRunnable = new RightLegReadRunnable(rightLegLockObject,
				rightLegTemperatureController);
		RightLegReadThread rightLegReadThread = new RightLegReadThread(rightLegReadRunnable);
		rightLegReadThread.execute();

		RightLegWriteRunnable rightLegWriteRunnable = new RightLegWriteRunnable(rightLegLockObject,
				rightLegTemperatureController);
		RightLegWriteThread rightLegWriteThread = new RightLegWriteThread(rightLegWriteRunnable);
		rightLegWriteThread.execute();

	}
}
