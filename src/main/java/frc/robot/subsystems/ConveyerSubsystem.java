// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyerSubsystem extends SubsystemBase {


  
   private WPI_TalonFX conveyerMotor = new WPI_TalonFX(13); //DOCUMENT WHERE THIS IS
   private WPI_TalonFX gateMotor = new WPI_TalonFX(9); // Near the top of the robot, right before shooter


   private double currGatePercOut; // Used to store the current percent output of gate motor
   private double currConveyerPercOut; //used to display percent output on smartdashboard since percent output is passed in and there is no other way to consistantly access it


  /** Creates a new ConveyerSubsystem. */
  public ConveyerSubsystem() {
      conveyerMotor.configFactoryDefault();  
      gateMotor.configFactoryDefault();

      //these don't have to be inverted to have natural input
      conveyerMotor.setInverted(InvertType.None);
      gateMotor.setInverted(InvertType.None);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //info for dashboard
    SmartDashboard.putNumber("CONVEYER MOTOR PERCENT OUTPUT", currConveyerPercOut);
    SmartDashboard.putNumber("GATE MOTOR PERCENT OUTPUT", currGatePercOut);

  }

  //setting speed to conveyer
  public void set(double conveyerPercOut, double gatePercOut){
    conveyerMotor.set(ControlMode.PercentOutput, conveyerPercOut);

    //used to show on SmartDashboard
    currConveyerPercOut=conveyerPercOut;
    currGatePercOut = gatePercOut;

    gateMotor.set(ControlMode.PercentOutput, gatePercOut);

    //conveyerMotor.getMotorOutputPercent();
  }

  //hard stops conveyer
  public void stop(){
    conveyerMotor.set(ControlMode.PercentOutput, 0);
    gateMotor.set(ControlMode.PercentOutput, 0);

    currConveyerPercOut=0;
    currGatePercOut = 0;

  }

}
