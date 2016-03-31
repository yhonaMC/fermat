package com.bitdubai.android_core.app.common.version_1.util.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.enums.FermatApps;
import com.bitdubai.fermat_api.layer.all_definition.enums.Platforms;
import com.bitdubai.fermat_api.layer.osa_android.broadcaster.BroadcasterType;
<<<<<<< HEAD
=======
import com.bitdubai.fermat_api.layer.osa_android.broadcaster.FermatBundle;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86


/**
 * Created by mati on 2016.02.02..
 */
public interface BroadcasterInterface {

    void publish(BroadcasterType broadcasterType, String code);

    void publish(BroadcasterType broadcasterType,String appCode ,String code);

    void publish(BroadcasterType broadcasterType, String code,Platforms lauchedPlatform);

    void publish(BroadcasterType broadcasterType, String code,FermatApps fermatApp);

<<<<<<< HEAD
=======
    void publish(BroadcasterType broadcasterType, String appCode, FermatBundle bundle);

    void publish(BroadcasterType broadcasterType, FermatBundle bundle);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
}
