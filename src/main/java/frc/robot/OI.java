/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //creating controllers
  XboxController driverController = new XboxController(0);
  XboxController operatorController = new XboxController(1);

  public double deadzone(double input, double deadzone)
  {
    if(Math.abs(input) < deadzone)
    {
      return 0;
    }
    else{
      return input;
    }
  }

  public double getTriggerRight()
  {
    return deadzone(driverController.getTriggerAxis(Hand.kRight),0.3);
  }

  public double getTriggerLeft()
  {
    return deadzone(driverController.getTriggerAxis(Hand.kLeft),0.3);
  }

  public double getJoyStickLeft()
  {
    return deadzone(driverController.getX(Hand.kLeft),0.2);
  }
}
