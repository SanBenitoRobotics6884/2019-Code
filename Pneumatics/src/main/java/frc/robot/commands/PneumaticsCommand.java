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
import frc.robot.subsystems.PneumaticsSubsystem;

public class PneumaticsCommand extends Command {

  private boolean finished;

  public PneumaticsCommand() {
    // defines PneumaticsSubsystem so it can be used by this class
    Robot.pneumatics = new PneumaticsSubsystem();
    Robot.pneumatics.retract();

    // necessary to allow the class to use the pneumatics subsystem because
    // only one class may use a subsystem at a time.
    requires(Robot.pneumatics);
  }

  @Override
  protected void initialize() {

  }

  @Override
  protected void execute() {
    //extends piston, waits a second, and retracts it
    Robot.pneumatics.extend();
    Timer.delay(1);
    Robot.pneumatics.retract();
    finished = true;
  }

  @Override
  protected boolean isFinished() {
    if (finished) return true;
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
