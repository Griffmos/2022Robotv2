// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase {
  /** Creates a new DefaultDriveCommand. */

  // Objects we need in order to drive
  private DriveSubsystem DRIVE_SUBSYSTEM; // To control motor
  private Joystick CONTROLLER; // get joystick input

  // Limits the maximum acceleration
  private SlewRateLimiter direction = new SlewRateLimiter(2); // limits for forward and back
  private SlewRateLimiter rotation = new SlewRateLimiter(4); // limits for rotate side to side

  public DefaultDriveCommand(DriveSubsystem drive, Joystick controller) {
    DRIVE_SUBSYSTEM = drive;
    CONTROLLER = controller;

    addRequirements(DRIVE_SUBSYSTEM);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DRIVE_SUBSYSTEM.set(
        direction.calculate(CONTROLLER.getRawAxis(1)), // Left joysticks y axis
        rotation.calculate(CONTROLLER.getRawAxis(2))); // Right joysticks x axis
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DRIVE_SUBSYSTEM.stop(); // End the driveSubsytem when...
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
