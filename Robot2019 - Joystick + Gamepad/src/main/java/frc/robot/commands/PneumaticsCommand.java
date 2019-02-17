/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PneumaticsCommand extends Command {

  // initializes PneumaticsSubsystem
  int counter;

  public PneumaticsCommand() {
    // defines PneumaticsSubsystem so it can be used by this class
    Robot.pneumatics.retract();
    // necessary to allow the class to use the pneumatics subsystem because
    // only one class may use a subsystem at a time.
    requires(Robot.pneumatics);
  }

  @Override
  protected void initialize() {
    counter = 0;
    Robot.pneumatics.extend();
  }

  @Override
  protected void execute() {
    counter++;
  }

  @Override
  protected boolean isFinished() {
    if (counter > 25) {
      Robot.pneumatics.retract();
      counter = 0;
      return true;
    }
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}