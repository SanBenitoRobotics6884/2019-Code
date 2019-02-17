/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveArm;

public class ElevatorSystem extends Subsystem {

  //initializes all variables to be defined in the constructor
  private RobotMap map = new RobotMap();
  private SpeedController motorcontroller = new Spark(map.ELEVATOR_MOTOR);
  private Joystick stick = new Joystick(0);

  //defines all variables and systems
  public ElevatorSystem() {
    
  }

  private double ramp(double inputAxis) {
    return Math.pow(inputAxis, 1) * 0.55;
  }

  //moves the arm motor according to the joystick
  public void moveArm() {
    motorcontroller.set(ramp(stick.getRawAxis(5)));
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
  }
}
