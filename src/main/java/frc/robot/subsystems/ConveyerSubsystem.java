// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyerSubsystem extends SubsystemBase {

   private TalonFX conveyerMotor = new TalonFX(13);

   //used to display speed on smartdashboard since speed is passed in and there is no other way to consistantly access it
   private double currConveyerSpeed;


  /** Creates a new ConveyerSubsystem. */
  public ConveyerSubsystem() {
      conveyerMotor.configFactoryDefault();  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //info for dashboard
    SmartDashboard.putNumber("Conveyer Speed", currConveyerSpeed);
  }

  //setting speed to conveyer
  public void set(double conveyerSpeed){
    conveyerMotor.set(ControlMode.PercentOutput, conveyerSpeed);

    //used to show on SmartDashboard
    currConveyerSpeed=conveyerSpeed;

    //conveyerMotor.getMotorOutputPercent();
  }

  //hard stops conveyer
  public void stop(){
    conveyerMotor.set(ControlMode.PercentOutput, 0);

    currConveyerSpeed=0;
  }

}
