package org.usfirst.frc.team6358.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6358.robot.commands.Grab_Commands;
import org.usfirst.frc.team6358.robot.commands.Idle_Commands;
import org.usfirst.frc.team6358.robot.commands.Lift_Commands;
import org.usfirst.frc.team6358.robot.commands.Lower_Commands;
import org.usfirst.frc.team6358.robot.commands.Out_Commands;
import org.usfirst.frc.team6358.robot.commands.SwingDown_Commands;
import org.usfirst.frc.team6358.robot.commands.SwingUp_Commands;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick Driver = new Joystick(0);
	Joystick CoPilot = new Joystick(1);

	JoystickButton Igrab = new JoystickButton(Driver, 2);
	JoystickButton Iout = new JoystickButton(Driver, 1);
	
	//JoystickButton Idle = new JoystickButton(Driver, 3);
	JoystickButton ArmUp = new JoystickButton(CoPilot, 4);
	JoystickButton ArmDown = new JoystickButton(CoPilot, 5);		
	JoystickButton ELower = new JoystickButton(CoPilot, 2);
	JoystickButton ERaise = new JoystickButton(CoPilot, 3);
	JoystickButton Cuddle = new JoystickButton(CoPilot, 1);

	
	
	
	//SmartDashboard Tests
	
	
	public OI() {

		
		ERaise.whileHeld(new Lift_Commands());
		ELower.whileHeld(new Lower_Commands());
		Igrab.whileHeld(new Grab_Commands());
		Iout.whileHeld(new Out_Commands());
		ArmUp.whileHeld(new SwingUp_Commands());
		ArmDown.whileHeld(new SwingDown_Commands());
		Cuddle.whileHeld(new Idle_Commands());

		//IIdle.whileHeld(new)
		//Idle.whenPressed(new SwingUp_Commands());
		
	}
	
	public Joystick getDriverJoystick() {
		return Driver;
	}
	
	public Joystick getCoPilotJoystick() {
		return CoPilot;
	}
}
