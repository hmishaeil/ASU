package com.asu.envirowear.panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {

	private JFrame frame = null;
	private JPanel panel;

	private JButton headerButtonInfo = new JButton("Module/ Temperature Threshold [MIN, MAX]");

	private JButton leftArmButtonInfo = new JButton("Left Arm");
	private JButton rightArmButtonInfo = new JButton("Right Arm");
	private JButton chestButtonInfo = new JButton("Chest");
	private JButton leftlegButtonInfo = new JButton("Left Leg");
	private JButton rightlegButtonInfo = new JButton("Right Leg");

	private JButton infoButton = new JButton("Current Temperature (\u2109)");

	private JButton leftArmButtonReader = new JButton("left arm");
	private JButton rightArmButtonReader = new JButton("right arm");
	private JButton chestButtonReader = new JButton("chest");
	private JButton leftlegButtonReader = new JButton("left leg");
	private JButton rightlegButtonReader = new JButton("right leg");

	private JButton infoButtonCtrl = new JButton("Action Taken");

	private JButton leftArmButtonCtrl = new JButton("left arm");
	private JButton rightArmButtonCtrl = new JButton("right arm");
	private JButton chestButtonCtrl = new JButton("chest");
	private JButton leftlegButtonCtrl = new JButton("left leg");
	private JButton rightlegButtonCtrl = new JButton("right leg");

	private JButton infoButtonProgress = new JButton("Process Status");

	private JButton leftArmButtonProgress = new JButton("left arm");
	private JButton rightArmButtonProgress = new JButton("right arm");
	private JButton chestButtonProgress = new JButton("chest");
	private JButton leftlegButtonProgress = new JButton("left leg");
	private JButton rightlegButtonProgress = new JButton("right leg");

	private JButton infoButtonNew = new JButton("Updated Temperature (\u2109)");

	private JButton leftArmButtonNew = new JButton("left arm");
	private JButton rightArmButtonNew = new JButton("right arm");
	private JButton chestButtonNew = new JButton("chest");
	private JButton leftLegButtonNew = new JButton("left leg");
	private JButton rightLegButtonNew = new JButton("right leg");

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
		mapInfo.put("left_arm", leftArmButtonInfo);
		mapInfo.put("right_arm", rightArmButtonInfo);
		mapInfo.put("left_leg", leftlegButtonInfo);
		mapInfo.put("right_leg", rightlegButtonInfo);
		mapInfo.put("chest", chestButtonInfo);

		for (JButton jbutton : mapInfo.values()) {
			jbutton.setFont(new Font("Arial", Font.BOLD, 14));
		}

		mapReader.put("left_arm", leftArmButtonReader);
		mapReader.put("right_arm", rightArmButtonReader);
		mapReader.put("left_leg", leftlegButtonReader);
		mapReader.put("right_leg", rightlegButtonReader);
		mapReader.put("chest", chestButtonReader);

		mapCtrl.put("left_arm", leftArmButtonCtrl);
		mapCtrl.put("right_arm", rightArmButtonCtrl);
		mapCtrl.put("left_leg", leftlegButtonCtrl);
		mapCtrl.put("right_leg", rightlegButtonCtrl);
		mapCtrl.put("chest", chestButtonCtrl);

		mapProgress.put("left_arm", leftArmButtonProgress);
		mapProgress.put("right_arm", rightArmButtonProgress);
		mapProgress.put("left_leg", leftlegButtonProgress);
		mapProgress.put("right_leg", rightlegButtonProgress);
		mapProgress.put("chest", chestButtonProgress);

		mapNew.put("left_arm", leftArmButtonNew);
		mapNew.put("right_arm", rightArmButtonNew);
		mapNew.put("left_leg", leftLegButtonNew);
		mapNew.put("right_leg", rightLegButtonNew);
		mapNew.put("chest", chestButtonNew);
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
