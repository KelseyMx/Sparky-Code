package org.usfirst.frc.team6358.robot.commands;

import org.usfirst.frc.team6358.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IdleArm_Command extends Command{
	
	public IdleArm_Command() {
		requires(Robot.Intake);
	}
	
	@Override
	protected void initialize() {	
	}
	
	@Override
	protected void execute() {	
		//while(Robot.oi.getDriverJoystick().getRawButton(2)==true) {
			Robot.Arm.IdleDown();
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
		Robot.Arm.Stop();
	}
}
