package us.ilite.robot;

import com.flybotix.hfr.codex.Codex;
import types.EDriveData;
import types.EGyro;

public class Data {

    public Codex<Double, EGyro> imu = Codex.of.thisEnum(EGyro.class);
    public Codex<Double, EDriveData> drive = Codex.of.thisEnum(EDriveData.class);

   public Data simulated() {
       imu = Codex.of.thisEnum(EGyro.class);
       drive = Codex.of.thisEnum(EDriveData.class);
       return this;
   }

}
