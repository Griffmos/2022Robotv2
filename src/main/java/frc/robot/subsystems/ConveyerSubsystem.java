// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyerSubsystem extends SubsystemBase {


  
   private WPI_TalonFX conveyerMotor = new WPI_TalonFX(13); //DOCUMENT WHERE THIS IS
   private double currConveyerPercOut; //used to display percent output on smartdashboard since percent output is passed in and there is no other way to consistantly access it


  /** Creates a new ConveyerSubsystem. */
  public ConveyerSubsystem() {
      conveyerMotor.configFactoryDefault();  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //info for dashboard
    SmartDashboard.putNumber("CONVEYER MOTOR PERCENT OUTPUT", currConveyerPercOut);
  }

  //setting speed to conveyer
  public void set(double conveyerPercOut){
    conveyerMotor.set(ControlMode.PercentOutput, conveyerPercOut);

    //used to show on SmartDashboard
    currConveyerPercOut=conveyerPercOut;

    //conveyerMotor.getMotorOutputPercent();
  }

  //hard stops conveyer
  public void stop(){
    conveyerMotor.set(ControlMode.PercentOutput, 0);

    currConveyerPercOut=0;
  }

}
