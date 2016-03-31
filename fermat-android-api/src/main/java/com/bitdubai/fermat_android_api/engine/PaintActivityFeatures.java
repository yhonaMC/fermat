package com.bitdubai.fermat_android_api.engine;

import android.graphics.drawable.Drawable;
<<<<<<< HEAD
=======
import android.view.View;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
import android.widget.RelativeLayout;


/**
 * Created by Matias Furszyfer on 2015.09.01..
 */

public interface PaintActivityFeatures {

<<<<<<< HEAD
    public android.support.v7.widget.Toolbar getToolbar();
=======
    android.support.v7.widget.Toolbar getToolbar();

    RelativeLayout getToolbarHeader();
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

    void invalidate();

    void addCollapseAnimation(ElementsWithAnimation elementsWithAnimation);

    void setTabCustomImageView(int position,View view);

    // Esto no deberia estar acá
    public void addDesktopCallBack(DesktopHolderClickCallback desktopHolderClickCallback);

    @Deprecated
    void setActivityBackgroundColor(Drawable drawable);

}
