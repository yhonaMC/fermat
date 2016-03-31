package com.bitdubai.android_core.app.common.version_1.provisory;

import com.bitdubai.fermat_api.AppsStatus;
import com.bitdubai.fermat_api.layer.all_definition.navigation_structure.enums.FermatAppType;

/**
 * Created by mati on 2016.02.22..
 */
public class FermatInstalledDesktop implements InstalledDesktop {


    @Override
    public String getAppName() {
        return "desktop";
    }

    @Override
    public String getAppPublicKey() {
        return "main_desktop";
    }

    @Override
    public AppsStatus getAppStatus() {
        return AppsStatus.RELEASE;
    }

    @Override
    public FermatAppType getAppType() {
        return FermatAppType.DESKTOP;
    }

    @Override
    public byte[] getAppIcon() {
        return new byte[0];
    }

    @Override
    public int getIconResource() {
        return 0;
    }
<<<<<<< HEAD
=======

    @Override
    public void setBanner(int res) {

    }

    @Override
    public int getBannerRes() {
        return 0;
    }
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
}
