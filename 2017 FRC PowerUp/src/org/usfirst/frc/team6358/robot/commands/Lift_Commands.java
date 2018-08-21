package org.usfirst.frc.team6358.robot.commands;

import org.usfirst.frc.team6358.robot.Robot;
import org.usfirst.frc.team6358.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class Lift_Commands extends Command{
	
	DigitalInput UpperSwitch = new DigitalInput(RobotMap.LiftLimit_T);
	
	
	public Lift_Commands() {
		requires(Robot.Elevator);
	}
	
	@Override
	protected void initialize() {	
	}
	
	@Override
	protected void execute() {	
		//while(Robot.oi.getCoPilotJoystick().getRawButton(3)==true && UpperSwitch.get()==false) {
			//Robot.Elevator.Raise(); //only executes while joystick pressed AND Limit Switch is open (false)
		//}
	//	Robot.Elevator.Stop();
		if(UpperSwitch.get()==false) {
			Robot.Elevator.Raise();
			}
			else {Robot.Elevator.Stop();
			};
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// Make this statement return as true when our command no longer needs to run execute()
		// If LiftLimit_T is pressed (measures as TRUE), don't execute Lift_Command
		//return UpperSwitch.get()==true ; //No idea why this doesn't work
		return false;
	}

	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted() {
		Robot.Elevator.Stop();

	}
}
