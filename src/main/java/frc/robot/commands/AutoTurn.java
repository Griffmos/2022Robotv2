// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.GyroSubsystem;

public class AutoTurn extends CommandBase {
  /** Creates a new AutoTurn. */

  private GyroSubsystem GYRO_SUBSYSTEM;
  private DriveSubsystem DRIVE_SUBSYSTEM;

  private int degree; // Target Degree
  private boolean isFinished; // Tells if we reached our target Degree
  private int rightLeft; // left: -1 right: 1

  public AutoTurn(GyroSubsystem gyro, DriveSubsystem drive, int degree) {
    // Use addRequirements() here to declare subsystem dependencies.
    GYRO_SUBSYSTEM = gyro;
    DRIVE_SUBSYSTEM = drive;

    this.degree = degree;
    isFinished = false;

    addRequirements(GYRO_SUBSYSTEM);
    addRequirements(DRIVE_SUBSYSTEM);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    GYRO_SUBSYSTEM.resetHeading();

    // Figuring out whether to move right or left
    if (degree >= 0)
      rightLeft = 1;
    else
      rightLeft = -1;

    degree = Math.abs(degree); // after finding which direction to turn, we can use + degree

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Deciding whether we have hit target or not
    if (GYRO_SUBSYSTEM.getHeading() >= degree) // If we are greater or equal to degree, command finished
      isFinished = true;
    else {
      DRIVE_SUBSYSTEM.set(0, rightLeft * 0.6); // otherwise turn the robot in the correct direction
    }

    /*
     * 
     * Other implementation
     * 
     * if (degree > 0){
     * if (GYRO_SUBSYSTEM.getHeading() >= degree){
     * isFinished = true;
     * } else {
     * DRIVE_SUBSYSTEM.set(0, 0.6);
     * }
     * }
     * else if (degree < 0){
     * if (GYRO_SUBSYSTEM.getHeading() <= degree){
     * isFinished = true;
     * } else {
     * DRIVE_SUBSYSTEM.set(0, -0.6);
     * }
     * }
     */

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DRIVE_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
