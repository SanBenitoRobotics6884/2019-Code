/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WristCommand extends Command {

  int pointIn;
  double setpoint;
  boolean finished;

  public WristCommand(int setpoint) {
    
    pointIn = setpoint;
    finished = false;
    requires(Robot.wrist);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //changes the setpoint based on input
    if (pointIn == 0) {
      setpoint = 0;
    } else if (pointIn == 1) {
      setpoint = 10;
    } else if (pointIn == 2) {
      setpoint = 20;
    }

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //changes the setpoint of the wrist PID controller
    Robot.wrist.wristSetpoint(setpoint);
    finished = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (finished) return true;
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
