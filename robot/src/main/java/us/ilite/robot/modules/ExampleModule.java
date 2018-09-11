package us.ilite.robot.modules;

import com.flybotix.hfr.util.log.ILog;
import com.flybotix.hfr.util.log.Logger;

public class ExampleModule extends Module {

    ILog mLog = Logger.createLog(ExampleModule.class);

    @Override
    public void powerOnInit(double pNow) {
        mLog.error("POWER ON INIT");
    }

    @Override
    public void modeInit(double pNow) {
        mLog.error("MODE INIT");
    }

    @Override
    public void update(double pNow) {

    }

    @Override
    public void shutdown(double pNow) {

    }

    @Override
    public void checkModule(double pNow) {

    }

}
