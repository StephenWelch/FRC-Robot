package us.ilite.robot.modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleList extends Module {

    List<Module> mModules = new ArrayList<>();

    @Override
    public void powerOnInit(double pNow) {
        mModules.forEach(module -> module.powerOnInit(pNow));
    }

    @Override
    public void modeInit(double pNow) {
        mModules.forEach(module -> module.modeInit(pNow));
    }

    @Override
    public void update(double pNow) {
        mModules.forEach(module -> module.update(pNow));
    }

    @Override
    public void shutdown(double pNow) {
        mModules.forEach(module -> module.shutdown(pNow));
    }

    @Override
    public void checkModule(double pNow) {
        mModules.forEach(module -> module.checkModule(pNow));
    }

    public void setModules(Module ... pModules) {
        mModules.clear();
        mModules.addAll(Arrays.asList(pModules));
    }

}
