// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ConveyerSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;

//Used to get conveyer running, after user spins up shooter

public class RunConveyerCommand extends CommandBase {

  //Subsystem objects needed to run the conveyer
  private IntakeSubsystem INTAKE_SUBSYSTEM;
  private ConveyerSubsystem CONVEYER_SUBSYSTEM;

  /** Creates a new RunConveyerCommand. */
  public RunConveyerCommand(IntakeSubsystem intake, ConveyerSubsystem conveyer) {
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
    //values for good conveying balls into shooter
    CONVEYER_SUBSYSTEM.set(0.5,0.5);
    INTAKE_SUBSYSTEM.set(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    CONVEYER_SUBSYSTEM.stop();
    INTAKE_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
