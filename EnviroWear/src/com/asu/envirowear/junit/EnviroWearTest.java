/**
 * 
 */
package com.asu.envirowear.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.asu.envirowear.common.EnviroWearModule;

/**
 * @author Hooman Mishaeil
 *
 */
class EnviroWearTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testChestModule() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Chest.log"));
			String line = reader.readLine();
			System.out.println(line);
			while (line != null) {
				String[] temperatures = line.split(";");

				if (!temperatures[2].equals("N/A")) {
					Integer currentTemperature = Integer.parseInt(temperatures[0]);
					Integer deltaTemperature = Math
							.abs(Integer.parseInt(temperatures[0]) - Integer.parseInt(temperatures[2]));
					Integer updatedTemperature = Integer.parseInt(temperatures[3]);

					if (EnviroWearModule.CHEST_MAX_TEMEPERATURE_THRESHOLD < currentTemperature) {
						Integer expectedResult = currentTemperature - deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}

					if (EnviroWearModule.CHEST_MIN_TEMEPERATURE_THRESHOLD > currentTemperature) {
						Integer expectedResult = currentTemperature + deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testLeftArmModule() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("LeftArm.log"));
			String line = reader.readLine();

			while (line != null) {
				String[] temperatures = line.split(";");
				System.out.println(line);
				if (!temperatures[2].equals("N/A")) {
					Integer currentTemperature = Integer.parseInt(temperatures[0]);
					Integer deltaTemperature = Math
							.abs(Integer.parseInt(temperatures[0]) - Integer.parseInt(temperatures[2]));
					Integer updatedTemperature = Integer.parseInt(temperatures[3]);

					if (EnviroWearModule.LEFT_ARM_MAX_TEMEPERATURE_THRESHOLD < currentTemperature) {
						Integer expectedResult = currentTemperature - deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}

					if (EnviroWearModule.LEFT_ARM_MIN_TEMEPERATURE_THRESHOLD > currentTemperature) {
						Integer expectedResult = currentTemperature + deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRightArmModule() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("RightArm.log"));
			String line = reader.readLine();
			System.out.println(line);
			while (line != null) {
				String[] temperatures = line.split(";");

				if (!temperatures[2].equals("N/A")) {
					Integer currentTemperature = Integer.parseInt(temperatures[0]);
					Integer deltaTemperature = Math
							.abs(Integer.parseInt(temperatures[0]) - Integer.parseInt(temperatures[2]));
					Integer updatedTemperature = Integer.parseInt(temperatures[3]);

					if (EnviroWearModule.RIGHT_ARM_MAX_TEMEPERATURE_THRESHOLD < currentTemperature) {
						Integer expectedResult = currentTemperature - deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}

					if (EnviroWearModule.RIGHT_ARM_MIN_TEMEPERATURE_THRESHOLD > currentTemperature) {
						Integer expectedResult = currentTemperature + deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testLeftLegModule() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("LeftLeg.log"));
			String line = reader.readLine();
			System.out.println(line);
			while (line != null) {
				String[] temperatures = line.split(";");

				if (!temperatures[2].equals("N/A")) {
					Integer currentTemperature = Integer.parseInt(temperatures[0]);
					Integer deltaTemperature = Math
							.abs(Integer.parseInt(temperatures[0]) - Integer.parseInt(temperatures[2]));
					Integer updatedTemperature = Integer.parseInt(temperatures[3]);

					if (EnviroWearModule.LEFT_LEG_MAX_TEMEPERATURE_THRESHOLD < currentTemperature) {
						Integer expectedResult = currentTemperature - deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}

					if (EnviroWearModule.LEFT_LEG_MIN_TEMEPERATURE_THRESHOLD > currentTemperature) {
						Integer expectedResult = currentTemperature + deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRightLegModule() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("RightLeg.log"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				String[] temperatures = line.split(";");

				if (!temperatures[2].equals("N/A")) {
					Integer currentTemperature = Integer.parseInt(temperatures[0]);
					Integer deltaTemperature = Math
							.abs(Integer.parseInt(temperatures[0]) - Integer.parseInt(temperatures[2]));
					Integer updatedTemperature = Integer.parseInt(temperatures[3]);

					if (EnviroWearModule.RIGHT_LEG_MAX_TEMEPERATURE_THRESHOLD < currentTemperature) {
						Integer expectedResult = currentTemperature - deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}

					if (EnviroWearModule.RIGHT_LEG_MIN_TEMEPERATURE_THRESHOLD > currentTemperature) {
						Integer expectedResult = currentTemperature + deltaTemperature;

						assertEquals(expectedResult, updatedTemperature);
					}
				}

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
