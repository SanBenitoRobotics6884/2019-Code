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
  private Joystick stick = new Joystick(1);

  private double speed = 0;
  private double rotation = 0;
  private double trim = 0;

  public Drive() {
    requires(Robot.drivebase);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    speed = stick.getY();
    rotation = stick.getX();
    trim = (1 - stick.getRawAxis(3)) * 0.6;
    Robot.drivebase.driveRobot(-speed, -rotation, trim);
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
