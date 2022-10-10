// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeAndConveyerSubsystem extends SubsystemBase {


    
  private WPI_TalonFX conveyerMotor = new WPI_TalonFX(13); //DOCUMENT WHERE THIS IS
  private double currConveyerPercOut; //used to display percent output of conveyer on smartdashboard 

   
  private WPI_TalonFX intakeMotor = new WPI_TalonFX(11); //intake motor on the pop out intake shield
  private double currIntakePercOut;//used to display intake motor percent output on smartdashboard 

  private WPI_TalonFX gateMotor = new WPI_TalonFX(9); //located on ceiling of ball storage
  private double currGatePercOut; //used to display gate motor percent output on smartdashboard 
  


  /** Creates a new IntakeAndConveyerSubsystem. */
  public IntakeAndConveyerSubsystem() {

    conveyerMotor.configFactoryDefault();
    intakeMotor.configFactoryDefault();
    gateMotor.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  //displayed stuff for smartdashboard

    SmartDashboard.putNumber("INTAKE MOTOR PERCENTAGE OUTPUT", currIntakePercOut);

    SmartDashboard.putNumber("GATE MOTOR PERCENTAGE OUTPUT", currGatePercOut);

    SmartDashboard.putNumber("CONVEYER MOTOR PERCENTAGE OUPUT", currConveyerPercOut);

  

  }


  //setting percentage outputs to motors
  public void set(double conveyerPercOut, double intakePercOut, double gatePercOut){

    //the curr____PercOut = _____PercOut is setting to our smartdashboard variables

    conveyerMotor.set(ControlMode.PercentOutput, conveyerPercOut);
    currConveyerPercOut = conveyerPercOut;

    intakeMotor.set(ControlMode.PercentOutput, intakePercOut);
    currIntakePercOut = intakePercOut;

    gateMotor.set(ControlMode.PercentOutput, gatePercOut);
    currGatePercOut = gatePercOut;
  }


  //stopping all motors in this subsystem
  public void stop(){
    conveyerMotor.set(ControlMode.PercentOutput, 0);

    intakeMotor.set(ControlMode.PercentOutput, 0);

    gateMotor.set(ControlMode.PercentOutput, 0);
  }
}
