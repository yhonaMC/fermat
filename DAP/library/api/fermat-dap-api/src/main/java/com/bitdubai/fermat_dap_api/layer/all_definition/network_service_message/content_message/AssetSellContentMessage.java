package com.bitdubai.fermat_dap_api.layer.all_definition.network_service_message.content_message;

import com.bitdubai.fermat_api.layer.all_definition.money.CryptoAddress;
import com.bitdubai.fermat_dap_api.layer.all_definition.digital_asset.DigitalAssetMetadata;
import com.bitdubai.fermat_dap_api.layer.all_definition.enums.AssetSellStatus;
import com.bitdubai.fermat_dap_api.layer.all_definition.enums.DAPMessageType;

import java.util.UUID;

/**
 * Created by Víctor A. Mars M. (marsvicam@gmail.com) on 11/02/16.
 */
public class AssetSellContentMessage implements DAPContentMessage {
    //VARIABLE DECLARATION
    private UUID sellingId;
    private byte[] serializedTransaction;
    private long transactionValue;
    private AssetSellStatus sellStatus;
    private DigitalAssetMetadata assetMetadata;
    private UUID negotiationId;
<<<<<<< HEAD
    private CryptoAddress cryptoVaultAddress;
=======
    private CryptoAddress sellerCryptoAddress;
    private CryptoAddress buyerCryptoAddress;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    //CONSTRUCTORS

    public AssetSellContentMessage() {
    }

<<<<<<< HEAD
    public AssetSellContentMessage(UUID sellingId, byte[] serializedTransaction, AssetSellStatus sellStatus, DigitalAssetMetadata assetMetadata, UUID negotiationId, long transactionValue, CryptoAddress cryptoVaultAddress) {
        this.sellingId = sellingId;
        this.serializedTransaction = serializedTransaction;
        this.sellStatus = sellStatus;
        this.assetMetadata = assetMetadata;
        this.negotiationId = negotiationId;
        this.transactionValue = transactionValue;
        this.cryptoVaultAddress = cryptoVaultAddress;
=======
    public AssetSellContentMessage(UUID sellingId, byte[] serializedTransaction, long transactionValue, AssetSellStatus sellStatus, DigitalAssetMetadata assetMetadata, UUID negotiationId, CryptoAddress sellerCryptoAddress, CryptoAddress buyerCryptoAddress) {
        this.sellingId = sellingId;
        this.serializedTransaction = serializedTransaction;
        this.transactionValue = transactionValue;
        this.sellStatus = sellStatus;
        this.assetMetadata = assetMetadata;
        this.negotiationId = negotiationId;
        this.sellerCryptoAddress = sellerCryptoAddress;
        this.buyerCryptoAddress = buyerCryptoAddress;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    //PUBLIC METHODS

    /**
     * Every content message should have a unique type associate to it.
     *
     * @return {@link DAPMessageType} The message type that corresponds to this content message.
     */
    @Override
    public DAPMessageType messageType() {
        return DAPMessageType.ASSET_SELL;
    }

    //PRIVATE METHODS

    //GETTER AND SETTERS

    public byte[] getSerializedTransaction() {
        return serializedTransaction;
    }

    public AssetSellStatus getSellStatus() {
        return sellStatus;
    }

    public UUID getSellingId() {
        return sellingId;
    }

    public DigitalAssetMetadata getAssetMetadata() {
        return assetMetadata;
    }

    public UUID getNegotiationId() {
        return negotiationId;
    }

    public long getTransactionValue() {
        return transactionValue;
    }

<<<<<<< HEAD
    public CryptoAddress getCryptoVaultAddress() {
        return cryptoVaultAddress;
    }

=======
    public CryptoAddress getSellerCryptoAddress() {
        return sellerCryptoAddress;
    }

    public CryptoAddress getBuyerCryptoAddress() {
        return buyerCryptoAddress;
    }
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    //INNER CLASSES
}
