package org.usfirst.frc.team6358.robot.commands;

import org.usfirst.frc.team6358.robot.Robot;
import org.usfirst.frc.team6358.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class SwingDown_Commands extends Command{
		
	public SwingDown_Commands() {
		requires(Robot.Arm);
	}
	
	@Override
	protected void initialize() {	
	}
	
	@Override
	protected void execute() {	
		//while(Robot.oi.getCoPilotJoystick().getRawButton(5)==true) {
			Robot.Arm.SwingDown(); //only executes while joystick pressed AND Limit Switch is open (false)
		//}
		//Robot.Arm.Stop();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
