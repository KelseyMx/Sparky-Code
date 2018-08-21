package org.usfirst.frc.team6358.robot.subsystems;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;

import org.usfirst.frc.team6358.robot.RobotMap;
import org.usfirst.frc.team6358.robot.commands.ArcadeDrive_Command;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
@SuppressWarnings("deprecation")

	
public class DriveTrain_Subsystem extends Subsystem 
{
	public RobotDrive MainDrive = new RobotDrive(RobotMap.Drive_Left, RobotMap.Drive_Right);
	ADXRS450_Gyro gyro;
	double Kp = 0.1;
	Timer timer;
	//Ultrasonic FrontU;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ArcadeDrive_Command());
		gyro = new ADXRS450_Gyro();
		//Ultrasonic FrontU = new Ultrasonic(RobotMap.FUltrasonic,RobotMap.FUltrasonic);
		//FrontU.setAutomaticMode(true);
	}

	public void FrontUltraMeasure() {
		//double range = FrontU.getRangeInches();
		//while (FrontU.getRangeInches() <= 36);
			//MainDrive.drive(-.5, 0);
	}
	public void TimerReset() {
		timer.reset();
	}
	public void GyroCalibrate() {
		gyro.calibrate();
	}
	
	public void GyroReset() {
		gyro.reset();
	} 
	public void TeleopDrive(Joystick Driver) {
		MainDrive.arcadeDrive(Driver);
	}
	
	public void BackwardDrive() {
		MainDrive.drive(-0.5, 0.004);
	}
	
	/*public void ForwardDrive() { // Drives straight with gyro guidance 
		if (initial) { 
			gyro.reset();
			MainDrive.drive(0.5, 0);
		} else {
			MainDrive.drive(0.5, gyro.getAngle() * Kp * -1.0);		}
	}
	/*
	 * 
	 */
	public void RightTurn() {
		 MainDrive.drive(.75,1);
	}
	public void R90TurnDrive() { // Turns right 90* from gyro reset
		 double angle = gyro.getAngle();
		 if (angle < 90) {
			 MainDrive.drive(0.4, 1);
		 } else if(angle > 90) {
			 MainDrive.drive(0, 0);
		 }
	}
	
	public void R45TurnDrive(boolean initial) { // Turns right 45* from gyro reset
		if (initial) {
			gyro.reset();
		}
		 double angle = gyro.getAngle();
		 if (angle < 45) {
			 MainDrive.drive(0.3, 1);
		 } else if(angle > 45) {
			 MainDrive.drive(0, 0);
		 }
	}
	
	public void L90TurnDrive() { // Turns left 90* from gyro reset
		gyro.reset();
		double angle = gyro.getAngle();
		if (angle > -90) {
			 MainDrive.drive(0.4, -1);
	}else if (angle < -90) {
		MainDrive.drive(0,0);
	}
	}
	
	public void L45TurnDrive(boolean initial) { // Turns left 45* from gyro reset
		if (initial) {
		gyro.reset();
		}
		double angle = gyro.getAngle();
		 if (angle > -45) {
			 MainDrive.drive(0.4, -1);
		 } else if (angle < -45) {
			 MainDrive.drive(0, 0);
		 	} else {
		 		MainDrive.drive(0.4,-1);
		 	}
	}
	
	public void Stop() {
		MainDrive.drive(0,0);
		}
}
