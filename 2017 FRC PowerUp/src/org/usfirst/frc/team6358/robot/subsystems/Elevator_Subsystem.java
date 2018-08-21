package org.usfirst.frc.team6358.robot.subsystems;

import org.usfirst.frc.team6358.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator_Subsystem extends Subsystem {

	//DigitalInput LiftLimitSwitch_T;
	//LiftLimitSwitch_T = new DigitalInput(RobotMap.LiftLimit_T);
	
	private VictorSP MiniCIMs = new VictorSP(RobotMap.Elevator);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void Raise() {
		MiniCIMs.set(1.0);
	}
	
	public void Lower() {
		MiniCIMs.set(-.6);
	}

	public void Stop() {
		MiniCIMs.set(0);
	}
}