/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

public class DriveSystem extends Subsystem {
  private Spark l_front = new Spark(RobotMap.LEFTFRONT);
  private Spark l_back = new Spark(RobotMap.LEFTBACK);
  private Spark r_front = new Spark(RobotMap.RIGHTFRONT);
  private Spark r_back = new Spark(RobotMap.RIGHTBACK);

  private SpeedControllerGroup l_motors = new SpeedControllerGroup(l_front, l_back);
  private SpeedControllerGroup r_motors = new SpeedControllerGroup(r_front, r_back);

  private DifferentialDrive mdrive = new DifferentialDrive(l_motors, r_motors);

  public DriveSystem() {
    
  }

  
  private double ramp(double inputAxis, double power) {
    return Math.pow(inputAxis, power);
  }
  

  public void driveRobot(double speed, double rotation, double scale) {
      mdrive.curvatureDrive(ramp(speed, 3) * scale, ramp(rotation, 3) * (-scale), true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}
