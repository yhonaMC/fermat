package com.bitdubai.fermat_dmp_plugin.layer.transaction.incoming_extra_user.developer.bitdubai.version_1.structure;

import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseDataType;

/**
 * Created by Arturo Vallone 25/04/2015
 */
class IncomingExtraUSerDataBaseConstants {
    static final String INCOMING_EXTRA_USER_DATABASE = "IncomingExtraUserDatabase";

    static final String INCOMING_EXTRA_USER_REGISTRY_TABLE_NAME = "IncomingExtraUserRegistry";
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_ID_COLUMN = new ColumnDefinition("Id", DatabaseDataType.STRING, 36,true);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_TRANSACTION_HASH_COLUMN = new ColumnDefinition("TransactionHash", DatabaseDataType.STRING, 64,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_ADDRESS_TO_COLUMN = new ColumnDefinition("AddressTo", DatabaseDataType.STRING, 34,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_CRYPTO_CURRENCY_COLUMN = new ColumnDefinition("CryptoCurrency", DatabaseDataType.STRING, 3,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_CRYPTO_AMOUNT_COLUMN = new ColumnDefinition("CryptoAmount", DatabaseDataType.MONEY, 100,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_ADDRESS_FROM_COLUMN = new ColumnDefinition("AddressFrom", DatabaseDataType.STRING, 34,false);
 //   static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_SPECIALIST_COLUMN = new ColumnDefinition("Specialist", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_CRYPTO_STATUS_COLUMN = new ColumnDefinition("CryptoStatus", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_ACTION_COLUMN = new ColumnDefinition("Action", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_PROTOCOL_STATUS_COLUMN = new ColumnDefinition("ProtocolStatus", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_TRANSACTION_STATUS_COLUMN = new ColumnDefinition("TransactionStatus", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_REGISTRY_TABLE_TIMESTAMP_COLUMN = new ColumnDefinition("Timestamp", DatabaseDataType.LONG_INTEGER, 100,false);

    static final String INCOMING_EXTRA_USER_EVENTS_RECORDED_TABLE_NAME = "IncomingExtraUserEventsRecorded";
    static final ColumnDefinition INCOMING_EXTRA_USER_EVENTS_RECORDED_TABLE_ID_COLUMN = new ColumnDefinition("Id", DatabaseDataType.STRING, 36,true);
    static final ColumnDefinition INCOMING_EXTRA_USER_EVENTS_RECORDED_TABLE_EVENT_COLUMN = new ColumnDefinition("Event", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_EVENTS_RECORDED_TABLE_SOURCE_COLUMN = new ColumnDefinition("Source", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_EVENTS_RECORDED_TABLE_STATUS_COLUMN = new ColumnDefinition("Status", DatabaseDataType.STRING, 10,false);
    static final ColumnDefinition INCOMING_EXTRA_USER_EVENTS_RECORDED_TABLE_TIMESTAMP_COLUMN = new ColumnDefinition("Timestamp", DatabaseDataType.LONG_INTEGER, 100,false);

    static class ColumnDefinition {
        final String columnName;
        final DatabaseDataType columnDataType;
        final int columnDataTypeSize;
        final boolean columnIsPrimaryKey;

        public ColumnDefinition(String columnName, DatabaseDataType columnDataType, int columnDataTypeSize, boolean columnIsPrimaryKey) {
            this.columnName = columnName;
            this.columnDataType = columnDataType;
            this.columnDataTypeSize = columnDataTypeSize;
            this.columnIsPrimaryKey = columnIsPrimaryKey;
        }
    }
}
