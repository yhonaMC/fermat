package com.mati.fermat_preference_settings.drawer.dialog;

import android.content.Context;
<<<<<<< HEAD
=======
import android.graphics.drawable.Drawable;
import android.os.Build;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.bitdubai.fermat_android_api.ui.adapters.FermatAdapter;
import com.mati.fermat_preference_settings.R;
import com.mati.fermat_preference_settings.drawer.holders.SettingsTextPlusRadioHolder;
import com.mati.fermat_preference_settings.drawer.interfaces.DialogCallback;
import com.mati.fermat_preference_settings.drawer.models.PreferenceSettingsTextPlusRadioItem;

import java.util.List;

/**
 * Created by mati on 2016.02.08..
 */
public class ContextMenuAdapter extends FermatAdapter<PreferenceSettingsTextPlusRadioItem,SettingsTextPlusRadioHolder> {

    private DialogCallback callBack;

    protected ContextMenuAdapter(Context context) {
        super(context);
    }

    protected ContextMenuAdapter(Context context,DialogCallback dialogCallback, List<PreferenceSettingsTextPlusRadioItem> dataSet) {
        super(context, dataSet);
        this.callBack = dialogCallback;
    }

    @Override
    protected SettingsTextPlusRadioHolder createHolder(View itemView, int type) {
        return new SettingsTextPlusRadioHolder(itemView,type);
    }

    @Override
    protected int getCardViewResource() {
        return R.layout.context_menu_row;
    }

    @Override
    protected void bindHolder(SettingsTextPlusRadioHolder holder, final PreferenceSettingsTextPlusRadioItem data, final int position) {
        holder.getRadio().setText(data.getText());
        holder.getRadio().setChecked(data.isRadioTouched());

        holder.getRadio().setOnClickListener(new CompoundButton.OnClickListener() {

            @Override
            public void onClick(View view) {
                 clearNotSelectedRadioButton(position,view);
                 callBack.optionSelected(data,position);
            }
        });
    }

    private void clearNotSelectedRadioButton(int positionSelected,View view){
        for (int i = 0; i < getItemCount(); i++) {
            if(i!=positionSelected){
                getItem(i).setIsRadioTouched(false);
                ((RadioButton)view).setChecked(false);
<<<<<<< HEAD
=======
                Drawable icon;
                icon =  context.getResources().getDrawable(android.R.drawable.radiobutton_off_background);
                ((RadioButton)view).setCompoundDrawablesRelative(null, null, icon, null);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
            }
            else
            {
                getItem(i).setIsRadioTouched(true);
                ((RadioButton)view).setChecked(true);
<<<<<<< HEAD
=======

                Drawable icon;
                icon =  context.getResources().getDrawable(android.R.drawable.radiobutton_on_background);
                ((RadioButton)view).setCompoundDrawablesRelative(null,null,icon,null);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
            }
        }
    }

}
