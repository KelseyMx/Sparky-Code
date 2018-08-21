package org.usfirst.frc.team6358.robot.commands;

import org.usfirst.frc.team6358.robot.Robot;
import org.usfirst.frc.team6358.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class SwingUp_Commands extends Command{
	
	//DigitalInput UpperSwitch = new DigitalInput(RobotMap.LiftLimit_T);
	
	
	public SwingUp_Commands() {
		requires(Robot.Arm);
	}
	
	@Override
	protected void initialize() {	
	}
	
	@Override
	protected void execute() {	
		//while(Robot.oi.getCoPilotJoystick().getRawButton(4)==true) {
			Robot.Arm.SwingUp(); //only executes while joystick pressed AND Limit Switch is open (false)
		//}
	//	Robot.Arm.Stop();

	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// Make this statement return as true when our command no longer needs to run execute()
		// If LiftLimit_T is pressed (measures as TRUE), don't execute Lift_Command
		//return UpperSwitch.get()==true ; //No idea why this doesn't work
		return false;
	}

	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted() {
		Robot.Arm.Stop();
	}
}
