// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Utilities.SpectrumAxisButton;
import frc.robot.Utilities.SpectrumAxisButton.ThresholdType;
import frc.robot.Autons.DriveForwardAuton;
import frc.robot.Commands.DefaultDriveCommand;
import frc.robot.Commands.RunConveyerCommand;
import frc.robot.Commands.RunIntakeCommand;
import frc.robot.Commands.RunOuttakeCommand;
import frc.robot.Commands.RunShooterCommand;
import frc.robot.Subsystems.ConveyerSubsystem;
import frc.robot.Subsystems.DriveSubsystem;
//import frc.robot.Subsystems.IntakeAndConveyerSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Joystick CONTROLLER = new Joystick(4); //Our controller from 1st port

  //regular buttons on controller
  private JoystickButton X_BUTTON = new JoystickButton(CONTROLLER, 2);
  private JoystickButton L1_BUMPER = new JoystickButton(CONTROLLER, 5);
  private JoystickButton R1_BUMPER = new JoystickButton(CONTROLLER, 6);

  //using triggers as digital buttons instead of analog
  private SpectrumAxisButton L2_TRIGGER = new SpectrumAxisButton(CONTROLLER, 3, 0.15, ThresholdType.GREATER_THAN);
  private SpectrumAxisButton R2_TRIGGER = new SpectrumAxisButton(CONTROLLER, 4, 0.15, ThresholdType.GREATER_THAN);

  //THE OFFICIAL SUBSYSTEMS

  private ConveyerSubsystem CONVEYER_SUBSYSTEM = new ConveyerSubsystem();

  private DriveSubsystem DRIVE_SUBSYSTEM = new DriveSubsystem();

  //private IntakeAndConveyerSubsystem INTAKE_AND_CONVEYER_SUBSYSTEM = new IntakeAndConveyerSubsystem();

  private IntakeSubsystem INTAKE_SUBSYSTEM = new IntakeSubsystem();

  private ShooterSubsystem SHOOTER_SUBSYSTEM = new ShooterSubsystem();  




  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    defaultCommands();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    L1_BUMPER.whileHeld(new RunIntakeCommand(INTAKE_SUBSYSTEM, CONVEYER_SUBSYSTEM)); //L1 bumper intakes
    R1_BUMPER.whileHeld(new RunOuttakeCommand(INTAKE_SUBSYSTEM, CONVEYER_SUBSYSTEM)); //R1 bumper outtakes

    R2_TRIGGER.whileHeld(new RunShooterCommand(SHOOTER_SUBSYSTEM));
    L2_TRIGGER.whileHeld(new RunConveyerCommand(INTAKE_SUBSYSTEM, CONVEYER_SUBSYSTEM)); //R2 trigger runs conveyer (actually pushes ball in)
  }

  //runs if no other commands are running
  private void defaultCommands() {
    DRIVE_SUBSYSTEM.setDefaultCommand(new DefaultDriveCommand(DRIVE_SUBSYSTEM, CONTROLLER));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new DriveForwardAuton(DRIVE_SUBSYSTEM);
    }
  }

