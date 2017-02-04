package org.usfirst.frc.team5160.robot.subsystems;

import org.usfirst.frc.team5160.robot.RobotMap;
import com.ctre.CANTalon;
import org.usfirst.frc.team5160.robot.commands.TeleOpMecanumDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Base extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//TODO: Install libraries for CANTalon
	
	//Declare motors
	private CANTalon frontLeft;
	private CANTalon backLeft;
	private CANTalon frontRight;
	private CANTalon backRight;
	
	//Declare drive base
	private RobotDrive driveBase;
	
	//Declare gyro
	private ADXRS450_Gyro gyro;
	
	public Base(){
		
		//Init motors
		frontLeft = new CANTalon(RobotMap.FRONT_LEFT_CIM);
		backLeft = new CANTalon(RobotMap.BACK_LEFT_CIM);
		frontRight = new CANTalon(RobotMap.FRONT_RIGHT_CIM);
		backRight = new CANTalon(RobotMap.BACK_RIGHT_CIM);
		
		//Init base
		driveBase = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
		//Init gyro
		gyro = new ADXRS450_Gyro(/*port*/);
		
	}

    public void initDefaultCommand() {
    	//set default command as TeleOp Drive
    	setDefaultCommand(new TeleOpMecanumDrive());
    	
    }
    public void mecanumDrive(double x, double y, double rotation){
    	
    	//Cartesian mecanum drive
    	driveBase.mecanumDrive_Cartesian(x, y, rotation, gyro.getAngle());
    }
    public ADXRS450_Gyro getGyro(){
    	return gyro;
    }
}
