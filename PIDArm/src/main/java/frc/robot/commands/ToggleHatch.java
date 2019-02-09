/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleHatch extends Command {
  //instantiates variables
  private int status;
  private boolean finished;
  private double setpoint;

  public ToggleHatch() {
    status = 0;

    //only one command can access a subsystem at a time. This claims control over the subsystem
    requires(Robot.wrist);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //causes the value of status to alternate between one and two each time the command is initialized
    status = (status + 1) % 2;
  }

  // Called repeatedly when this Command is scheduled to runrf
  @Override
  protected void execute() {

    //adds 5 to the PID setpoint for wrist subsystem
    setpoint = Robot.wrist.height + (status * 5);
    Robot.wrist.wristSetpoint(setpoint);

    //makes the command exit the scheduler. No longer gets called
    finished = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(finished) return true;
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
