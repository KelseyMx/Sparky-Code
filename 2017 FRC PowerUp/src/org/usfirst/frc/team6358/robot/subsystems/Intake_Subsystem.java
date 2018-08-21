package org.usfirst.frc.team6358.robot.subsystems;

import org.usfirst.frc.team6358.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake_Subsystem extends Subsystem {

	private VictorSP wheels = new VictorSP(RobotMap.Intake);

	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void Grab() {
		wheels.set(-1.0);
	}
	
	public void MediumGrab() {
		wheels.set(-.5);
	}
	
	public void Out() {
		wheels.set(1.0);// Enough force for the switch
	}
	public void AutoOut() {
		wheels.set(0.20);//Enough force for the scale
	}

	public void Stop() {
		wheels.set(0);
	}
	public void Idle() {
		wheels.set(-0.35);
	}
}