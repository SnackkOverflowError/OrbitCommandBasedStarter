package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;

/**
 * Add your docs here.
 */
public class DrivetrainSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Victor motorLeft = new Victor(1);
  private Victor motorRight = new Victor(2);


  //Drive function
  public void drive(double speed, double turn){

    // Setting motors
    motorLeft.set(speed + turn);
    motorRight.set(speed + turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new DriveCommand());
  }
}