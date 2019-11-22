/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Victor clawVictorTop = new Victor(RobotMap.CLAW_PWM_CHANNEL_TOP_MOTOR);
  private Victor clawVictorBottom = new Victor(RobotMap.CLAW_PWM_CHANNEL_BOTTOM_MOTOR);

  private Solenoid clawSolenoidTop = new Solenoid(RobotMap.CLAW_SOLENOID_CHANNEL_TOP_PISTON);
  private Solenoid clawSolenoidBottom = new Solenoid(RobotMap.CLAW_SOLENOID_CHANNEL_BOTTOM_PISTON);

  private DigitalInput cargoSensor = new DigitalInput(RobotMap.CLAW_DIO_CHANNEL_CARGO_DETECT);

  public enum Position {
    OPEN_GENERAL,
    CLOSED,
    OPEN_HATCH
  }

  public void setRollers(double speed) {
    clawVictorTop.set(speed);
    clawVictorBottom.set(speed);
  }

  public void setBottomSolenoid(boolean state) {
    clawSolenoidBottom.set(state);
  }

  public void setTopSolenoid(boolean state) {
    clawSolenoidTop.set(state);
  }

  // public void setClawState(Position pos) {
  //   if(pos == OPEN_GENERAL) {
  //     setTopSolenoid(true);
  //     setBottomSolenoid(true);
  //   }
  //   else if(pos == CLOSED) {
  //     setTopSolenoid(false);
  //     setBottomSolenoid(false);
  //   }
  //   else {
  //     setTopSolenoid(false);
  //     setBottomSolenoid(true);
  //   }
  // }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
