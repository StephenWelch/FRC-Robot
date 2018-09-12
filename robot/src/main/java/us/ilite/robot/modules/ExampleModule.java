package us.ilite.robot.modules;

import com.flybotix.hfr.util.log.ILog;
import com.flybotix.hfr.util.log.Logger;
import edu.wpi.first.wpilibj.Timer;

public class ExampleModule extends Module {

    private static final double kDelaySeconds = 0.1;

    ILog mLog = Logger.createLog(ExampleModule.class);
    Timer mTimer = new Timer();

    @Override
    public void powerOnInit(double pNow) {
        mLog.error("POWER ON INIT");
    }

    @Override
    public void modeInit(double pNow) {
        mLog.error("MODE INIT");

        mTimer.reset();
        mTimer.start();
    }

    @Override
    public void update(double pNow) {

        if(mTimer.hasPeriodPassed(kDelaySeconds)) {
            mLog.error("ON");
            mTimer.reset();
        } else {
            mLog.error("OFF");
        }

    }

    @Override
    public void shutdown(double pNow) {
         mTimer.stop();
    }

    @Override
    public void checkModule(double pNow) {

    }

}
