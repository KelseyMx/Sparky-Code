package org.usfirst.frc.team6358.robot.subsystems;

import org.usfirst.frc.team6358.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm_Subsystem extends Subsystem {

	//DigitalInput LiftLimitSwitch_T;
	//LiftLimitSwitch_T = new DigitalInput(RobotMap.LiftLimit_T);
	
	private VictorSP ArmMotor = new VictorSP(RobotMap.Arm);
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void SwingUp() {
		ArmMotor.set(-.75);
	}
	
	public void SwingDown() {
		ArmMotor.set(.6);
	}
	 
	public void IdleDown() {
		ArmMotor.set(0.2);
	}
	
	public void IdleUp() {
		ArmMotor.set(-.3);
	}

	public void Stop() {
		ArmMotor.set(0);
	}
	
	//public void Idle() {
		//ArmMotor.set(-0.1);
	//}
}