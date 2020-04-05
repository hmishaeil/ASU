package com.asu.envirowear.panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.asu.envirowear.common.EnviroWearModule;

public class Display {

	private JFrame frame = null;
	private JPanel panel;

	private JButton headerModuleButton = new JButton("Module/ Temperature Threshold [MIN, MAX]");

	private JButton leftArmModuleButton = new JButton(EnviroWearModule.LEFT_ARM);
	private JButton rightArmModuleButton = new JButton(EnviroWearModule.RIGHT_ARM);
	private JButton chestModuleButton = new JButton(EnviroWearModule.CHEST);
	private JButton leftLegModuleButton = new JButton(EnviroWearModule.LEFT_LEG);
	private JButton rightLegModuleButton = new JButton(EnviroWearModule.RIGHT_LEG);

	private JButton headerCurrentTemperatureButton = new JButton("Current Temperature (\u2109)");

	private JButton leftArmCurrentTemperatureButton = new JButton();
	private JButton rightArmCurrentTemperatureButton = new JButton();
	private JButton chestCurrentTemperatureButton = new JButton();
	private JButton leftLegCurrentTemperatureButton = new JButton();
	private JButton rightLegCurrentTemperatureButton = new JButton();

	private JButton headerActionTakenButton = new JButton("Action Taken");

	private JButton leftArmActionTakenButton = new JButton();
	private JButton rightArmActionTakenButton = new JButton();
	private JButton chestActionTakenButton = new JButton();
	private JButton leftLegActionTakenButton = new JButton();
	private JButton rightLegActionTakenButton = new JButton();

	private JButton headerProgressStatusButton = new JButton("Process Status");

	private JButton leftArmProgressStatusButton = new JButton();
	private JButton rightArmProgressStatusButton = new JButton();
	private JButton chestProgressStatusButton = new JButton();
	private JButton leftLegProgressStatusButton = new JButton();
	private JButton rightLegProgressStatusButton = new JButton();

	private JButton headerUpdatedTemperatureButton = new JButton("Updated Temperature (\u2109)");

	private JButton leftArmUpdatedTemperatureButton = new JButton();
	private JButton rightArmUpdatedTemperatureButton = new JButton();
	private JButton chestUpdatedTemperatureButton = new JButton();
	private JButton leftLegUpdatedTemperatureButton = new JButton();
	private JButton rightLegUpdatedTemperatureButton = new JButton();

	private Map<String, JButton> moduleButtonsMap = new HashMap<String, JButton>();
	private Map<String, JButton> currentTemperatureButtonsMap = new HashMap<String, JButton>();
	private Map<String, JButton> takenActionButtonsMap = new HashMap<String, JButton>();
	private Map<String, JButton> progressStatusButtonsMap = new HashMap<String, JButton>();
	private Map<String, JButton> updatedTemperatureButtonsMap = new HashMap<String, JButton>();

	public Display() {
		initFrame();
		initPanel();
		initMap();
		styleInfoButton();
		draw();
	}

	public void styleInfoButton() {

		headerModuleButton.setFont(new Font("Arial", Font.BOLD, 14));
		headerModuleButton.setFocusPainted(false);
		headerCurrentTemperatureButton.setFont(new Font("Arial", Font.BOLD, 14));
		headerCurrentTemperatureButton.setFocusPainted(false);
		headerActionTakenButton.setFont(new Font("Arial", Font.BOLD, 14));
		headerActionTakenButton.setFocusPainted(false);
		headerProgressStatusButton.setFont(new Font("Arial", Font.BOLD, 14));
		headerProgressStatusButton.setFocusPainted(false);
		headerUpdatedTemperatureButton.setFont(new Font("Arial", Font.BOLD, 14));
		headerUpdatedTemperatureButton.setFocusPainted(false);

	}

	public void initFrame() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("EnviroWear");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 5));
		panel.setPreferredSize(new Dimension(1600, 300));
	}

	public void initMap() {
		moduleButtonsMap.put(EnviroWearModule.LEFT_ARM, leftArmModuleButton);
		moduleButtonsMap.put(EnviroWearModule.RIGHT_ARM, rightArmModuleButton);
		moduleButtonsMap.put(EnviroWearModule.LEFT_LEG, leftLegModuleButton);
		moduleButtonsMap.put(EnviroWearModule.RIGHT_LEG, rightLegModuleButton);
		moduleButtonsMap.put(EnviroWearModule.CHEST, chestModuleButton);

		for (JButton jbutton : moduleButtonsMap.values()) {
			jbutton.setFont(new Font("Arial", Font.BOLD, 14));

			jbutton.setFocusPainted(false);

		}

		currentTemperatureButtonsMap.put(EnviroWearModule.LEFT_ARM, leftArmCurrentTemperatureButton);
		currentTemperatureButtonsMap.put(EnviroWearModule.RIGHT_ARM, rightArmCurrentTemperatureButton);
		currentTemperatureButtonsMap.put(EnviroWearModule.LEFT_LEG, leftLegCurrentTemperatureButton);
		currentTemperatureButtonsMap.put(EnviroWearModule.RIGHT_LEG, rightLegCurrentTemperatureButton);
		currentTemperatureButtonsMap.put(EnviroWearModule.CHEST, chestCurrentTemperatureButton);

		for (JButton jbutton : currentTemperatureButtonsMap.values()) {
			jbutton.setFocusPainted(false);

		}

		takenActionButtonsMap.put(EnviroWearModule.LEFT_ARM, leftArmActionTakenButton);
		takenActionButtonsMap.put(EnviroWearModule.RIGHT_ARM, rightArmActionTakenButton);
		takenActionButtonsMap.put(EnviroWearModule.LEFT_LEG, leftLegActionTakenButton);
		takenActionButtonsMap.put(EnviroWearModule.RIGHT_LEG, rightLegActionTakenButton);
		takenActionButtonsMap.put(EnviroWearModule.CHEST, chestActionTakenButton);

		for (JButton jbutton : takenActionButtonsMap.values()) {
			jbutton.setFocusPainted(false);

		}

		progressStatusButtonsMap.put(EnviroWearModule.LEFT_ARM, leftArmProgressStatusButton);
		progressStatusButtonsMap.put(EnviroWearModule.RIGHT_ARM, rightArmProgressStatusButton);
		progressStatusButtonsMap.put(EnviroWearModule.LEFT_LEG, leftLegProgressStatusButton);
		progressStatusButtonsMap.put(EnviroWearModule.RIGHT_LEG, rightLegProgressStatusButton);
		progressStatusButtonsMap.put(EnviroWearModule.CHEST, chestProgressStatusButton);

		for (JButton jbutton : progressStatusButtonsMap.values()) {
			jbutton.setFocusPainted(false);

		}

		updatedTemperatureButtonsMap.put(EnviroWearModule.LEFT_ARM, leftArmUpdatedTemperatureButton);
		updatedTemperatureButtonsMap.put(EnviroWearModule.RIGHT_ARM, rightArmUpdatedTemperatureButton);
		updatedTemperatureButtonsMap.put(EnviroWearModule.LEFT_LEG, leftLegUpdatedTemperatureButton);
		updatedTemperatureButtonsMap.put(EnviroWearModule.RIGHT_LEG, rightLegUpdatedTemperatureButton);
		updatedTemperatureButtonsMap.put(EnviroWearModule.CHEST, chestUpdatedTemperatureButton);

		for (JButton jbutton : updatedTemperatureButtonsMap.values()) {
			jbutton.setFocusPainted(false);

		}

	}

	public void draw() {

		panel.add(headerModuleButton);
		panel.add(headerCurrentTemperatureButton);
		panel.add(headerActionTakenButton);
		panel.add(headerProgressStatusButton);
		panel.add(headerUpdatedTemperatureButton);

		panel.add(leftArmModuleButton);
		panel.add(leftArmCurrentTemperatureButton);
		panel.add(leftArmActionTakenButton);
		panel.add(leftArmProgressStatusButton);
		panel.add(leftArmUpdatedTemperatureButton);

		panel.add(rightArmModuleButton);
		panel.add(rightArmCurrentTemperatureButton);
		panel.add(rightArmActionTakenButton);
		panel.add(rightArmProgressStatusButton);
		panel.add(rightArmUpdatedTemperatureButton);

		panel.add(chestModuleButton);
		panel.add(chestCurrentTemperatureButton);
		panel.add(chestActionTakenButton);
		panel.add(chestProgressStatusButton);
		panel.add(chestUpdatedTemperatureButton);

		panel.add(leftLegModuleButton);
		panel.add(leftLegCurrentTemperatureButton);
		panel.add(leftLegActionTakenButton);
		panel.add(leftLegProgressStatusButton);
		panel.add(leftLegUpdatedTemperatureButton);

		panel.add(rightLegModuleButton);
		panel.add(rightLegCurrentTemperatureButton);
		panel.add(rightLegActionTakenButton);
		panel.add(rightLegProgressStatusButton);
		panel.add(rightLegUpdatedTemperatureButton);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}

	public Map<String, JButton> getMapInfo() {
		return this.moduleButtonsMap;
	}

	public Map<String, JButton> getMapCtrl() {
		return this.takenActionButtonsMap;
	}

	public Map<String, JButton> getMapProgress() {
		return this.progressStatusButtonsMap;
	}

	public Map<String, JButton> getMapNew() {
		return this.updatedTemperatureButtonsMap;
	}

	public Map<String, JButton> getMapReader() {
		return this.currentTemperatureButtonsMap;
	}

}
