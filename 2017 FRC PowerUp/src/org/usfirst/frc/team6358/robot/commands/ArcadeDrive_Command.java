package org.usfirst.frc.team6358.robot.commands;

import org.usfirst.frc.team6358.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive_Command extends Command{

	public ArcadeDrive_Command() {
		requires(Robot.DriveTrain);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.DriveTrain.TeleopDrive(Robot.oi.getDriverJoystick());
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
	}

}
