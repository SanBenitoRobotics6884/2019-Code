/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSystem extends Subsystem {
  //initializes the arm motor
  private Spark motorcontroller = new Spark(5);

  //initializes level variable
  private int level;

  public ElevatorSystem() {
    level = 1;
  }

  //sets the speed of the arm motor
  public void moveArm(double speed) {
    motorcontroller.set(speed);
  }

  //stops the arm
  public void stopArm() {
    motorcontroller.set(0);
  }

  //sets the level variable for the subsystem
  public void setLevel(int lvl) {
    level = lvl;
  }

  //returns the level variable
  public int getLevel() {
    return level;
  }

  @Override
  public void initDefaultCommand() {

  }
}
