// You will need to set up an external software like 'Better DS3 Tool' or 'MotionJoy'.
	// This essentially tricks the computer into thinking the PS3 Controller is an xBox Controller, converting it's inputs.

package org.usfirst.frc.team5599.robot;

import edu.wpi.first.wpilibj.Joystick;

public class PS3Controller {

	public Joystick controller;
	public int port;

	public PS3Controller(int port) {
		this.port = port;
		this.controller = new Joystick(port);
		// When the Controller is initialized, it will automatically set the controller object and port value
	}

	// Configuration


	double DEAD_ZONE = 0.08;
		// This is a sensitivity buffer for the joysticks. (Recommended 0.05 or higher)
		// Prevents the robot from going nuts at the slightest movement.
	double TRIGGER_BUFFER = 0.2;
		// This is a sensitivity buffer for the triggers. When the pressure on a trigger is greater than this value, the trigger is considered 'pressed'.
		// Recommended 0.2
		// Prevents wild outbursts from minor amounts of pressure.

	/*

	INDEX

	Joysticks 		- Getting X&Y Axis values for the Left and Right Joystick and their Pressed status
	XCST		 	- Getting the Pressed status for the X, Circle, Square, and Triangle buttons
	DPad 			- Getting the Pressed status for the DPad Up/Down/Left/Right Buttons
	Bumpers 		- Getting the Pressed status for the Left & Right Bumpers
	Triggers 		- Getting the Pressed status or pressure placed on the Left & Right Triggers
	Start/Select	- Getting the Pressed status for the Start & Select Buttons

	RumbleMotors 	- Operating the Left & Right Rumble motors


	// Usage Example
	//
	// PS3 gamepad;
	// gamepad = new PS3Controller(int port);
	// 
	// if (gamepad.getXButton() == true) {
	//     gamepad.setRumble("Both",1.0);
	// else
	//     gamepad.setRumble("Both",0.0);
	// }
	//

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

	public int getPOV(int povNumber) {
		return controller.getPOV(povNumber);
	}

	// Thumbsticks

		// Left Thumbstick

	public double getLeftThumbstickX() {
		return correctDeadSpot(getAxis(0));
	}

	public double getLeftThumbstickY() {
		return correctDeadSpot(getAxis(1));
	}

	public boolean getLeftThumbstickButton() {
		return getButton(9);
	}

		// Right Thumbstick

	public double getRightThumbstickX() {
		return correctDeadSpot(getAxis(4));
	}

	public double getRightThumbstickY() {
		return correctDeadSpot(getAxis(5));
	}

	public boolean getRightThumbstickButton() {
		return getButton(10);
	}

	// ABXY Buttons

	public boolean getXButton() {
		return getButton(1);
	}

	public boolean getCircleButton() {
		return getButton(2);
	}

	public boolean getSquareButton() {
		return getButton(3);
	}

	public boolean getTriangleButton() {
		return getButton(4);
	}


	// DPad
	// The DPad is unique in that it works with a 0-360 degrees POV

	public boolean getDPadUp(){
		int degree = getPOV(0);
		return (degree >= 315 || degree <= 45);
	}

	public boolean getDPadDown(){
		int degree = getPOV(0);
		return (degree <= 225 && degree >= 135);
	}

	public boolean getDPadLeft(){
		int degree = getPOV(0);
		return (degree <= 315 && degree >= 225);
	}

	public boolean getDPadRight(){
		int degree = getPOV(0);
		return (degree <= 135 && degree >= 45);
	}

	// Bumpers

	public boolean getLeftBumper(){
		return getButton(5);
	}

	public boolean getRightBumper(){
		return getButton(6);
	}

	// Triggers

		// Returns the amount of pressure placed on the triggers

	public double getLeftTriggerAbsolute(){
		return Math.abs(getAxis(2));
	}

	public double getRightTriggerAbsolute(){
		return Math.abs(getAxis(3));
	}

		// Returns simple bool values to check if the trigger is considered down or not
	public boolean getLeftTrigger(){
		return (getLeftTriggerAbsolute() >= TRIGGER_BUFFER);
	}

	public boolean getRightTrigger(){
		return (getRightTriggerAbsolute() >= TRIGGER_BUFFER);
	}

	// Start & Back

	public boolean getSelectButton(){
		return getButton(7);
	}

	public boolean getStartButton(){
		return getButton(8);
	}


	// Rumble Function

	public boolean setRumble(String type, float value) {
        if ((type == "Both") || (type == "Left")) {
            controller.setRumble(Joystick.RumbleType.kLeftRumble, value);
        }
        if ((type == "Both") || (type == "Right")) {
        	controller.setRumble(Joystick.RumbleType.kRightRumble, value);
        }
        return true;
    }

}

// Michael Rooplall
// 3/14/2016
// Redid controls. No more using copy&paste stuff, we can at least make our own controller code :)
