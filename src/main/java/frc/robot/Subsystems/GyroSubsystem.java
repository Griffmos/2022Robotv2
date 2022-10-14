// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  /** Creates a new GyroSubsystem. */

  // PiGeoN GyRo ConTrOllEr
  private PigeonIMU Gyro = new PigeonIMU(14); // FIND OUT WHERE THIS IS

  public GyroSubsystem() {
  }

  // Returns current Heading in positive degrees in between 0 and 360
  public double getHeading() {
    return Math.IEEEremainder(Gyro.getFusedHeading(), 360);
  }

  // Hard resets where the gyro thinks its looking (degrees)
  public void resetHeading() {
    Gyro.setFusedHeading(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("GYRO HEADING", getHeading());

  }
}
