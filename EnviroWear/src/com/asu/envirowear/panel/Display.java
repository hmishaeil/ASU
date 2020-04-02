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

	private JButton headerButtonInfo = new JButton("Module/ Temperature Threshold [MIN, MAX]");

	private JButton leftArmButtonInfo = new JButton(EnviroWearModule.LEFT_ARM);
	private JButton rightArmButtonInfo = new JButton(EnviroWearModule.RIGHT_ARM);
	private JButton chestButtonInfo = new JButton(EnviroWearModule.CHEST);
	private JButton leftlegButtonInfo = new JButton(EnviroWearModule.LEFT_LEG);
	private JButton rightlegButtonInfo = new JButton(EnviroWearModule.RIGHT_LEG);

	private JButton infoButton = new JButton("Current Temperature (\u2109)");

	private JButton leftArmButtonReader = new JButton();
	private JButton rightArmButtonReader = new JButton();
	private JButton chestButtonReader = new JButton();
	private JButton leftlegButtonReader = new JButton();
	private JButton rightlegButtonReader = new JButton();

	private JButton infoButtonCtrl = new JButton("Action Taken");

	private JButton leftArmButtonCtrl = new JButton();
	private JButton rightArmButtonCtrl = new JButton();
	private JButton chestButtonCtrl = new JButton();
	private JButton leftlegButtonCtrl = new JButton();
	private JButton rightlegButtonCtrl = new JButton();

	private JButton infoButtonProgress = new JButton("Process Status");

	private JButton leftArmButtonProgress = new JButton();
	private JButton rightArmButtonProgress = new JButton();
	private JButton chestButtonProgress = new JButton();
	private JButton leftlegButtonProgress = new JButton();
	private JButton rightlegButtonProgress = new JButton();

	private JButton infoButtonNew = new JButton("Updated Temperature (\u2109)");

	private JButton leftArmButtonNew = new JButton();
	private JButton rightArmButtonNew = new JButton();
	private JButton chestButtonNew = new JButton();
	private JButton leftLegButtonNew = new JButton();
	private JButton rightLegButtonNew = new JButton();

	private Map<String, JButton> mapInfo = new HashMap<String, JButton>();
	private Map<String, JButton> mapReader = new HashMap<String, JButton>();
	private Map<String, JButton> mapCtrl = new HashMap<String, JButton>();
	private Map<String, JButton> mapProgress = new HashMap<String, JButton>();
	private Map<String, JButton> mapNew = new HashMap<String, JButton>();

	public Display() {
		initFrame();
		initPanel();
		initMap();
		styleInfoButton();
		draw();
	}

	public void styleInfoButton() {
		headerButtonInfo.setFont(new Font("Arial", Font.BOLD, 14));
		infoButton.setFont(new Font("Arial", Font.BOLD, 14));
		infoButtonCtrl.setFont(new Font("Arial", Font.BOLD, 14));
		infoButtonProgress.setFont(new Font("Arial", Font.BOLD, 14));
		infoButtonNew.setFont(new Font("Arial", Font.BOLD, 14));
	}

	public void initFrame() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("EnviroWear");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 5));
		panel.setPreferredSize(new Dimension(1600, 350));
	}

	public void initMap() {
		mapInfo.put(EnviroWearModule.LEFT_ARM, leftArmButtonInfo);
		mapInfo.put(EnviroWearModule.RIGHT_ARM, rightArmButtonInfo);
		mapInfo.put(EnviroWearModule.LEFT_LEG, leftlegButtonInfo);
		mapInfo.put(EnviroWearModule.RIGHT_LEG, rightlegButtonInfo);
		mapInfo.put(EnviroWearModule.CHEST, chestButtonInfo);

		for (JButton jbutton : mapInfo.values()) {
			jbutton.setFont(new Font("Arial", Font.BOLD, 14));
		}

		mapReader.put(EnviroWearModule.LEFT_ARM, leftArmButtonReader);
		mapReader.put(EnviroWearModule.RIGHT_ARM, rightArmButtonReader);
		mapReader.put(EnviroWearModule.LEFT_LEG, leftlegButtonReader);
		mapReader.put(EnviroWearModule.RIGHT_LEG, rightlegButtonReader);
		mapReader.put(EnviroWearModule.CHEST, chestButtonReader);

		mapCtrl.put(EnviroWearModule.LEFT_ARM, leftArmButtonCtrl);
		mapCtrl.put(EnviroWearModule.RIGHT_ARM, rightArmButtonCtrl);
		mapCtrl.put(EnviroWearModule.LEFT_LEG, leftlegButtonCtrl);
		mapCtrl.put(EnviroWearModule.RIGHT_LEG, rightlegButtonCtrl);
		mapCtrl.put(EnviroWearModule.CHEST, chestButtonCtrl);

		mapProgress.put(EnviroWearModule.LEFT_ARM, leftArmButtonProgress);
		mapProgress.put(EnviroWearModule.RIGHT_ARM, rightArmButtonProgress);
		mapProgress.put(EnviroWearModule.LEFT_LEG, leftlegButtonProgress);
		mapProgress.put(EnviroWearModule.RIGHT_LEG, rightlegButtonProgress);
		mapProgress.put(EnviroWearModule.CHEST, chestButtonProgress);

		mapNew.put(EnviroWearModule.LEFT_ARM, leftArmButtonNew);
		mapNew.put(EnviroWearModule.RIGHT_ARM, rightArmButtonNew);
		mapNew.put(EnviroWearModule.LEFT_LEG, leftLegButtonNew);
		mapNew.put(EnviroWearModule.RIGHT_LEG, rightLegButtonNew);
		mapNew.put(EnviroWearModule.CHEST, chestButtonNew);
	}

	public void draw() {

		panel.add(headerButtonInfo);
		panel.add(infoButton);
		panel.add(infoButtonCtrl);
		panel.add(infoButtonProgress);
		panel.add(infoButtonNew);

		panel.add(leftArmButtonInfo);
		panel.add(leftArmButtonReader);
		panel.add(leftArmButtonCtrl);
		panel.add(leftArmButtonProgress);
		panel.add(leftArmButtonNew);

		panel.add(rightArmButtonInfo);
		panel.add(rightArmButtonReader);
		panel.add(rightArmButtonCtrl);
		panel.add(rightArmButtonProgress);
		panel.add(rightArmButtonNew);

		panel.add(chestButtonInfo);
		panel.add(chestButtonReader);
		panel.add(chestButtonCtrl);
		panel.add(chestButtonProgress);
		panel.add(chestButtonNew);

		panel.add(leftlegButtonInfo);
		panel.add(leftlegButtonReader);
		panel.add(leftlegButtonCtrl);
		panel.add(leftlegButtonProgress);
		panel.add(leftLegButtonNew);

		panel.add(rightlegButtonInfo);
		panel.add(rightlegButtonReader);
		panel.add(rightlegButtonCtrl);
		panel.add(rightlegButtonProgress);
		panel.add(rightLegButtonNew);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}

	public Map<String, JButton> getMapInfo() {
		return mapInfo;
	}

	public Map<String, JButton> getMapCtrl() {
		return mapCtrl;
	}

	public Map<String, JButton> getMapProgress() {
		return mapProgress;
	}

	public Map<String, JButton> getMapNew() {
		return mapNew;
	}

	public Map<String, JButton> getMapReader() {
		return mapReader;
	}

}
