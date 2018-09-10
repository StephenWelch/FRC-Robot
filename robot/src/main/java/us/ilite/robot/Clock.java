package us.ilite.robot;

import com.flybotix.hfr.util.log.ELevel;
import com.flybotix.hfr.util.log.ILog;
import com.flybotix.hfr.util.log.Logger;
import edu.wpi.first.wpilibj.Timer;

/**
 * @author Stephen Welch
 * Provides a consistent time between cycles.
 * The cycleEnded() method must be called at the end of each robot cycle so we know when to update to the next time.
 */
public class Clock {

    private static ILog mLogger = Logger.createLog(Clock.class);

    private static double mCurrentTime = 0.0;
    private static boolean hasTimeUpdatedThisCycle = false;

    /**
     *
     * @return A cycle-consistent time, in seconds.
     */
    public static double getCurrentTime() {
        if(hasTimeUpdatedThisCycle == false) {
            mCurrentTime = Timer.getFPGATimestamp();
            hasTimeUpdatedThisCycle = true;
            mLogger.info("Updated time to: " + mCurrentTime);
        }

        return mCurrentTime;
    }

    /**
     * Call this to signify the end of a robot cycle and tell the time to update next time it's retrieved.
     */
    public static void cycleEnded() {
        hasTimeUpdatedThisCycle = false;
    }

}
