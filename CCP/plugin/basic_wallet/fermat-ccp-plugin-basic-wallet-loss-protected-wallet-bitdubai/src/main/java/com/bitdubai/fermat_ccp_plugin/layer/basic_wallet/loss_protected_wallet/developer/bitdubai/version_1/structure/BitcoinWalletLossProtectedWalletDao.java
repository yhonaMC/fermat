package com.bitdubai.fermat_ccp_plugin.layer.basic_wallet.loss_protected_wallet.developer.bitdubai.version_1.structure;



import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.layer.all_definition.enums.Actors;

import com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType;
import com.bitdubai.fermat_api.layer.all_definition.exceptions.InvalidParameterException;
import com.bitdubai.fermat_api.layer.all_definition.money.CryptoAddress;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTransaction;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantDeleteRecordException;



import com.bitdubai.fermat_api.layer.osa_android.database_system.Database;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseFilterOperator;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseFilterOrder;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseFilterType;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTable;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableFilter;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableFilterGroup;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableRecord;


import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantLoadTableToMemoryException;

import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantUpdateRecordException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.enums.BalanceType;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.enums.TransactionState;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.enums.TransactionType;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantCalculateBalanceException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantFindTransactionException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantGetActorTransactionSummaryException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantListTransactionsException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantRegisterCreditException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantRegisterDebitException;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.common.exceptions.CantStoreMemoException;
<<<<<<< HEAD
=======
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.loss_protected_wallet.interfaces.BitcoinLossProtectedWalletSpend;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.loss_protected_wallet.interfaces.BitcoinLossProtectedWalletTransaction;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.loss_protected_wallet.interfaces.BitcoinLossProtectedWalletTransactionRecord;
import com.bitdubai.fermat_ccp_api.layer.basic_wallet.loss_protected_wallet.interfaces.BitcoinLossProtectedWalletTransactionSummary;
import com.bitdubai.fermat_ccp_plugin.layer.basic_wallet.loss_protected_wallet.developer.bitdubai.version_1.exceptions.CantExecuteLossProtectedBitcoinTransactionException;
import com.bitdubai.fermat_ccp_plugin.layer.basic_wallet.loss_protected_wallet.developer.bitdubai.version_1.exceptions.CantGetLossProtectedBalanceRecordException;
import com.bitdubai.fermat_ccp_plugin.layer.basic_wallet.loss_protected_wallet.developer.bitdubai.version_1.util.BitcoinLossProtecdWalletTransactionWrapper;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


/**
 * Created by eze on 2015.06.23..
 */
public class BitcoinWalletLossProtectedWalletDao {

    private Database database;

    public BitcoinWalletLossProtectedWalletDao(Database database){
        this.database = database;
    }

    /*
     * getBookBalance must get actual Book Balance of wallet, select record from balances table
     */
    public long getBookBalance() throws CantCalculateBalanceException {
        try{
            return getCurrentBookBalance();
        } catch (CantGetLossProtectedBalanceRecordException exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        } catch (Exception exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

    public long getBookBalance(BlockchainNetworkType blockchainNetworkType) throws CantCalculateBalanceException {
        try{
            return getCurrentBookBalance(blockchainNetworkType);
        } catch (CantGetLossProtectedBalanceRecordException exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        } catch (Exception exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }


    /*
     * getBookBalance must get actual Book Balance of wallet, select record from balances table
     */
    public long getAvailableBalance() throws CantCalculateBalanceException {
        try{
            return getCurrentAvailableBalance();
        } catch (CantGetLossProtectedBalanceRecordException exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        } catch (Exception exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

    public long getAvailableBalance(BlockchainNetworkType blockchainNetworkType) throws CantCalculateBalanceException {
        try{
            return getCurrentAvailableBalance(blockchainNetworkType);
        } catch (CantGetLossProtectedBalanceRecordException exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        } catch (Exception exception){
            throw new CantCalculateBalanceException(CantCalculateBalanceException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

    public List<BitcoinLossProtectedWalletTransaction> listTransactions(BalanceType balanceType,TransactionType transactionType,
                                                           int max,
                                                           int offset) throws CantListTransactionsException {
        try {
            DatabaseTable bitcoinWalletTable = getBitcoinWalletTable();

<<<<<<< HEAD
            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);
            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
            bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);
=======
            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);
            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
            bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            bitcoinWalletTable.setFilterTop(String.valueOf(max));
            bitcoinWalletTable.setFilterOffSet(String.valueOf(offset));

            bitcoinWalletTable.loadToMemory();

            return createTransactionList(bitcoinWalletTable.getRecords());
        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantListTransactionsException("Get List of Transactions", cantLoadTableToMemory, "Error load wallet table ", "");
        } catch (Exception exception){
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

<<<<<<< HEAD
=======
    public List<BitcoinLossProtectedWalletSpend> listTransactionsSpending(UUID transactionId) throws CantListTransactionsException {
        try {
            DatabaseTable bitcoinWalletTable = getBitcoinWalletTable();

            bitcoinWalletTable.addUUIDFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_SPENT_TRANSACTION_ID_COLUMN_NAME, transactionId, DatabaseFilterType.EQUAL);
            bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

            bitcoinWalletTable.loadToMemory();

            List<BitcoinLossProtectedWalletSpend> spendings = new ArrayList<>();

            for(DatabaseTableRecord record : bitcoinWalletTable.getRecords())
            {
                UUID spendId                  = record.getUUIDValue(  BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ID_COLUMN_NAME);
                long amount                = record.getLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_AMOUNT_COLUMN_NAME);
                long timeStamp             = record.getLongValue(  BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME);

                spendings.add(new BitcoinWalletLossProtectedWalletSpend(spendId,transactionId,amount,timeStamp));
            }


            return spendings;

       } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantListTransactionsException("Get List of Transactions", cantLoadTableToMemory, "Error load wallet table ", "");
        } catch (Exception exception){
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    public List<BitcoinLossProtectedWalletTransaction> listTransactionsByActor(final String actorPublicKey,
                                                                  final BalanceType balanceType,
                                                                  final int max,
                                                                  final int offset) throws CantListTransactionsException {
        try {
            DatabaseTable bitcoinWalletTable = getBitcoinWalletTable();

            bitcoinWalletTable.setFilterTop(String.valueOf(max));
            bitcoinWalletTable.setFilterOffSet(String.valueOf(offset));

<<<<<<< HEAD
            bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

            // filter by actor from and actor to (debits and credits related with this actor).
            List<DatabaseTableFilter> tableFilters = new ArrayList<>();
            tableFilters.add(bitcoinWalletTable.getNewFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, DatabaseFilterType.EQUAL, actorPublicKey));
            tableFilters.add(bitcoinWalletTable.getNewFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME, DatabaseFilterType.EQUAL, actorPublicKey));
=======
            bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

            // filter by actor from and actor to (debits and credits related with this actor).
            List<DatabaseTableFilter> tableFilters = new ArrayList<>();
            tableFilters.add(bitcoinWalletTable.getNewFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, DatabaseFilterType.EQUAL, actorPublicKey));
            tableFilters.add(bitcoinWalletTable.getNewFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_COLUMN_NAME, DatabaseFilterType.EQUAL, actorPublicKey));
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            DatabaseTableFilterGroup filterGroup = bitcoinWalletTable.getNewFilterGroup(tableFilters, null, DatabaseFilterOperator.OR);

            bitcoinWalletTable.setFilterGroup(filterGroup);

            bitcoinWalletTable.loadToMemory();
            return createTransactionList(bitcoinWalletTable.getRecords());
        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, cantLoadTableToMemory, "Error loading wallet table ", "");
        } catch (Exception exception){
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Unhandled exception.");
        }
    }

    public List<BitcoinLossProtectedWalletTransaction> listTransactionsByActorAndType(final String actorPublicKey,
                                                                  final BalanceType balanceType,
                                                                  final TransactionType transactionType,
                                                                  final int max,
                                                                  final int offset) throws CantListTransactionsException {
        try {
            DatabaseTable bitcoinWalletTable = getBitcoinWalletTable();

<<<<<<< HEAD
            bitcoinWalletTable.setFilterTop   (String.valueOf(max)   );
            bitcoinWalletTable.setFilterOffSet(String.valueOf(offset));

            bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
=======
            bitcoinWalletTable.setFilterTop(String.valueOf(max));
            bitcoinWalletTable.setFilterOffSet(String.valueOf(offset));

            bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);

            //not reversed
            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME, TransactionState.REVERSED.getCode(), DatabaseFilterType.NOT_EQUALS);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            // filter by actor from or to

            if (transactionType == TransactionType.CREDIT)
<<<<<<< HEAD
                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
            else
                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
=======
                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
            else
                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86


            bitcoinWalletTable.loadToMemory();

            if (createTransactionList(bitcoinWalletTable.getRecords()).size()== 0 && transactionType == TransactionType.CREDIT){
                bitcoinWalletTable.clearAllFilters();
<<<<<<< HEAD
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
=======
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
                bitcoinWalletTable.loadToMemory();
                return createTransactionList(bitcoinWalletTable.getRecords());
            }
            if (createTransactionList(bitcoinWalletTable.getRecords()).size()== 0 && transactionType == TransactionType.DEBIT){
                bitcoinWalletTable.clearAllFilters();
<<<<<<< HEAD
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
=======
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, actorPublicKey, DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
                bitcoinWalletTable.loadToMemory();
                return createTransactionList(bitcoinWalletTable.getRecords());
            }

            return createTransactionList(bitcoinWalletTable.getRecords());

        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, cantLoadTableToMemory, "Error loading wallet table ", "");
        } catch (Exception exception){
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Unhandled exception.");
        }
    }

    public List<BitcoinLossProtectedWalletTransaction> listLastActorTransactionsByTransactionType(BalanceType     balanceType,
                                                                                     TransactionType transactionType,
                                                                                     int             max,
                                                                                     int             offset) throws CantListTransactionsException {
        try {

//            DatabaseTable bitcoinWalletTable = getBitcoinWalletTable();
//
//            String query = "SELECT * FROM " +
<<<<<<< HEAD
//                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_NAME +
//                    " WHERE " +
//                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME +
//                    " = '" +
//                    balanceType.getCode() +
//                    "' AND " +
//                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME +
=======
//                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_NAME +
//                    " WHERE " +
//                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME +
//                    " = '" +
//                    balanceType.getCode() +
//                    "' AND " +
//                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME +
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
//                    " = '" +
//                    transactionType.getCode() +
//                    "' GROUP BY ";
//
//            if (transactionType == TransactionType.CREDIT)
<<<<<<< HEAD
//                query += BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME;
//            else if (transactionType == TransactionType.DEBIT)
//                query += BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME;
//
//            query += " HAVING MAX(" +
//                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME +
//                    ") = " +
//                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME +
=======
//                query += BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME;
//            else if (transactionType == TransactionType.DEBIT)
//                query += BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_COLUMN_NAME;
//
//            query += " HAVING MAX(" +
//                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME +
//                    ") = " +
//                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME +
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
//                    " LIMIT " + max +
//                    " OFFSET " + offset;
//


            DatabaseTable bitcoinWalletTable = getBitcoinWalletTable();

            bitcoinWalletTable.setFilterTop   (String.valueOf(max)   );
            bitcoinWalletTable.setFilterOffSet(String.valueOf(offset));

<<<<<<< HEAD
=======
            //not reversed
            bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME, TransactionState.REVERSED.getCode(), DatabaseFilterType.NOT_EQUALS);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86


            if ( transactionType == TransactionType.CREDIT){
                bitcoinWalletTable.clearAllFilters();
<<<<<<< HEAD
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
=======
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

                bitcoinWalletTable.loadToMemory();
                return createTransactionList(bitcoinWalletTable.getRecords());
            }
            if ( transactionType == TransactionType.DEBIT){
                bitcoinWalletTable.clearAllFilters();
<<<<<<< HEAD
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
=======
                bitcoinWalletTable.addFilterOrder(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, DatabaseFilterOrder.DESCENDING);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);

                bitcoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86


                bitcoinWalletTable.loadToMemory();
                return createTransactionList(bitcoinWalletTable.getRecords());
            }
            return createTransactionList(bitcoinWalletTable.getRecords());

        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, cantLoadTableToMemory, "Error loading wallet table ", "");
        } catch (Exception exception){
            throw new CantListTransactionsException(CantListTransactionsException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Unhandled exception.");
        }
    }

    /*
     * Add a new debit transaction.
     */
    public void addDebit(final BitcoinLossProtectedWalletTransactionRecord transactionRecord, final BalanceType balanceType) throws CantRegisterDebitException {
        try {
            long availableAmount = balanceType.equals(BalanceType.AVAILABLE) ? transactionRecord.getAmount() : 0L;
            long bookAmount = balanceType.equals(BalanceType.BOOK) ? transactionRecord.getAmount() : 0L;
            long availableRunningBalance = calculateAvailableRunningBalance(-availableAmount, transactionRecord.getBlockchainNetworkType());
            long bookRunningBalance = calculateBookRunningBalance(-bookAmount,transactionRecord.getBlockchainNetworkType());

            //todo update if the record exists. The record might exists if many send request are executed so add an else to this If

            if (!isTransactionInTable(transactionRecord.getTransactionId(), TransactionType.DEBIT, balanceType))
                executeTransaction(transactionRecord, TransactionType.DEBIT, balanceType, availableRunningBalance, bookRunningBalance);

        } catch (CantGetLossProtectedBalanceRecordException | CantExecuteLossProtectedBitcoinTransactionException exception) {
            throw new CantRegisterDebitException(CantRegisterDebitException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        } catch (CantLoadTableToMemoryException e) {
            throw new CantRegisterDebitException(CantRegisterDebitException.DEFAULT_MESSAGE, e, null, "Check the cause");
        } catch (Exception exception){
            throw new CantRegisterDebitException(CantRegisterDebitException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

    public void revertCredit(final BitcoinLossProtectedWalletTransactionRecord transactionRecord, final BalanceType balanceType) throws CantRegisterDebitException {
        try {
            long availableAmount = balanceType.equals(BalanceType.AVAILABLE) ? transactionRecord.getAmount() : 0L;
            long bookAmount = balanceType.equals(BalanceType.BOOK) ? transactionRecord.getAmount() : 0L;
            long availableRunningBalance = calculateAvailableRunningBalance(availableAmount, transactionRecord.getBlockchainNetworkType());
            long bookRunningBalance = calculateBookRunningBalance(-bookAmount, transactionRecord.getBlockchainNetworkType());

            DatabaseTableRecord balanceRecord = constructBalanceRecord(availableRunningBalance, bookRunningBalance, transactionRecord.getBlockchainNetworkType());

           //Balance table - add filter by network type,
            DatabaseTable balanceTable = getBalancesTable();
<<<<<<< HEAD
            balanceTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_RUNNING_NETWORK_TYPE, transactionRecord.getBlockchainNetworkType().getCode(), DatabaseFilterType.EQUAL);
=======
            balanceTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_RUNNING_NETWORK_TYPE, transactionRecord.getBlockchainNetworkType().getCode(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            DatabaseTransaction dbTransaction = database.newTransaction();
            dbTransaction.addRecordToUpdate(balanceTable, balanceRecord);

            database.executeTransaction(dbTransaction);


        } catch (CantGetLossProtectedBalanceRecordException exception) {
            throw new CantRegisterDebitException(CantRegisterDebitException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        }    catch (Exception exception){
            throw new CantRegisterDebitException(CantRegisterDebitException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

    /*
     * Add a new Credit transaction.
     */
    public void addCredit(final BitcoinLossProtectedWalletTransactionRecord transactionRecord, final BalanceType balanceType) throws CantRegisterCreditException {
        try{
//            if(!isTransactionInTable(transactionRecord.getTransactionId(), TransactionType.CREDIT, balanceType)) {

                if(isTransactionInTable(transactionRecord.getTransactionId(), TransactionType.CREDIT, balanceType))
                    throw new CantRegisterCreditException(CantRegisterCreditException.DEFAULT_MESSAGE, null, null, "The transaction is already in the database");


                long availableAmount = balanceType.equals(BalanceType.AVAILABLE) ? transactionRecord.getAmount() : 0L;
                long bookAmount = balanceType.equals(BalanceType.BOOK) ? transactionRecord.getAmount() : 0L;
                long availableRunningBalance = calculateAvailableRunningBalance(availableAmount, transactionRecord.getBlockchainNetworkType());
                long bookRunningBalance = calculateBookRunningBalance(bookAmount,transactionRecord.getBlockchainNetworkType());
                executeTransaction(transactionRecord, TransactionType.CREDIT, balanceType, availableRunningBalance, bookRunningBalance);
//            }
        } catch(CantGetLossProtectedBalanceRecordException | CantLoadTableToMemoryException | CantExecuteLossProtectedBitcoinTransactionException exception){
            throw new CantRegisterCreditException(CantRegisterCreditException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        } catch (Exception exception){
            throw new CantRegisterCreditException(CantRegisterCreditException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, "Check the cause");
        }
    }

    public void updateTransactionState(UUID transactionID, TransactionState transactionState) throws CantStoreMemoException, CantFindTransactionException {
        try {
            // create the database objects
            DatabaseTable bitcoinwalletTable = getBitcoinWalletTable();
            /**
             *  I will load the information of table into a memory structure, filter for transaction id
             */
<<<<<<< HEAD
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
=======
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            bitcoinwalletTable.loadToMemory();

            // Read record data and create transactions list
            for(DatabaseTableRecord record : bitcoinwalletTable.getRecords()){
<<<<<<< HEAD
                record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME,transactionState.getCode());
=======
                record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME,transactionState.getCode());
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
                bitcoinwalletTable.updateRecord(record);
            }
        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantFindTransactionException("Transaction Memo Update Error",cantLoadTableToMemory,"Error load Transaction table" + transactionID.toString(), "");

        } catch (CantUpdateRecordException cantUpdateRecord) {
            throw new CantStoreMemoException("Transaction Memo Update Error",cantUpdateRecord,"Error update memo of Transaction " + transactionID.toString(), "");
        } catch(Exception exception){
            throw new CantStoreMemoException(CantStoreMemoException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, null);
        }
    }

    public void updateMemoFiled(UUID transactionID, String memo) throws CantStoreMemoException, CantFindTransactionException {
        try {
            // create the database objects
            DatabaseTable bitcoinwalletTable = getBitcoinWalletTable();
            /**
             *  I will load the information of table into a memory structure, filter for transaction id
             */
<<<<<<< HEAD
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
=======
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            bitcoinwalletTable.loadToMemory();

            // Read record data and create transactions list
            for(DatabaseTableRecord record : bitcoinwalletTable.getRecords()){
<<<<<<< HEAD
                record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_MEMO_COLUMN_NAME,memo);
=======
                record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_MEMO_COLUMN_NAME,memo);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
                bitcoinwalletTable.updateRecord(record);
            }
        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantFindTransactionException("Transaction Memo Update Error",cantLoadTableToMemory,"Error load Transaction table" + transactionID.toString(), "");

        } catch (CantUpdateRecordException cantUpdateRecord) {
            throw new CantStoreMemoException("Transaction Memo Update Error",cantUpdateRecord,"Error update memo of Transaction " + transactionID.toString(), "");
        } catch(Exception exception){
            throw new CantStoreMemoException(CantStoreMemoException.DEFAULT_MESSAGE, FermatException.wrapException(exception), null, null);
        }
    }

    public BitcoinLossProtectedWalletTransactionSummary getActorTransactionSummary(String actorPublicKey,
                                                                      BalanceType balanceType) throws CantGetActorTransactionSummaryException {
        try {
            DatabaseTable bitcoinWalletTable = getBitcoinWalletTable();

            String query = "SELECT COUNT(*), " +
<<<<<<< HEAD
                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME +
                    ", SUM(" +
                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_AMOUNT_COLUMN_NAME +
                    ") FROM " +
                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_NAME +
                    " WHERE " +
                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME +
                    " = '" +
                    balanceType.getCode() +
                    "' AND (" +
                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME +
                    " = '" +
                    actorPublicKey +
                    "' OR " +
                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME +
                    " = '" +
                    actorPublicKey +
                    "') GROUP BY " +
                    BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME;
=======
                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME +
                    ", SUM(" +
                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_AMOUNT_COLUMN_NAME +
                    ") FROM " +
                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_NAME +
                    " WHERE " +
                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME +
                    " = '" +
                    balanceType.getCode() +
                    "' AND (" +
                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME +
                    " = '" +
                    actorPublicKey +
                    "' OR " +
                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_COLUMN_NAME +
                    " = '" +
                    actorPublicKey +
                    "') GROUP BY " +
                    BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME;
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            List<DatabaseTableRecord> records = bitcoinWalletTable.customQuery(query, true);

            int sentTransactionsNumber = 0;

            int receivedTransactionsNumber = 0;

            long sentAmount = 0;

            long receivedAmount = 0;

            for (DatabaseTableRecord record : records) {
                TransactionType transactionType = TransactionType.getByCode(record.getStringValue("Column1"));

                switch (transactionType) {
                    case CREDIT:
                        receivedTransactionsNumber = record.getIntegerValue("Column0");
                        receivedAmount = record.getLongValue("Column2");
                        break;
                    case DEBIT:
                        sentTransactionsNumber = record.getIntegerValue("Column0");
                        sentAmount = record.getLongValue("Column2");

                        break;
                }
            }

            return new BitcoinWalletLossProtectedWalletTransactionSummary(sentTransactionsNumber, receivedTransactionsNumber, sentAmount, receivedAmount);

        } catch (CantLoadTableToMemoryException e) {
            throw new CantGetActorTransactionSummaryException(CantGetActorTransactionSummaryException.DEFAULT_MESSAGE, e,"Error loading Transaction table", "");
        }
    }

    /**
     * We use this method to check if the given transaction is already in the table, we do a query to the table with the specifics of the record
     * and then check if it's not empty
     * @param transactionId
     * @param transactionType
     * @param balanceType
     * @return
     * @throws CantLoadTableToMemoryException if something goes wrong.
     */
    private boolean isTransactionInTable(final UUID transactionId, final TransactionType transactionType, final BalanceType balanceType) throws CantLoadTableToMemoryException {
        DatabaseTable bitCoinWalletTable = getBitcoinWalletTable();
<<<<<<< HEAD
        bitCoinWalletTable.addUUIDFilter(BitcoinLossProtectedWalletDatabaseConstants.BBITCOIN_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME, transactionId, DatabaseFilterType.EQUAL);
        bitCoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
        bitCoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);
=======
        bitCoinWalletTable.addUUIDFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME, transactionId, DatabaseFilterType.EQUAL);
        bitCoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode(), DatabaseFilterType.EQUAL);
        bitCoinWalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME, balanceType.getCode(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
        bitCoinWalletTable.loadToMemory();
        return !bitCoinWalletTable.getRecords().isEmpty();
    }

    private DatabaseTable getBitcoinWalletTable(){
<<<<<<< HEAD
        return database.getTable(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_NAME);
=======
        return database.getTable(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_NAME);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    private long calculateAvailableRunningBalance(final long transactionAmount,BlockchainNetworkType blockchainNetworkType) throws CantGetLossProtectedBalanceRecordException{
        return  getCurrentAvailableBalance(blockchainNetworkType) + transactionAmount;
    }

    private long calculateBookRunningBalance(final long transactionAmount,BlockchainNetworkType blockchainNetworkType) throws CantGetLossProtectedBalanceRecordException{
        return  getCurrentBookBalance(blockchainNetworkType) + transactionAmount;
    }

    private long getCurrentBookBalance() throws CantGetLossProtectedBalanceRecordException {
        return getCurrentBalance(BalanceType.BOOK);
    }
    private long getCurrentBookBalance(BlockchainNetworkType blockchainNetworkType) throws CantGetLossProtectedBalanceRecordException{
        return getCurrentBalance(BalanceType.BOOK, blockchainNetworkType);
    }

    private long getCurrentAvailableBalance() throws CantGetLossProtectedBalanceRecordException{
        return getCurrentBalance(BalanceType.AVAILABLE);
    }
    private long getCurrentAvailableBalance(BlockchainNetworkType blockchainNetworkType) throws CantGetLossProtectedBalanceRecordException{
        return getCurrentBalance(BalanceType.AVAILABLE ,blockchainNetworkType);
    }

    private long getCurrentBalance(final BalanceType balanceType) throws CantGetLossProtectedBalanceRecordException {
        if (balanceType == BalanceType.AVAILABLE)
<<<<<<< HEAD
            return getBalancesRecord().getLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME);
        else
            return getBalancesRecord().getLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME);
=======
            return getBalancesRecord().getLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME);
        else
            return getBalancesRecord().getLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    private long getCurrentBalance(final BalanceType balanceType, BlockchainNetworkType blockchainNetworkType) throws CantGetLossProtectedBalanceRecordException {
        if (balanceType == BalanceType.AVAILABLE)
<<<<<<< HEAD
            return getBalancesRecord(blockchainNetworkType).getLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME);
        else
            return getBalancesRecord(blockchainNetworkType).getLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME);
=======
            return getBalancesRecord(blockchainNetworkType).getLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME);
        else
            return getBalancesRecord(blockchainNetworkType).getLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }


    private DatabaseTableRecord getBalancesRecord() throws CantGetLossProtectedBalanceRecordException{
        try {
            DatabaseTable balancesTable = getBalancesTable();
            balancesTable.loadToMemory();
            return balancesTable.getRecords().get(0);
        } catch (CantLoadTableToMemoryException exception) {
            throw new CantGetLossProtectedBalanceRecordException("Error to get balances record",exception,"Can't load balance table" , "");
        }
    }

    private DatabaseTableRecord getBalancesRecord(BlockchainNetworkType blockchainNetworkType) throws CantGetLossProtectedBalanceRecordException{
        try {
            DatabaseTable balancesTable = getBalancesTable();

<<<<<<< HEAD
            balancesTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_RUNNING_NETWORK_TYPE,blockchainNetworkType.getCode(),DatabaseFilterType.EQUAL);
=======
            balancesTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_RUNNING_NETWORK_TYPE,blockchainNetworkType.getCode(),DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            balancesTable.loadToMemory();
            return balancesTable.getRecords().get(0);
        } catch (CantLoadTableToMemoryException exception) {
            throw new CantGetLossProtectedBalanceRecordException("Error to get balances record",exception,"Can't load balance table" , "");
        }
    }

    private DatabaseTable getBalancesTable(){
<<<<<<< HEAD
        return database.getTable(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_NAME);
=======
        return database.getTable(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_NAME);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
    }

    private void executeTransaction(final BitcoinLossProtectedWalletTransactionRecord transactionRecord, final TransactionType transactionType, final BalanceType balanceType, final long availableRunningBalance, final long bookRunningBalance) throws CantExecuteLossProtectedBitcoinTransactionException {
        try{
            DatabaseTableRecord bitcoinWalletRecord = constructBitcoinWalletRecord(transactionRecord, balanceType,transactionType ,availableRunningBalance, bookRunningBalance);
            DatabaseTableRecord balanceRecord = constructBalanceRecord(availableRunningBalance, bookRunningBalance, transactionRecord.getBlockchainNetworkType());

            BitcoinWalletLossProtectedWalletDaoTransaction bitcoinWalletBasicWalletDaoTransaction = new BitcoinWalletLossProtectedWalletDaoTransaction(database);

            //Balance table - add filter by network type,
            DatabaseTable balanceTable = getBalancesTable();
<<<<<<< HEAD
            balanceTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_RUNNING_NETWORK_TYPE,transactionRecord.getBlockchainNetworkType().getCode(),DatabaseFilterType.EQUAL);
=======
            balanceTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_RUNNING_NETWORK_TYPE,transactionRecord.getBlockchainNetworkType().getCode(),DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
            bitcoinWalletBasicWalletDaoTransaction.executeTransaction(getBitcoinWalletTable(), bitcoinWalletRecord, balanceTable, balanceRecord);
        } catch(CantGetLossProtectedBalanceRecordException | CantLoadTableToMemoryException exception){
            throw new CantExecuteLossProtectedBitcoinTransactionException(CantExecuteLossProtectedBitcoinTransactionException.DEFAULT_MESSAGE, exception, null, "Check the cause");
        }
    }

    /**
     * This method constructs a Table Record using the data from the transactionRecord, the balance type and the runningBalances that have already been calculated
     * @param transactionRecord
     * @param balanceType
     * @param availableRunningBalance
     * @param bookRunningBalance
     * @return
     * @throws CantLoadTableToMemoryException
     */
    private DatabaseTableRecord constructBitcoinWalletRecord(final BitcoinLossProtectedWalletTransactionRecord transactionRecord,
                                                             final BalanceType balanceType,
                                                             final TransactionType transactionType,
                                                             final long availableRunningBalance,
                                                             final long bookRunningBalance) throws CantLoadTableToMemoryException {

        DatabaseTableRecord record = getBitcoinWalletEmptyRecord();

<<<<<<< HEAD
        record.setUUIDValue  (BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ID_COLUMN_NAME                       , UUID.randomUUID());
        record.setUUIDValue  (BitcoinLossProtectedWalletDatabaseConstants.BBITCOIN_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME         , transactionRecord.getTransactionId());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode());
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_AMOUNT_COLUMN_NAME, transactionRecord.getAmount());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_MEMO_COLUMN_NAME, transactionRecord.getMemo());
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, transactionRecord.getTimestamp());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TRANSACTION_HASH_COLUMN_NAME, transactionRecord.getTransactionHash());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ADDRESS_FROM_COLUMN_NAME             , transactionRecord.getAddressFrom().getAddress());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ADDRESS_TO_COLUMN_NAME               , transactionRecord.getAddressTo().getAddress());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME             , balanceType.getCode());
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_AVAILABLE_BALANCE_COLUMN_NAME, availableRunningBalance);
        record.setLongValue  (BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_BOOK_BALANCE_COLUMN_NAME     , bookRunningBalance);
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, transactionRecord.getActorFromPublicKey());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME                 , transactionRecord.getActorToPublicKey());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_TYPE_COLUMN_NAME          , transactionRecord.getActorFromType().getCode());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_TYPE_COLUMN_NAME            , transactionRecord.getActorToType().getCode());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_NETWORK_TYPE                 , transactionRecord.getBlockchainNetworkType().getCode());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME        , TransactionState.COMPLETE.getCode());
=======
        record.setUUIDValue  (BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ID_COLUMN_NAME                       , UUID.randomUUID());
        record.setUUIDValue  (BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME         , transactionRecord.getTransactionId());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME, transactionType.getCode());
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_AMOUNT_COLUMN_NAME, transactionRecord.getAmount());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_MEMO_COLUMN_NAME, transactionRecord.getMemo());
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME, transactionRecord.getTimestamp());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TRANSACTION_HASH_COLUMN_NAME, transactionRecord.getTransactionHash());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ADDRESS_FROM_COLUMN_NAME             , transactionRecord.getAddressFrom().getAddress());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ADDRESS_TO_COLUMN_NAME               , transactionRecord.getAddressTo().getAddress());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME             , balanceType.getCode());
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_RUNNING_AVAILABLE_BALANCE_COLUMN_NAME, availableRunningBalance);
        record.setLongValue  (BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_RUNNING_BOOK_BALANCE_COLUMN_NAME     , bookRunningBalance);
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME, transactionRecord.getActorFromPublicKey());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_COLUMN_NAME                 , transactionRecord.getActorToPublicKey());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_TYPE_COLUMN_NAME          , transactionRecord.getActorFromType().getCode());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_TYPE_COLUMN_NAME            , transactionRecord.getActorToType().getCode());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_RUNNING_NETWORK_TYPE                 , transactionRecord.getBlockchainNetworkType().getCode());
        record.setStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME        , TransactionState.COMPLETE.getCode());
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

        return record;
    }

    private DatabaseTableRecord getBitcoinWalletEmptyRecord() throws CantLoadTableToMemoryException{
        return getBitcoinWalletTable().getEmptyRecord();
    }

    private DatabaseTableRecord constructBalanceRecord(final long availableRunningBalance, final long bookRunningBalance, BlockchainNetworkType blockchainNetworkType) throws CantGetLossProtectedBalanceRecordException{
        DatabaseTableRecord record = getBalancesRecord(blockchainNetworkType);
<<<<<<< HEAD
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME, availableRunningBalance);
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME, bookRunningBalance);
=======
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_AVAILABLE_BALANCE_COLUMN_NAME, availableRunningBalance);
        record.setLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_BALANCE_TABLE_BOOK_BALANCE_COLUMN_NAME, bookRunningBalance);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
        return record;
    }

    // Read record data and create transactions list
    private List<BitcoinLossProtectedWalletTransaction> createTransactionList(final Collection<DatabaseTableRecord> records){

        List<BitcoinLossProtectedWalletTransaction> transactions = new ArrayList<>();

        for(DatabaseTableRecord record : records)
            transactions.add(constructBitcoinWalletTransactionFromRecord(record));

        return transactions;
    }

    private BitcoinLossProtectedWalletTransaction constructBitcoinWalletTransactionFromRecord(final DatabaseTableRecord record){

<<<<<<< HEAD
        UUID transactionId              = record.getUUIDValue(  BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ID_COLUMN_NAME);
        String transactionHash          = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ID_COLUMN_NAME);
        TransactionType transactionType = TransactionType.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TYPE_COLUMN_NAME));
        CryptoAddress addressFrom       = new CryptoAddress();
        addressFrom.setAddress(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ADDRESS_FROM_COLUMN_NAME));
        CryptoAddress addressTo         = new CryptoAddress();
        addressTo.setAddress(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ADDRESS_TO_COLUMN_NAME));
        String actorFromPublicKey       = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME);
        String actorToPublicKey         = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_COLUMN_NAME);
        Actors actorFromType            = Actors.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_FROM_TYPE_COLUMN_NAME));
        Actors actorToType              = Actors.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_ACTOR_TO_TYPE_COLUMN_NAME));
        BalanceType balanceType         = BalanceType.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME));
        long amount                     = record.getLongValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_AMOUNT_COLUMN_NAME);
        long runningBookBalance         = record.getLongValue(  BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_BOOK_BALANCE_COLUMN_NAME);
        long runningAvailableBalance    = record.getLongValue(  BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_AVAILABLE_BALANCE_COLUMN_NAME);
        long timeStamp                  = record.getLongValue(  BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TIME_STAMP_COLUMN_NAME);
        String memo                     = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_MEMO_COLUMN_NAME);
        BlockchainNetworkType blockchainNetworkType = BlockchainNetworkType.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_RUNNING_NETWORK_TYPE));
        TransactionState transactionState = null;
        try {
            transactionState = TransactionState.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.BITCOIN_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME));
=======
        UUID transactionId              = record.getUUIDValue(  BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ID_COLUMN_NAME);
        String transactionHash          = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ID_COLUMN_NAME);
        TransactionType transactionType = TransactionType.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TYPE_COLUMN_NAME));
        CryptoAddress addressFrom       = new CryptoAddress();
        addressFrom.setAddress(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ADDRESS_FROM_COLUMN_NAME));
        CryptoAddress addressTo         = new CryptoAddress();
        addressTo.setAddress(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ADDRESS_TO_COLUMN_NAME));
        String actorFromPublicKey       = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_COLUMN_NAME);
        String actorToPublicKey         = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_COLUMN_NAME);
        Actors actorFromType            = Actors.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_FROM_TYPE_COLUMN_NAME));
        Actors actorToType              = Actors.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_ACTOR_TO_TYPE_COLUMN_NAME));
        BalanceType balanceType         = BalanceType.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_BALANCE_TYPE_COLUMN_NAME));
        long amount                     = record.getLongValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_AMOUNT_COLUMN_NAME);
        long runningBookBalance         = record.getLongValue(  BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_RUNNING_BOOK_BALANCE_COLUMN_NAME);
        long runningAvailableBalance    = record.getLongValue(  BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_RUNNING_AVAILABLE_BALANCE_COLUMN_NAME);
        long timeStamp                  = record.getLongValue(  BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TIME_STAMP_COLUMN_NAME);
        String memo                     = record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_MEMO_COLUMN_NAME);
        BlockchainNetworkType blockchainNetworkType = BlockchainNetworkType.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_RUNNING_NETWORK_TYPE));
        TransactionState transactionState = null;
        try {
            transactionState = TransactionState.getByCode(record.getStringValue(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_TRANSACTION_STATE_COLUMN_NAME));
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }

        return new BitcoinLossProtecdWalletTransactionWrapper(transactionId, transactionHash, transactionType, addressFrom, addressTo,
                actorFromPublicKey, actorToPublicKey, actorFromType, actorToType, balanceType, amount, runningBookBalance, runningAvailableBalance, timeStamp, memo, blockchainNetworkType,transactionState);
    }

    public void deleteTransaction(UUID transactionID)throws CantFindTransactionException{

        try {
            // create the database objects
            DatabaseTable bitcoinwalletTable = getBitcoinWalletTable();
            /**
             *  I will load the information of table into a memory structure, filter for transaction id
             */
<<<<<<< HEAD
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BBITCOIN_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
=======
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            bitcoinwalletTable.loadToMemory();

            // Read record data and create transactions list
            for(DatabaseTableRecord record : bitcoinwalletTable.getRecords()){
                bitcoinwalletTable.deleteRecord(record);
            }
        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantFindTransactionException("Transaction Memo Update Error",cantLoadTableToMemory,"Error load Transaction table" + transactionID.toString(), "");
        } catch (CantDeleteRecordException e) {
            e.printStackTrace();
        }
    }

    public BitcoinLossProtectedWalletTransaction selectTransaction(UUID transactionID)throws CantFindTransactionException{

        try {

            BitcoinLossProtectedWalletTransaction bitcoinWalletTransaction = null;
            // create the database objects
            DatabaseTable bitcoinwalletTable = getBitcoinWalletTable();
            /**
             *  I will load the information of table into a memory structure, filter for transaction id
             */
<<<<<<< HEAD
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.BBITCOIN_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
=======
            bitcoinwalletTable.addStringFilter(BitcoinLossProtectedWalletDatabaseConstants.LOSS_PROTECTED_WALLET_TABLE_VERIFICATION_ID_COLUMN_NAME, transactionID.toString(), DatabaseFilterType.EQUAL);
>>>>>>> 589579dd634da6d0edd4e49f3e34d40384772f86

            bitcoinwalletTable.loadToMemory();

            // Read record data and create transactions list
            for(DatabaseTableRecord record : bitcoinwalletTable.getRecords()){
                bitcoinWalletTransaction = constructBitcoinWalletTransactionFromRecord(record);
            }

            return bitcoinWalletTransaction;
        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            throw new CantFindTransactionException("Select Transaction Data Error",cantLoadTableToMemory,"Error load Transaction table" + transactionID.toString(), "");
        } catch (Exception e) {
            throw new CantFindTransactionException("Select Transaction Data Error",e,"unknown Error" + transactionID.toString(), "");

        }
    }
}