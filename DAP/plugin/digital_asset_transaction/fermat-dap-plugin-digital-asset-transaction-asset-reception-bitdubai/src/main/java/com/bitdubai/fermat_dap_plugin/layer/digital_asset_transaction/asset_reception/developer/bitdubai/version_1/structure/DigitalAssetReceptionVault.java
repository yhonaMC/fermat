package com.bitdubai.fermat_dap_plugin.layer.digital_asset_transaction.asset_reception.developer.bitdubai.version_1.structure;

import com.bitdubai.fermat_api.layer.all_definition.enums.Actors;
import com.bitdubai.fermat_api.layer.all_definition.transaction_transference_protocol.crypto_transactions.CryptoTransaction;
import com.bitdubai.fermat_api.layer.osa_android.file_system.PluginFileSystem;
import com.bitdubai.fermat_dap_api.layer.all_definition.digital_asset.DigitalAssetMetadata;
import com.bitdubai.fermat_dap_api.layer.all_definition.enums.DAPTransactionType;
import com.bitdubai.fermat_dap_api.layer.all_definition.exceptions.CantSetObjectException;
import com.bitdubai.fermat_dap_api.layer.dap_actor.asset_issuer.exceptions.CantGetAssetIssuerActorsException;
import com.bitdubai.fermat_dap_api.layer.dap_actor.asset_user.exceptions.CantAssetUserActorNotFoundException;
import com.bitdubai.fermat_dap_api.layer.dap_actor.asset_user.exceptions.CantGetAssetUserActorsException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.interfaces.AbstractDigitalAssetVault;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.exceptions.CantRegisterCreditException;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_issuer_wallet.exceptions.CantRegisterDebitException;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.asset_user_wallet.interfaces.AssetUserWalletManager;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.common.enums.BalanceType;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.common.enums.TransactionType;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.common.exceptions.CantGetTransactionsException;
import com.bitdubai.fermat_dap_api.layer.dap_wallet.common.exceptions.CantLoadWalletException;
import com.bitdubai.fermat_pip_api.layer.platform_service.error_manager.interfaces.ErrorManager;

import java.util.UUID;

/**
 * Created by Manuel Perez (darkpriestrelative@gmail.com) on 09/10/15.
 */
public class DigitalAssetReceptionVault extends AbstractDigitalAssetVault {

    ErrorManager errorManager;

    public DigitalAssetReceptionVault(UUID pluginId,
                                      PluginFileSystem pluginFileSystem,
                                      ErrorManager errorManager,
                                      AssetUserWalletManager assetUserWalletManager) throws CantSetObjectException {
        setPluginFileSystem(pluginFileSystem);
        setPluginId(pluginId);
        setErrorManager(errorManager);
        setAssetUserWalletManager(assetUserWalletManager);
        LOCAL_STORAGE_PATH = "digital-asset-reception/";
    }

    public void setErrorManager(ErrorManager errorManager) throws CantSetObjectException {
        if (errorManager == null) {
            throw new CantSetObjectException("ErrorManager is null");
        }
        this.errorManager = errorManager;
    }

    @Override
    public void updateWalletBalance(DigitalAssetMetadata digitalAssetMetadata, CryptoTransaction genesisTransaction, BalanceType balanceType, TransactionType transactionType, DAPTransactionType dapTransactionType, String externalActorPublicKey, Actors externalActorType, String memo) throws CantLoadWalletException, CantGetTransactionsException, CantRegisterCreditException, CantRegisterDebitException, CantGetAssetIssuerActorsException, CantAssetUserActorNotFoundException, CantGetAssetUserActorsException {
        digitalAssetMetadata.getDigitalAsset().setGenesisAmount(genesisTransaction.getCryptoAmount());
        super.updateWalletBalance(digitalAssetMetadata, genesisTransaction, balanceType, transactionType, dapTransactionType, externalActorPublicKey, externalActorType, memo);
    }
}
