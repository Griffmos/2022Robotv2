// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ConveyerSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;

public class RunOuttakeCommand extends CommandBase {

  //subsystems objects we need to run the initake
  IntakeSubsystem INTAKE_SUBSYSTEM;
  ConveyerSubsystem CONVEYER_SUBSYSTEM;

  /** Creates a new RunIntakeCommand. */
  public RunOuttakeCommand(IntakeSubsystem intake, ConveyerSubsystem conveyer) {
    // Use addRequirements() here to declare subsystem dependencies.
    INTAKE_SUBSYSTEM = intake;
    CONVEYER_SUBSYSTEM = conveyer;

    addRequirements(INTAKE_SUBSYSTEM);
    addRequirements(CONVEYER_SUBSYSTEM);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //values for outtaking ball well (shooting it out the intake side of the robot to avoid penalty)
    INTAKE_SUBSYSTEM.set(-1);
    CONVEYER_SUBSYSTEM.set(-0.5, -0.75);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    INTAKE_SUBSYSTEM.stop();
    CONVEYER_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
