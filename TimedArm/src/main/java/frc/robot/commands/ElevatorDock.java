/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorDock extends Command {
  //initializes variables
  int target;
  double speed;
  boolean finished;

  public ElevatorDock(int dock) {
    //sets the motor speed and target level
    target = dock;
    speed = 0.6;

    //makes the command requires the ElevatorSystem subsystem. Only
    //one command can use a subsystem at a time
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //sets the speed of the motor based on the target and current position
    if (target > Robot.arm.getLevel()) {
      speed = Math.abs(speed);
    } else if(target < Robot.arm.getLevel()) {
      speed = -Math.abs(speed);
    }

    //only moves the arm if not at target level
    if (target != Robot.arm.getLevel()) {
      Robot.arm.moveArm(speed);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //waits 0.6 seconds, stsops the arm movement, and updates the level variable in the subsystem
    Timer.delay(0.6);
    Robot.arm.stopArm();
    Robot.arm.setLevel(target);
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
