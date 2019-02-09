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

public class ToggleHatch extends Command {
  //initializes variables
  private int status;
  private double speed;
  private boolean finished;

  public ToggleHatch() {
    //sets the values of variables
    speed = 0.3;
    status = 0;

    //makes the command require the ElevatorSubsystem. Only 1 command
    //can use the subsystem at a time
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //causes the variable to alternate between 0 and 1
    status = (status + 1) % 2;

    //moves the arm based on status
    if(status == 0) {
      Robot.arm.moveArm(speed);
    } else if (status == 1) {
      Robot.arm.moveArm(-speed);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //stops arm after 2 seconds
    Timer.delay(0.2);
    Robot.arm.stopArm();
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
