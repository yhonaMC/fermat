package com.mati.fermat_osa_addon_android_broadcaster_system_bitdubai.structure.version_1.structure;

import com.bitdubai.fermat_api.layer.osa_android.broadcaster.AndroidCoreUtils;
import com.bitdubai.fermat_api.layer.osa_android.broadcaster.Broadcaster;
import com.bitdubai.fermat_api.layer.osa_android.broadcaster.BroadcasterType;
<<<<<<< HEAD
=======
import com.bitdubai.fermat_api.layer.osa_android.broadcaster.FermatBundle;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

/**
 * Created by mati on 2016.02.02..
 */
public class AndroidPluginBroadcaster implements Broadcaster{

    AndroidCoreUtils androidCoreBroadcasterUtil;

    public AndroidPluginBroadcaster(AndroidCoreUtils androidCoreBroadcasterUtil) {
        this.androidCoreBroadcasterUtil = androidCoreBroadcasterUtil;
    }

    @Override
    public void publish(BroadcasterType broadcasterType, String code) {
        androidCoreBroadcasterUtil.publish(broadcasterType,code);
    }

    @Override
    public void publish(BroadcasterType broadcasterType, String appCode, String code) {
        androidCoreBroadcasterUtil.publish(broadcasterType,appCode,code);
    }

<<<<<<< HEAD
=======
    @Override
    public void publish(BroadcasterType broadcasterType, String appCode, FermatBundle bundle) {
        androidCoreBroadcasterUtil.publish(broadcasterType,appCode,bundle);
    }

    @Override
    public void publish(BroadcasterType broadcasterType, FermatBundle bundle) {
        androidCoreBroadcasterUtil.publish(broadcasterType,bundle);

    }

>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
}
