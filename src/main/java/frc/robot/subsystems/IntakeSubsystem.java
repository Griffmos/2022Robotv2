// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new Intake. */

  private WPI_TalonFX intakeMotor = new WPI_TalonFX(11); // Located popping out in the front of the robot
  private double currIntakePercOut = 0; // Used to store the current percent output of intake motor

  private WPI_TalonFX gateMotor = new WPI_TalonFX(9); // Near the top of the robot
  private double currGatePercOut = 0; // Used to store the current percent output of gate motor

  public IntakeSubsystem() {
    intakeMotor.configFactoryDefault();
    gateMotor.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("INTAKE MOTOR PERCENT OUTPUT", currIntakePercOut);
    SmartDashboard.putNumber("GATE MOTOR PERCENT OUTPUT", currGatePercOut);

  }

  // Change Speed to the Intake and Gate Motors
  public void set(double intakePercOut, double gatePercOut) {

    intakeMotor.set(ControlMode.PercentOutput, intakePercOut);
    gateMotor.set(ControlMode.PercentOutput, gatePercOut);
    currIntakePercOut = intakePercOut;
    currGatePercOut = gatePercOut;

  }

  // Stop all motors and reset variables
  public void stop() {

    intakeMotor.set(ControlMode.PercentOutput, 0);
    gateMotor.set(ControlMode.PercentOutput, 0);
    currIntakePercOut = 0;
    currGatePercOut = 0;

  }

}
