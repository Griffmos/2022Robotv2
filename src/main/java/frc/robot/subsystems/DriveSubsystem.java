// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  // instantiating DRIVETRAIN motors

  // on left front side in a cluster (near clamshell open)
  private WPI_TalonFX leftDrivePrimary = new WPI_TalonFX(1);
  private WPI_TalonFX leftDriveF1 = new WPI_TalonFX(2);
  private WPI_TalonFX leftDriveF2 = new WPI_TalonFX(3);

  // on right front side in a cluster (near clamshell open)
  private WPI_TalonFX rightDrivePrimary = new WPI_TalonFX(4);
  private WPI_TalonFX rightDriveF1 = new WPI_TalonFX(5);
  private WPI_TalonFX rightDriveF2 = new WPI_TalonFX(6);

  public final DifferentialDrive DRIVE;

  public DriveSubsystem() {

    // setting to factory default to AVOID past settings being kept
    leftDrivePrimary.configFactoryDefault();
    leftDriveF1.configFactoryDefault();
    leftDriveF2.configFactoryDefault();

    rightDrivePrimary.configFactoryDefault();
    rightDriveF1.configFactoryDefault();
    rightDriveF2.configFactoryDefault();

    // setting up follows
    leftDriveF1.follow(leftDrivePrimary);
    leftDriveF2.follow(leftDrivePrimary);

    rightDriveF1.follow(rightDrivePrimary);
    rightDriveF2.follow(rightDrivePrimary);

    // inverting left side
    leftDrivePrimary.setInverted(InvertType.InvertMotorOutput); // actually inverts it
    leftDriveF1.setInverted(InvertType.FollowMaster); // does the same invert type as the thing it is following
    leftDriveF2.setInverted(InvertType.FollowMaster);

    // setting right to not invert (makes it easy to swap invert)
    rightDrivePrimary.setInverted(InvertType.None);
    rightDriveF1.setInverted(InvertType.FollowMaster); // follows same invert type as the thing it is following
    rightDriveF2.setInverted(InvertType.FollowMaster);

    // Diff Drive does a lot; can cap voltage, or many other things, check CTRE docs
    DRIVE = new DifferentialDrive(leftDrivePrimary, rightDrivePrimary);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // just putting info on the dashboard
    SmartDashboard.putNumber("LEFT MOTOR SPEED", leftDrivePrimary.getSelectedSensorVelocity());
    SmartDashboard.putNumber("RIGHT MOTOR SPEED", rightDrivePrimary.getSelectedSensorVelocity());

    SmartDashboard.putNumber("LEFT MOTOR POSITION", getLeftPosition());
    SmartDashboard.putNumber("RIGHT MOTOR POSITION", getRightPosition());

  }

  // leftStickY corresponds to our robot's speed rightStickX corresponds to our
  // robot's z rotation
  public void set(double leftStickY, double rightStickX) {
    leftStickY = Constants.motorLimitPercent * leftStickY;
    rightStickX = Constants.motorLimitPercent * rightStickX;

    // using arcade drive
    DRIVE.arcadeDrive(leftStickY, rightStickX);
  }

  // hard stops robot
  public void stop() {
    leftDrivePrimary.set(ControlMode.PercentOutput, 0);
    rightDrivePrimary.set(ControlMode.PercentOutput, 0);
  }

  // all of our methods for getting info about our drive motors

  public double getLeftPosition() {
    return leftDrivePrimary.getSelectedSensorPosition();
  }

  public double getRightPosition() {
    return rightDrivePrimary.getSelectedSensorPosition();
  }

  public void resetPosition() {
    leftDrivePrimary.setSelectedSensorPosition(0);
    rightDrivePrimary.setSelectedSensorPosition(0);
  }

  public double getLeftVelocity() {
    return leftDrivePrimary.getSelectedSensorVelocity();
  }

  public double getRightVelocity() {
    return rightDrivePrimary.getSelectedSensorVelocity();
  }

}
