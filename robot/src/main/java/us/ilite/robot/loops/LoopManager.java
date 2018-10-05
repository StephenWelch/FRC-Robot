package us.ilite.robot.loops;

import com.flybotix.hfr.util.log.ILog;
import com.flybotix.hfr.util.log.Logger;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.Timer;
import us.ilite.common.config.SystemSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which uses the WPILIB Notifier mechanic to run our Modules on
 * a set time.  Tune loop period to the desired,
 * but monitor CPU usage.
 */
public class LoopManager implements Runnable{
    private ILog mLog = Logger.createLog(LoopManager.class);

    private final double kLoopPeriodSeconds;

    private final Notifier mWpiNotifier;
    private final LoopList mLoopList = new LoopList();
    private final Object mTaskLock = new Object();
    private boolean mIsRunning = false;

    private double mLatestTime = 0d;

    public LoopManager(double pLoopPeriodSeconds) {
        mWpiNotifier = new Notifier(this);
        this.kLoopPeriodSeconds = pLoopPeriodSeconds;
    }

    public void setRunningLoops(Loop ... pLoops) {
        mLoopList.setLoops(pLoops);
    }

    public synchronized void start() {
        if(!mIsRunning) {
            mLog.info("Starting control loop");
            synchronized(mTaskLock) {
                mLatestTime = Timer.getFPGATimestamp();
                mLoopList.update(mLatestTime);
                mIsRunning = true;
            }
            mWpiNotifier.startPeriodic(kLoopPeriodSeconds);
        }
    }

    public synchronized void stop() {
        if(mIsRunning) {
            mLog.info("Stopping control loop");
            mWpiNotifier.stop();
            synchronized(mTaskLock) {
                mIsRunning = false;
                mLatestTime = Timer.getFPGATimestamp();
                mLoopList.shutdown(mLatestTime);
            }
        }
    }

    @Override
    public void run() {
        synchronized(mTaskLock) {
            try {
                if(mIsRunning) {
                    mLatestTime = Timer.getFPGATimestamp();
                    //mapSensors(mLatestTime);
                    mLoopList.loop(mLatestTime);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    private void mapSensors(double pNow) {
    }
}
