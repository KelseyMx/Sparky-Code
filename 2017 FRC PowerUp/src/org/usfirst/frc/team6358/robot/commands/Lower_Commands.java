package org.usfirst.frc.team6358.robot.commands;

import org.usfirst.frc.team6358.robot.Robot;
import org.usfirst.frc.team6358.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class Lower_Commands extends Command{
	
	DigitalInput LowerSwitch = new DigitalInput(RobotMap.LiftLimit_B);
	
	public Lower_Commands() {
		requires(Robot.Elevator);
	}
	
	@Override
	protected void initialize() {	
	}
	
	@Override
	protected void execute() {	
		//while(Robot.oi.getCoPilotJoystick().getRawButton(2)==true && LowerSwitch.get()==false) {
			//Robot.Elevator.Lower(); //only executes while joystick pressed AND Limit Switch is open (false)
		//}
			if(LowerSwitch.get()==false) {
				Robot.Elevator.Lower();
				}
			
				else {Robot.Elevator.Stop();
				};
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		//Robot.Elevator.Stop();
	}
	
	@Override
	protected void interrupted() {
		Robot.Elevator.Stop();
	}
}
