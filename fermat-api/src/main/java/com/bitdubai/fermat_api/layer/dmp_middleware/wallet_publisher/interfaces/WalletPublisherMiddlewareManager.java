/*
 * @#WalletPublisherMiddlewareManager.java - 2015
 * Copyright bitDubai.com., All rights reserved.
 * You may not modify, use, reproduce or distribute this software.
 * BITDUBAI/CONFIDENTIAL
 */
package com.bitdubai.fermat_api.layer.dmp_middleware.wallet_publisher.interfaces;


import com.bitdubai.fermat_api.layer.all_definition.enums.WalletCategory;
import com.bitdubai.fermat_api.layer.all_definition.resources_structure.Language;
import com.bitdubai.fermat_api.layer.all_definition.resources_structure.Skin;
import com.bitdubai.fermat_api.layer.all_definition.util.Version;

import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_factory.interfaces.WalletFactoryProject;
import com.bitdubai.fermat_api.layer.dmp_module.wallet_publisher.exceptions.CantGetPublishedComponentInformationException;
import com.bitdubai.fermat_api.layer.dmp_module.wallet_publisher.exceptions.CantPublishComponentException;
import com.bitdubai.fermat_api.layer.dmp_module.wallet_publisher.interfaces.InformationPublishedComponent;

import java.net.URL;
import java.util.List;
import java.util.UUID;

/**
 * The interface <code>com.bitdubai.fermat_api.layer.dmp_middleware.wallet_publisher.interfaces.WalletPublisherMiddlewareManager</code> mark
 * the different between the Wallet Publisher middleware and the Wallet Publisher module when need injected into other plugin
 * <p/>
 * Created by Roberto Requena - (rart3001@gmail.com) on 04/08/15.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public interface WalletPublisherMiddlewareManager{

    /**
     * This method returns the information stored about the all published component
     *
     * @param publisherIdentityPublicKey
     * @return List<InformationPublishedComponentMiddleware>
     * @throws CantGetPublishedComponentInformationException
     */
    public List<InformationPublishedComponent> getPublishedComponents(String publisherIdentityPublicKey) throws CantGetPublishedComponentInformationException;

    /**
     * This method returns the information stored about the all published wallets
     *
     * @param publisherIdentityPublicKey
     * @return List<InformationPublishedComponentMiddleware>
     * @throws CantGetPublishedComponentInformationException
     */
    public List<InformationPublishedComponent> getPublishedWallets(String publisherIdentityPublicKey) throws CantGetPublishedComponentInformationException;

    /**
     * This method returns the information stored about the all published skins
     *
     * @param publisherIdentityPublicKey
     * @return List<InformationPublishedComponentMiddleware>
     * @throws CantGetPublishedComponentInformationException
     */
    public List<InformationPublishedComponent> getPublishedSkins(String publisherIdentityPublicKey) throws CantGetPublishedComponentInformationException;

    /**
     * This method returns the information stored about the published language
     *
     * @param publisherIdentityPublicKey
     * @return List<InformationPublishedComponentMiddleware>
     * @throws CantGetPublishedComponentInformationException
     */
    public List<InformationPublishedComponent>  getPublishedLanguages(String publisherIdentityPublicKey) throws CantGetPublishedComponentInformationException;

    /**
     * This method returns the information stored about the published component with his details
     * like versions, icon, screen shots etc...
     *
     * @param idInformationPublishedComponent
     * @return InformationPublishedComponentMiddleware whit details
     * @throws CantGetPublishedComponentInformationException
     */
    public InformationPublishedComponent getInformationPublishedComponentWithDetails(UUID idInformationPublishedComponent) throws CantGetPublishedComponentInformationException;

    /**
     * This method publishes the skin factory project <code>SkinDescriptorFactoryProject</code> with the skin information in
     * the wallet store and register relevant information of this process.
     *
     * @param skin
     * @param icon
     * @param mainScreenShot
     * @param screenShotDetails
     * @param videoUrl
     * @param observations
     * @param initialWalletVersion
     * @param finalWalletVersion
     * @param initialPlatformVersion
     * @param finalPlatformVersion
     * @param publisherIdentityPublicKey
     * @throws CantPublishComponentException
     */
    public void publishSkin(Skin skin, byte[] icon, byte[] mainScreenShot, List<byte[]> screenShotDetails, URL videoUrl, String observations, Version initialWalletVersion, Version finalWalletVersion, Version initialPlatformVersion, Version finalPlatformVersion, String publisherIdentityPublicKey, String signature) throws CantPublishComponentException;

    /**
     * This method publishes the language factory project <code>LanguageDescriptorFactoryProject</code> with the language information in
     * the wallet store and register relevant information of this process.
     *
     * @param language
     * @param icon
     * @param mainScreenShot
     * @param observations
     * @param initialWalletVersion
     * @param finalWalletVersion
     * @param initialPlatformVersion
     * @param finalPlatformVersion
     * @param publisherIdentityPublicKey
     * @throws CantPublishComponentException
     */
    public void publishLanguage(Language language, byte[] icon, byte[] mainScreenShot, String observations, Version initialWalletVersion, Version finalWalletVersion, Version initialPlatformVersion, Version finalPlatformVersion, String publisherIdentityPublicKey, String signature) throws CantPublishComponentException;

    /**
     * This method publishes the wallet factory project <code>WalletDescriptorFactoryProject</code> with the wallet information in
     * the wallet store and register relevant information of this process.
     *
     * @param walletFactoryProject
     * @param walletCategory
     * @param icon
     * @param mainScreenShot
     * @param screenShotDetails
     * @param videoUrl
     * @param observations
     * @param initialWalletVersion
     * @param finalWalletVersion
     * @param initialPlatformVersion
     * @param finalPlatformVersion
     * @param publisherIdentityPublicKey
     * @throws CantPublishComponentException
     */
    public void publishWallet(WalletFactoryProject walletFactoryProject, WalletCategory walletCategory, byte[] icon, byte[] mainScreenShot, List<byte[]> screenShotDetails, URL videoUrl, String observations, Version initialWalletVersion, Version finalWalletVersion, Version initialPlatformVersion, Version finalPlatformVersion, String publisherIdentityPublicKey, String signature) throws CantPublishComponentException;



}