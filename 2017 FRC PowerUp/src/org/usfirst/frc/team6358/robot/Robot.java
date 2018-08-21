
package org.usfirst.frc.team6358.robot;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.CameraServer;


import org.usfirst.frc.team6358.robot.subsystems.Arm_Subsystem;
import org.usfirst.frc.team6358.robot.subsystems.DriveTrain_Subsystem;
import org.usfirst.frc.team6358.robot.subsystems.Elevator_Subsystem;
import org.usfirst.frc.team6358.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team6358.robot.subsystems.Intake_Subsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain_Subsystem DriveTrain = new DriveTrain_Subsystem();
	public static final Elevator_Subsystem Elevator = new Elevator_Subsystem();
	public static final Intake_Subsystem Intake = new Intake_Subsystem();
	public static final Arm_Subsystem Arm = new Arm_Subsystem();
	DigitalInput BlueSwitch;
	DigitalInput RedSwitch;
	DigitalInput LiftLimitSwitchT;
	public static final AnalogInput FrontUS = new AnalogInput(RobotMap.FUltrasonic);
	public static final AnalogInput BackUS = new AnalogInput(RobotMap.BUltrasonic);
	
	RobotDrive MainDrive;
	Timer timer;
	public static OI oi;
	//Command autonomousCommand;
	//SendableChooser<String> chooser = new SendableChooser<>();
	edu.wpi.first.wpilibj.CameraServer server = edu.wpi.first.wpilibj.CameraServer.getInstance();


	/**
	 * 
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		BlueSwitch = new DigitalInput(RobotMap.BSwitch);
		RedSwitch = new DigitalInput(RobotMap.RSwitch);
		timer = new Timer();
		server.startAutomaticCapture();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		timer.reset();// Resets the timer to 0
		timer.start();//Start Counting
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void autonomousPeriodic() {
		
		
		while(timer.get() < 3 ) {Robot.DriveTrain.BackwardDrive();		}
		while (timer.get()> 4 && timer.get()<6) {Robot.DriveTrain.R90TurnDrive(); }
		while (timer.get()> 7 && timer.get()<12) {Robot.DriveTrain.BackwardDrive(); }		
		
		
		

	
		
		/*String gameData; // CharAt (0 = close switch, 1 = Scale, 2 = far switch)
		gameData = DriverStation.getInstance().getGameSpecificMessage(); // Retrieves LLL, RRR, RLR, etc. from the DriverStation
		if (BlueSwitch.get() == true) { // if BlueSwitch is ON
	// Switch code if no other alliance member can obtain the switch, we must score!(Start in the middle)
			if (gameData.charAt(0) == 'R') { // Conditional statement to determine which switch is ours.
				//reversed all values
				boolean initial = true;
				while (timer.get() < 0.65) {Robot.DriveTrain.BackwardDrive();}//Changed from forward to backward
				while (timer.get()> 0.65 && timer.get()<1.45) {Robot.DriveTrain.R45TurnDrive(initial);  if(initial) {initial = false;}} //Right to left 45 turn
				while (timer.get()> 1.35 && timer.get()<3.2) {Robot.DriveTrain.BackwardDrive();}
				initial = true;
				while (timer.get()> 3.25 && timer.get()< 4.2) {Robot.DriveTrain.L45TurnDrive(initial); if(initial) {initial = false;}}//Left to right 45 turn
				initial = true;
				while (timer.get()> 4.2 && timer.get()<4.75) {Robot.DriveTrain.BackwardDrive();}
			//Insert switch deliver code
				while (timer.get() > 0 && timer.get() < 4.5) {Robot.Arm.Stop();}
				while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}
				while (timer.get() > 4.75  && timer.get() < 5.8) {Robot.Arm.SwingUp();}
				while (timer.get() > 6.0 && timer.get() < 6.15){Robot.Intake.AutoOut();}
				while (timer.get() > 6.4 && timer.get() < 6.5) {Robot.Arm.Stop();}
				while (timer.get() > 6.17 && timer.get() < 7.0) {Robot.Intake.Stop();}



			}
			else { // if conditional statement is false, our switch is left.
				boolean initial = true;
				while (timer.get() <0.75) {Robot.DriveTrain.BackwardDrive();}
				while (timer.get()>0.75 && timer.get()<1.35) {Robot.DriveTrain.L45TurnDrive(initial); if(initial) {initial = false;}}
				while (timer.get()>1.35 && timer.get()<2.73) {Robot.DriveTrain.BackwardDrive();}
				initial = true;
				while (timer.get()>3.25 && timer.get()<4.25) {Robot.DriveTrain.R45TurnDrive(initial);  if(initial) {initial = false;}}
				while (timer.get()>4.35 && timer.get()<4.85) {Robot.DriveTrain.BackwardDrive();}
			//Insert Switch Delivery Code here
				while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}
				while (timer.get() > 4.9 && timer.get() < 5.8) {Robot.Arm.SwingUp();}
				while (timer.get() > 5.9 && timer.get() < 5.99) {Robot.Intake.AutoOut();}
				while (timer.get() > 6.4 && timer.get() < 6.5) {Robot.Arm.Stop();}
				while (timer.get() > 6.0 && timer.get() < 7.0) {Robot.Intake.Stop();}

				//while (timer.get() > 6.0 && timer.get() < 6.5) {Robot.Arm.SwingDown();}
				//while (timer.get() > 6.5 && timer.get() < 7.0) {Robot.Arm.IdleDown();}
			}
				}
	else { //if BlueSwitch is OFF - We Run Conditionals from RedSwitch
			if(RedSwitch.get() == true) { // BlueSwitch is OFF && RedSwitch is ON
	// (Left from the driver station) Autoline Code
				if (gameData.charAt(1) == 'L') {	// Looking to score autoline
					boolean initial = true;
					while (timer.get() < 3.5) {Robot.DriveTrain.ForwardDrive(initial); if(initial) {initial = false;}}
					while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}
					
				} else { 
					if (gameData.charAt(0)== 'L') { // Looking to score the switch if it is on our side.
						boolean initial = true;
						while (timer.get() < 3.5) {Robot.DriveTrain.ForwardDrive(initial); if(initial) {initial = false;}}
						while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}
						}
					//replace with auto line
					else {// The left switch was not ours, score on the right side of the close switch.
						boolean initial = true;
						while (timer.get() < 3.5) {Robot.DriveTrain.ForwardDrive(initial); if(initial) {initial = false;}}
						while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}			
						}
					}
				}
			
			else { //BlueSwitch is OFF and RedSwitch is OFF
//Experimental Code section only if switch combination above is matched
				if (gameData.charAt(1) == 'R') { // Score the scale.
					boolean initial = true;
					while (timer.get() < 3.5) {Robot.DriveTrain.ForwardDrive(initial); if(initial) {initial = false;}}
					while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}
					
				}
				else { 
					if (gameData.charAt(0) == 'R'){ // Looking to score the switch if it is on our side.
						boolean initial = true;
						while (timer.get() < 3.5) {Robot.DriveTrain.ForwardDrive(initial); if(initial) {initial = false;}}
						while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}

					} 
					else {// The Right switch was not ours score on the right side of the close switch.
						boolean initial = true;
						while (timer.get() < 3.5) {Robot.DriveTrain.ForwardDrive(initial); if(initial) {initial = false;}}
						while (timer.get() > 0 &&  timer.get() < 4.2) {Robot.Intake.Idle();}

						}
					}
				}
			}
*/
	
	Scheduler.getInstance().run();
	
}
	
					
	

	private static void DriveTrain(double d, double e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teleopInit() {

	}
 
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
