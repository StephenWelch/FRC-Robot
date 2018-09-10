package us.ilite.robot;

import com.flybotix.hfr.util.log.ELevel;
import com.flybotix.hfr.util.log.ILog;
import com.flybotix.hfr.util.log.Logger;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import us.ilite.robot.commands.CommandQueue;
import us.ilite.robot.modules.Module;
import us.ilite.robot.modules.ModuleList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Robot extends IterativeRobot {
    
    private ILog mLogger = Logger.createLog(this.getClass());

    private CommandQueue mCommandQueue = new CommandQueue();
    private ModuleList mRunningModules = new ModuleList();

    private Data mData = new Data().simulated();

    @Override
    public void robotInit() {
        Logger.setLevel(ELevel.DEBUG);
        mLogger.info("Robot Init");
        mLogger.info("Is Simulated: " + isSimulation());
        
        // Call power on init for each module
        mRunningModules.powerOnInit(Clock.getCurrentTime());
    }

    // This contains code run in ALL robot modes.
    // It's also important to note that this runs AFTER mode-specific code
    @Override
    public void robotPeriodic() {
        mLogger.info(this.toString());

        Clock.cycleEnded();
    }

    @Override
    public void autonomousInit() {
        mapInputsAndCachedSensors();

        mRunningModules.modeInit(Clock.getCurrentTime());
    }

    @Override
    public void autonomousPeriodic() {
        mapInputsAndCachedSensors();

        mCommandQueue.update(Clock.getCurrentTime());
        mRunningModules.update(Clock.getCurrentTime());
    }

    @Override
    public void teleopInit() {
        mapInputsAndCachedSensors();

        mRunningModules.modeInit(Clock.getCurrentTime());
    }

    @Override
    public void teleopPeriodic() {
        mapInputsAndCachedSensors();

        mRunningModules.update(Clock.getCurrentTime());
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        // Temporary for debugging purposes
        Clock.getCurrentTime();
    }

    @Override
    public void testInit() {

    }

    @Override
    public void testPeriodic() {

    }

    public void mapInputsAndCachedSensors() {

    }

    public String toString() {

        String mRobotMode = "Unknown";
        String mRobotEnabledDisabled = "Unknown";
        double mNow = Timer.getFPGATimestamp();

        if(this.isAutonomous()) {
            mRobotMode = "Autonomous";
        }
        if(this.isOperatorControl()) {
            mRobotMode = "Operator Control";
        }
        if(this.isTest()) {
            mRobotEnabledDisabled = "Test";
        }

        if(this.isEnabled()) {
            mRobotEnabledDisabled = "Enabled";
        }
        if(this.isDisabled()) {
            mRobotEnabledDisabled = "Disabled";
        }

        return String.format("State: %s\tMode: %s\tTime: %s", mRobotEnabledDisabled, mRobotMode, mNow);

    }

}
