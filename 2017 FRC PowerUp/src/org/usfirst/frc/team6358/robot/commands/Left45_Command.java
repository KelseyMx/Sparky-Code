package org.usfirst.frc.team6358.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import org.usfirst.frc.team6358.robot.Robot;

/**
 *
 */
public class Left45_Command extends Command {
	
	ADXRS450_Gyro gyro;
	
	public Left45_Command() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.DriveTrain);

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.DriveTrain.L90TurnDrive();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.DriveTrain.L90TurnDrive();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return ( gyro.getAngle() > 45);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
