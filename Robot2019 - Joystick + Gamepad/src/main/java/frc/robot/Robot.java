/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ElevatorSystem; 
import frc.robot.subsystems.PneumaticsSubsystem;

public class Robot extends TimedRobot {

  Command drive = new Drive();

  OI m_oi = new OI();
  public static DriveSystem drivebase = new DriveSystem();
  public static PneumaticsSubsystem pneumatics = new PneumaticsSubsystem();
  public static ElevatorSystem elevator = new ElevatorSystem();

  /*
  AnalogInput ultrasonic = new AnalogInput(0);
  int scale = 43;
  double scaledVal;
  */


  @Override
  public void robotInit() {
    CameraServer server = CameraServer.getInstance();
    server.startAutomaticCapture(0);
    server.startAutomaticCapture(1);
    server.startAutomaticCapture(2);

  }

  @Override
  public void robotPeriodic() {
    /*
    scaledVal = Math.round(ultrasonic.getAverageVoltage() * scale);
    SmartDashboard.putNumber("Distance: ", scaledVal);
    */
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }


  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
