package org.usfirst.frc.team6358.robot.commands;

import org.usfirst.frc.team6358.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Grab_Commands extends Command{
	
	public Grab_Commands() {
		requires(Robot.Intake);
	}
	
	@Override
	protected void initialize() {	
	}
	
	@Override
	protected void execute() {	
		//while(Robot.oi.getDriverJoystick().getRawButton(2)==true) {
			Robot.Intake.Grab();
		//}
	//	Robot.Intake.Stop();
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
		Robot.Intake.Stop();
	}
}
