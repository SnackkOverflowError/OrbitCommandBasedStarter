package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;
  public static DrivetrainSubsystem drive;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    public static final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem(
        RobotMap.DRIVETRAIN_CAN_ID_LEFT_FRONT_MASTER,
    RobotMap.DRIVETRAIN_CAN_ID_RIGHT_FRONT_MASTER,
    RobotMap.DRIVETRAIN_CAN_ID_LEFT_REAR_SLAVE,
    RobotMap.DRIVETRAIN_CAN_ID_RIGHT_REAR_SLAVE);
  }
  

  @Override
  public void robotPeriodic() {
  }
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }


  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

 
  @Override
  public void testPeriodic() {
  }
}