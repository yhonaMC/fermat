package com.bitdubai.fermat_ccp_api.layer.basic_wallet.loss_protected_wallet.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantCalculateBalanceException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantRegisterCreditException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantRegisterDebitException;

/**
<<<<<<< HEAD
 * Created by ciencias on 7/6/15.
=======
 * Created by Natalia Cortez 03/14/2016
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
 */
public interface BitcoinLossProtectedWalletBalance {

   /*
    * Get the balance of the wallet, the result represents the
    * amount of satoshis the user has.
   */

<<<<<<< HEAD
    long getBalance() throws CantCalculateBalanceException;

    long getBalance(BlockchainNetworkType blockchainNetworkType) throws CantCalculateBalanceException;

=======
    long getBalance(BlockchainNetworkType blockchainNetworkType) throws CantCalculateBalanceException;

 /**
  * Throw the method <code>getTransactionById</code> return wallet available balance for actual exchange rate.
  * @param blockchainNetworkType
  * @param exchangeRate
  * @return
  * @throws CantCalculateBalanceException
  */
   long getBalance(BlockchainNetworkType blockchainNetworkType, long exchangeRate) throws CantCalculateBalanceException;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

    void debit(BitcoinLossProtectedWalletTransactionRecord cryptoTransaction) throws CantRegisterDebitException;

    void credit(BitcoinLossProtectedWalletTransactionRecord cryptoTransaction) throws CantRegisterCreditException;

    void revertCredit(BitcoinLossProtectedWalletTransactionRecord cryptoTransaction) throws CantRegisterCreditException;


}
