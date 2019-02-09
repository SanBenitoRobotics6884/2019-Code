/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class PneumaticsSubsystem extends Subsystem {
  //Initializing all subsystems and other necessary classes
  public Compressor compressor = new Compressor(RobotMap.COMPRESSOR_PORT);
  public DoubleSolenoid doublesolenoid = new DoubleSolenoid(RobotMap.SOLENOID_PORT1, RobotMap.SOLENOID_PORT2);

  //initializing variables
  public Boolean prev;
  public Boolean currentVal;
  public int toggleInt;

  public PneumaticsSubsystem() {
    //makes compressor work for some reason
    compressor.setClosedLoopControl(true);
  }

  //extends piston when this function is called
  public void extend() {
    doublesolenoid.set(DoubleSolenoid.Value.kForward);
  }
  //retracts piston when this function is called
  public void retract() {
    doublesolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
