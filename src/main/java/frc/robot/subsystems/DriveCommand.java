package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // Robot.drive.drive(speed,turn):

    if(Robot.m_oi.getTriggerLeft() == 0)
    {
      Robot.drive.drive(-Robot.m_oi.getTriggerLeft(), Robot.m_oi.getJoyStickLeft());
    }
    else{
      Robot.drive.drive(Robot.m_oi.getTriggerRight(), Robot.m_oi.getJoyStickLeft());
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}