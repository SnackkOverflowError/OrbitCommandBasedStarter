/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */// controlling this subsystem
  // here. Call these from Commands.

 
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX talonL;
  public WPI_TalonSRX talonR;
  
  public WPI_VictorSPX victorL;
  public WPI_VictorSPX victorR;

  public DriveTrain(int masterL, int masterR, int slaveL, int slaveR/*, int distance*/) {
    System.out.print("Init");

    //distanceSensor = new AnalogInput(distance);

    this.talonL = new WPI_TalonSRX(masterL);
    this.talonR = new WPI_TalonSRX(masterR);
    talonR.configFactoryDefault();
    talonL.configFactoryDefault();
    
    talonL.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);
    talonL.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);

    talonR.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);
    talonR.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled);
    addChild(talonL);
    addChild(talonR);
    

    this.victorL = new WPI_VictorSPX(slaveL);
    this.victorR = new WPI_VictorSPX(slaveR);
    addChild(victorL);
    addChild(victorR);

    this.talonR.setInverted(true); 
    victorR.setInverted(true);
    this.victorL.follow(this.talonL);
    this.victorR.follow(this.talonR);

}

  private void drive(double left, double right) {
    talonR.set(ControlMode.PercentOutput, right);
    talonL.set(ControlMode.PercentOutput, left);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new DriveCommand());
  }
}
