// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//
//
// WHY IS THIS A COMMAND!!!!!
//
//

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterSubsystemClosedLoop extends CommandBase {
  /** Creates a new ShooterSubsystemClosedLoop. */

  private WPI_TalonFX shooterMotorPrimary = new WPI_TalonFX(10); // FIND OUT WHERE LOCATED
  private WPI_TalonFX shooterMotorSecondary = new WPI_TalonFX(7); // FIND OUT WHERE LOCATED

  public ShooterSubsystemClosedLoop() {

    shooterMotorPrimary.configFactoryDefault();
    shooterMotorSecondary.configFactoryDefault();

    // FIND OUT WHAT THIS DOES

    shooterMotorPrimary.setNeutralMode(NeutralMode.Coast);
    shooterMotorSecondary.setNeutralMode(NeutralMode.Coast);

    // Allows us to control the acceleration time of the Robot

    shooterMotorPrimary.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    shooterMotorSecondary.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);

    ConfigPIDMaxMin(shooterMotorPrimary);
    ConfigPIDMaxMin(shooterMotorSecondary);

    ConfigPIDValues(shooterMotorPrimary, 0, 0, 0, 0);
    ConfigPIDValues(shooterMotorSecondary, 0, 0, 0, 0);

  }

  // Consolidating code for setting up max and min for output
  private void ConfigPIDMaxMin(WPI_TalonFX motor) {

    motor.configNominalOutputForward(0);
    motor.configNominalOutputReverse(0);
    motor.configPeakOutputForward(1);
    motor.configPeakOutputReverse(-1);

  }

  private void ConfigPIDValues(WPI_TalonFX motor, int Proportional, int Integral, int Derivitive, int FeedForward) {
    motor.config_kP(0, Proportional); // Ramp up speed
    motor.config_kI(0, Integral); // Fixes errors in speed by slowing or speeding up
    motor.config_kD(0, Derivitive); // Dampens the motor, slowing everything (we think) ???
    motor.config_kF(0, FeedForward); // Feeds RPM to motors
  }

  // TIME WHERE WE ENDED VIDEO: 25:00

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
