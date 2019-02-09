/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class WristSubsystem extends Subsystem {

public double height;

//creates variables to tune PID controller
private static final double kP = -5.0;
private static final double kI = -0.02;
private static final double kD = -2.0;

//initializes PID controller, potentiometer, and motor controller
public PIDController m_pidController;
private AnalogPotentiometer m_potentiometer;
private SpeedController m_elevatorMotor;

public void wristSubsystem() {
  //defines the potentiometer and motor
  m_potentiometer = new AnalogPotentiometer(RobotMap.ARM_POT);
    m_elevatorMotor = new Spark(RobotMap.ARM_MOTOR);

    //creates pid controller using the kP, kI, kD constants and using the potentiometer as an input
    m_pidController = new PIDController(kP, kI, kD, m_potentiometer, m_elevatorMotor);
    //sets the input range from 0-5 volts (min/max voltage of potentiometer)
    m_pidController.setInputRange(0, 5);
}

  public void wristSetpoint(double setpoint) {

    //sets the input to the input
    m_pidController.setSetpoint(setpoint);
    height = setpoint;

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
