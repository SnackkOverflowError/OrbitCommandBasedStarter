package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Victor;

/**
 * Add your docs here.
 */
public class DrivetrainSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //private Victor motorLeft = new Victor(1);
  //private Victor motorRight = new Victor(2);

  public WPI_TalonSRX talonL;
  public WPI_TalonSRX talonR;

  public WPI_VictorSPX victorL;
  public WPI_VictorSPX victorR;

  public DrivetrainSubsystem(int masterL, int masterR, int slaveL, int slaveR) {

    System.out.print("Init");

    //distanceSensor = new AnalogInput(Distance);

    this.talonL = new WPI_TalonSRX(masterL);
    this.talonR = new WPI_TalonSRX(masterR);
    talonR.configFactoryDefault();
    talonL.configFactoryDefault();

    talonL.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated,LimitSwitchNormal.Disabled);
    talonL.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated,LimitSwitchNormal.Disabled);

    talonR.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated,LimitSwitchNormal.Disabled);
    talonR.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated,LimitSwitchNormal.Disabled);
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
  //Drive function
  public void drive(double speed, double turn){
    // Setting motors
    //motorLeft.set(speed + turn);
    //motorRight.set(speed + turn);
    talonL.set(ControlMode.PercentOutput,speed - turn);
    talonR.set(ControlMode.PercentOutput, speed + turn);
  }

  

@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
    setDefaultCommand(new DriveCommand());
  }

}