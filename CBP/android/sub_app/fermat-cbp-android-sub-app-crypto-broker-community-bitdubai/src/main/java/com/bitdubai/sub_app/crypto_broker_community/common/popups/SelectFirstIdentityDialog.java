//package com.bitdubai.sub_app.crypto_broker_community.common.popups;
//
//import android.app.Activity;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.bitdubai.fermat_android_api.layer.definition.wallet.views.FermatButton;
//import com.bitdubai.fermat_android_api.layer.definition.wallet.views.FermatTextView;
//import com.bitdubai.fermat_android_api.ui.dialogs.FermatDialog;
//import com.bitdubai.fermat_api.layer.all_definition.settings.exceptions.CantGetSettingsException;
//import com.bitdubai.fermat_api.layer.all_definition.settings.exceptions.CantPersistSettingsException;
//import com.bitdubai.fermat_api.layer.all_definition.settings.exceptions.SettingsNotFoundException;
//import com.bitdubai.fermat_api.layer.all_definition.settings.structure.SettingsManager;
//import com.bitdubai.fermat_cbp_api.layer.sub_app_module.crypto_broker_community.settings.CryptoBrokerCommunitySettings;
//import com.bitdubai.fermat_pip_api.layer.network_service.subapp_resources.SubAppResourcesProviderManager;
//import com.bitdubai.sub_app.crypto_broker_community.R;
//import com.bitdubai.sub_app.crypto_broker_community.session.CryptoBrokerCommunitySubAppSession;
//import com.bitdubai.sub_app.crypto_broker_community.session.SessionConstant;
//
//import java.io.ByteArrayOutputStream;
//
///**
// * Created by Leon Acosta (lnacosta) - (laion.cj91@gmail.com) on 09/01/2015.
// */
//public class SelectFirstIdentityDialog extends FermatDialog<CryptoBrokerCommunitySubAppSession, SubAppResourcesProviderManager> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
//
//    public static final int TYPE_PRESENTATION =1;
//    public static final int TYPE_PRESENTATION_WITHOUT_IDENTITIES =2;
//
//    private final Activity activity;
//    private final int type;
//    private final boolean checkButton;
//
//    /**
//     * UI
//     */
//    private FrameLayout container_john_doe;
//    private FrameLayout container_jane_doe;
//    private FermatTextView txt_title;
//    private ImageView image_banner;
//    private FermatTextView txt_sub_title;
//    private FermatTextView txt_body;
//    private FermatTextView footer_title;
//    private CheckBox checkbox_not_show;
//    private ImageView image_view_left;
//    private ImageView image_view_right;
//    private Button btn_left;
//    private Button btn_right;
//    private FermatButton btn_dismiss;
//
//    /**
//     * Constructor using Session and Resources.
//     *
//     * @param activity
//     * @param fermatSession
//     * @param resources
//     * @param type
//     * @param checkButton
//     */
//    public SelectFirstIdentityDialog(final Activity                           activity     ,
//                                     final CryptoBrokerCommunitySubAppSession fermatSession,
//                                     final SubAppResourcesProviderManager     resources    ,
//                                     final int                                type         ,
//                                     final boolean                            checkButton  ) {
//
//        super(
//                activity     ,
//                fermatSession,
//                resources
//        );
//
//        this.activity    = activity   ;
//        this.type        = type       ;
//        this.checkButton = checkButton;
//    }
//
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        txt_title         = (FermatTextView) findViewById(R.id.txt_title        );
//        image_banner      = (ImageView)      findViewById(R.id.image_banner     );
//        txt_sub_title     = (FermatTextView) findViewById(R.id.txt_sub_title    );
//        txt_body          = (FermatTextView) findViewById(R.id.txt_body         );
//        footer_title      = (FermatTextView) findViewById(R.id.footer_title     );
//        checkbox_not_show = (CheckBox)       findViewById(R.id.checkbox_not_show);
//
//        checkbox_not_show.setChecked(!checkButton);
//
//        switch (type){
//            case TYPE_PRESENTATION:
//                image_view_left = (ImageView) findViewById(R.id.image_view_left);
//                image_view_right = (ImageView) findViewById(R.id.image_view_right);
//                container_john_doe = (FrameLayout) findViewById(R.id.container_john_doe);
//                container_jane_doe = (FrameLayout) findViewById(R.id.container_jane_doe);
//                btn_left = (Button) findViewById(R.id.btn_left);
//                btn_right = (Button) findViewById(R.id.btn_right);
//                setUpListenersPresentation();
//                break;
//            case TYPE_PRESENTATION_WITHOUT_IDENTITIES:
//                btn_dismiss = (FermatButton) findViewById(R.id.btn_dismiss);
//                btn_dismiss.setOnClickListener(this);
//                break;
//        }
//    }
//
//    private void setUpListenersPresentation(){
//        btn_left.setOnClickListener(this);
//        btn_right.setOnClickListener(this);
//        checkbox_not_show.setOnCheckedChangeListener(this);
//    }
//
//    @Override
//    protected int setLayoutId() {
//        switch (type){
//            case TYPE_PRESENTATION:
//                return R.layout.presentation_wallet;
//            case TYPE_PRESENTATION_WITHOUT_IDENTITIES:
//                return R.layout.presentation_wallet_without_identities;
//        }
//        return 0;
//    }
//
//    @Override
//    protected int setWindowFeature() {
//        return Window.FEATURE_NO_TITLE;
//    }
//
//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//
//        if(id == R.id.btn_left){
//            try {
//                getSession().getModuleManager().getCryptoWallet().createIntraUser("John Doe","Available",convertImage(R.drawable.ic_profile_male));
//                getSession().setData(SessionConstant.PRESENTATION_IDENTITY_CREATED, Boolean.TRUE);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            saveSettings();
//            dismiss();
//        }
//        else if(id == R.id.btn_right){
//            try {
//
//                getSession().setData(SessionConstant.PRESENTATION_IDENTITY_CREATED, Boolean.TRUE);
//
//                try {
//                    getSession().getModuleManager().createIntraUser("Jane Doe", "Available", convertImage(R.drawable.img_profile_female));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            saveSettings();
//            dismiss();
//        } else if ( id == R.id.btn_dismiss){
//            saveSettings();
//            dismiss();
//        }
//    }
//
//    private void saveSettings() {
//
//        SettingsManager<CryptoBrokerCommunitySettings> settingsManager = getSession().getModuleManager().getSettingsManager();
//
//        try {
//            CryptoBrokerCommunitySettings bitcoinWalletSettings = settingsManager.loadAndGetSettings(getSession().getAppPublicKey());
//            bitcoinWalletSettings.setIsPresentationHelpEnabled(false);
//            settingsManager.persistSettings(getSession().getAppPublicKey(),bitcoinWalletSettings);
//
//        } catch (CantGetSettingsException e) {
//            e.printStackTrace();
//        } catch (SettingsNotFoundException e) {
//            e.printStackTrace();
//        } catch (CantPersistSettingsException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private byte[] convertImage(final int resImage){
//
//        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), resImage);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,80,stream);
//        return stream.toByteArray();
//    }
//
//    @Override
//    public void onCheckedChanged(final CompoundButton buttonView,
//                                 final boolean        isChecked ) {
//
//        Toast.makeText(activity,String.valueOf(isChecked),Toast.LENGTH_SHORT).show();
//
//        if(isChecked){
//            getSession().setData(SessionConstant.PRESENTATION_SCREEN_ENABLED, Boolean.TRUE );
//        } else {
//            getSession().setData(SessionConstant.PRESENTATION_SCREEN_ENABLED, Boolean.FALSE);
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//
//        saveSettings();
//        super.onBackPressed();
//    }
//}
