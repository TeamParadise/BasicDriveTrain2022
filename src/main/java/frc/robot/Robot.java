// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;  

//Talon imports
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */


  //Making the objects for the motor

  //right motor
  private final WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(2);
  private final WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(15);

  //left motor
  private final WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(3);
  private final WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(16);

  //Making the groups to put in the drive train
  private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup(rightMotor1, rightMotor2); 
  private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

  //Drive Train
  DifferentialDrive driveTrain = new DifferentialDrive(leftMotorGroup, rightMotorGroup);  

  Joystick stick = new Joystick(0);

  @Override
  public void robotInit() {
    //inverting the motors cuz we were forced to
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
    leftMotor1.setInverted(true);
    leftMotor2.setInverted(true);

    rightMotor1.setSafetyEnabled(false);
    rightMotor2.setSafetyEnabled(false);
    leftMotor1.setSafetyEnabled(false);
    leftMotor2.setSafetyEnabled(false);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    //change to x, y if it doesn't work
    //set slider to 0 if it is something like 0.3
    //do we want to change arcade drive to curvature drive? might make it easier to control - felix
    driveTrain.arcadeDrive(stick.getZ()*stick.getThrottle()/2, stick.getY());
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
