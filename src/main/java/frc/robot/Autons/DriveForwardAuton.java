// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.AutoDrive;
import frc.robot.Subsystems.DriveSubsystem;

public class DriveForwardAuton extends SequentialCommandGroup {
  /** Creates a new DriveForwardAuton. */
  public DriveForwardAuton(DriveSubsystem DRIVE_SUBSYSTEM) {
    //Holds all the commands
    addCommands(
    new AutoDrive(DRIVE_SUBSYSTEM, 0.5, 0).withTimeout(2)
    );
  
  
  }


}