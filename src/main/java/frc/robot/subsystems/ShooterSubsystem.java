// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {


  private WPI_TalonFX shooterMotorPrimary = new WPI_TalonFX(10); //DOCUMENT WHERE THIS IS
  private WPI_TalonFX shooterMotorSecondary = new WPI_TalonFX(7); //DOCUMENT WHERE THIS IS

  private double currShooterPercOut;//used to display percent output of shooter motor on smartdashboard 


  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shooterMotorPrimary.configFactoryDefault();
    shooterMotorSecondary.configFactoryDefault();

    
    shooterMotorSecondary.follow(shooterMotorPrimary); //both NEED to be spinning at same speed (connected by belts and gears)

    shooterMotorSecondary.setInverted(InvertType.InvertMotorOutput); //for them to work together in same direction, this one MUST be inverted

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //info for SD

    SmartDashboard.putNumber("SHOOTER PERCENT OUTPUT", currShooterPercOut);
  }


  //setting percentage output to motors
  public void set(double shooterPercOut){
    shooterMotorPrimary.set(ControlMode.PercentOutput, shooterPercOut); //only need to set to one motor since other is following

    currShooterPercOut = shooterPercOut; //for smart dashboard
  }

  //hard stopping motors
  public void stop(){
    shooterMotorPrimary.set(ControlMode.PercentOutput, 0);
    currShooterPercOut = 0;
  }
}
