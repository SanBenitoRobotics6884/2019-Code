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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class DriveSystem extends Subsystem {
  //instantiates all motors and speed controller groups
  private Spark l_front, l_back, r_front, r_back;
  private SpeedControllerGroup l_motors, r_motors;
  private DifferentialDrive mdrive;

  public DriveSystem() {

    //defines all motors and assigns them to ports
    l_front = new Spark(RobotMap.LEFTFRONT);
    l_back = new Spark(RobotMap.LEFTBACK);
    r_front = new Spark(RobotMap.RIGHTFRONT);
    r_back = new Spark(RobotMap.RIGHTBACK);

    //creates speed controller group for each side of the robot so it can be controlled
    l_motors = new SpeedControllerGroup(l_front, l_back);
    r_motors = new SpeedControllerGroup(r_front, r_back);

    //creates a drive that can be controlled directly with joystick input
    mdrive = new DifferentialDrive(l_motors, r_motors);
  }

  //function that modifies the input from the joystick which makes the robot more controllable at low speeds
  private double ramp(double inputAxis) {
    //cubes the input
    return Math.pow(inputAxis, 3) * 0.4;
  }

  //drives the robot with speed and rotation parameters
  public void driveRobot(double speed, double rotation) {
    mdrive.curvatureDrive(speed * 0.4, rotation * 0.4, true);
    SmartDashboard.putNumber("Ramp", ramp(speed));
  }

  @Override
  public void initDefaultCommand() {
  }
}
