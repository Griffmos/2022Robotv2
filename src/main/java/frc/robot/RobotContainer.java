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
import frc.robot.subsystems.DriveSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Joystick CONTROLLER = new Joystick(0); //Our controller from 1st port

  //regular buttons on controller
  private JoystickButton X_BUTTON = new JoystickButton(CONTROLLER, 2);
  private JoystickButton L1_BUMPER = new JoystickButton(CONTROLLER, 5);
  private JoystickButton R1_BUMPER = new JoystickButton(CONTROLLER, 6);

  //using triggers as digital buttons instead of analog
  private SpectrumAxisButton L2_TRIGGER = new SpectrumAxisButton(CONTROLLER, 3, 0.15, ThresholdType.GREATER_THAN);
  private SpectrumAxisButton R2_TRIGGER = new SpectrumAxisButton(CONTROLLER, 4, 0.15, ThresholdType.GREATER_THAN);

  //THE OFFICIAL SUBSYSTEMS

  private DriveSubsystem DRIVE_SUBSYSTEM = new DriveSubsystem();



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SequentialCommandGroup();
    }
  }
