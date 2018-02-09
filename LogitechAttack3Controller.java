package org.usfirst.frc.team5599.robot;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickController {
	
	public Joystick controller;
	public int port;
	
	public JoystickController(int port) {
		this.port = port;
		this.controller = new Joystick(port);
		// When the Controller is initialized, it will automatically set the controller object and port value
	}

	// Configuration

	double DEAD_ZONE = 0.08;
		// This is a sensitivity buffer for the joysticks. (Recommended 0.05 or higher)
		// Prevents the robot from going nuts at the slightest movement.
	
	/*

	INDEX

	Joystick Axiis - Get the X,Y,Z values for the Joystick
	Numeral 1-11 Buttons - Get the Pressed status for the numbered buttons (1-11)

	// Usage Example
	//
	// JoystickController gamepad;
	// gamepad = new JoystickController(int port);
	// 
	// if (getButtonOne() == true) {
	//    // Do something
	// }

	*/

	public double correctDeadSpot(double value) {
		if (Math.abs(value) < DEAD_ZONE) {
			return 0;
		}
		return value;
	}

	public boolean getButton(int buttonNumber) {
		return controller.getRawButton(buttonNumber);
	}

	public double getAxis(int axisNumber) {
		return controller.getRawAxis(axisNumber);
	}

	// Joystick
	
	public double getJoystickX() {
		return correctDeadSpot(getAxis(0));
	}
	
	public double getJoystickY() {
		return correctDeadSpot(getAxis(1));
	}
	
	public double getJoystickZ() {
		return correctDeadSpot(getAxis(2));
	}


	// Numeral Buttons

	public boolean getButtonOne() {
		return getButton(1);
	}

	public boolean getButtonTwo() {
		return getButton(2);
	}

	public boolean getButtonThree() {
		return getButton(3);
	}

	public boolean getButtonFour() {
		return getButton(4);
	}

	public boolean getButtonFive() {
		return getButton(5);
	}

	public boolean getButtonSix() {
		return getButton(6);
	}

	public boolean getButtonSeven() {
		return getButton(7);
	}

	public boolean getButtonEight() {
		return getButton(8);
	}

	public boolean getButtonNine() {
		return getButton(9);
	}

	public boolean getButtonTen() {
		return getButton(10);
	}

	public boolean getButtonEleven() {
		return getButton(11);
	}

	
}

// Michael Rooplall
// 5/16/2016
// Joystick code for the Logitech Attack 3
