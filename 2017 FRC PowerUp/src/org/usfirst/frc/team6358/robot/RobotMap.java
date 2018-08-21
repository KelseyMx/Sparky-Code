package org.usfirst.frc.team6358.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port 
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int
		//Motors
		Drive_Left = 0,//changed from 5 to 0
		Drive_Right = 1,//changes from 4 to 1
		Elevator = 5,
		Intake = 2,
		Arm = 7,

		
		//Digital Input
		BSwitch = 9,
		RSwitch = 8,
		LiftLimit_T = 0,
		LiftLimit_T2 = 1, //new - adjust ports, add code
		LiftLimit_B = 2,
		LiftLimit_B2 = 3,  //new - adjust ports
		
		//Sensors
		FUltrasonic = 0,
		BUltrasonic = 1;  //new - add some code
	
	
	public static double
		GyroSensitivity = 0.011,
		Kp = 0.003,
	
		//Magic Numbers for the Ultrasonic Sensor - to score the SWITCH from middle
		Front_JustEnoughForATurn = 0.59, //Moves robot away from wall ~
		Back_JustEnoughForATUrn = 0.59,
		Front_MidSwitchFromGuardrail = 2.9, //Moves robot away from Guardrail ~ 199"
		Front_MidSwitchFromDriverStation = 1.6; //Moves robot to MidSwitch measured from DS ~140"
	
	
		
}
