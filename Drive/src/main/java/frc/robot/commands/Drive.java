/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Drive extends Command {
  //initializes the subsystems and joystick
  private Joystick stick;

  public Drive() {
    // defines the subsystems and joystick
    stick = new Joystick(0);

    //Makes it so that this is the only command that can access the drive subsystem at a time
    requires(Robot.driveSystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //calls the drive function of the drive subsystem. sets the robot's speed and turning to the joystick
    Robot.driveSystem.driveRobot(-stick.getY(), stick.getX());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
