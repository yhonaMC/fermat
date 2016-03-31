package com.bitdubai.fermat_api.layer.osa_android.broadcaster;

/**
 * Created by mati on 2016.02.02..
 */
public interface AndroidCoreUtils {


    void publish(BroadcasterType broadcasterType, String code);

    void publish(BroadcasterType broadcasterType, String appCode, String code);
<<<<<<< HEAD
=======

    void publish(BroadcasterType broadcasterType, String appCode, FermatBundle bundle);

    void publish(BroadcasterType broadcasterType, FermatBundle bundle);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
}
