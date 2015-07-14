package unit.com.bitdubai.fermat_dmp_plugin.layer.basic_wallet.bitcoin_wallet.developer.bitdubai.version_1.structure.BitcoinWalletBasicWalletDao;

import com.bitdubai.fermat_api.layer.dmp_basic_wallet.bitcoin_wallet.enums.BalanceType;
import com.bitdubai.fermat_api.layer.dmp_basic_wallet.bitcoin_wallet.exceptions.CantRegisterDebitDebitException;
import com.bitdubai.fermat_api.layer.dmp_basic_wallet.bitcoin_wallet.interfaces.BitcoinWalletTransactionRecord;
import com.bitdubai.fermat_api.layer.osa_android.database_system.Database;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTable;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableRecord;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTransaction;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantLoadTableToMemoryException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.DatabaseTransactionFailedException;
import com.bitdubai.fermat_dmp_plugin.layer.basic_wallet.bitcoin_wallet.developer.bitdubai.version_1.structure.BitcoinWalletBasicWalletDao;
import com.bitdubai.fermat_dmp_plugin.layer.basic_wallet.bitcoin_wallet.developer.bitdubai.version_1.structure.BitcoinWalletDatabaseConstants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import unit.com.bitdubai.fermat_dmp_plugin.layer.basic_wallet.bitcoin_wallet.developer.bitdubai.version_1.structure.mocks.MockBitcoinWalletTransactionRecord;
import unit.com.bitdubai.fermat_dmp_plugin.layer.basic_wallet.bitcoin_wallet.developer.bitdubai.version_1.structure.mocks.MockDatabaseTableRecord;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by jorgegonzalez on 2015.07.14..
 */
@RunWith(MockitoJUnitRunner.class)
public class AddDebitTest {

    @Mock
    private Database mockDatabase;
    @Mock
    private DatabaseTable mockWalletTable;
    @Mock
    private DatabaseTable mockBalanceTable;
    @Mock
    private DatabaseTransaction mockTransaction;

    private List<DatabaseTableRecord> mockRecords;

    private DatabaseTableRecord mockBalanceRecord;

    private DatabaseTableRecord mockWalletRecord;

    private BitcoinWalletTransactionRecord mockTransactionRecord;

    private BitcoinWalletBasicWalletDao testWalletDao;

    @Before
    public void setUpWalletDao(){
        testWalletDao = new BitcoinWalletBasicWalletDao(mockDatabase);
    }

    @Before
    public void setUpMocks(){
        mockTransactionRecord = new MockBitcoinWalletTransactionRecord();
        mockBalanceRecord = new MockDatabaseTableRecord();
        mockWalletRecord = new MockDatabaseTableRecord();
        mockRecords = new ArrayList<>();
        mockRecords.add(mockBalanceRecord);
        setUpMockitoRules();
    }

    public void setUpMockitoRules(){
        when(mockDatabase.getTable(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_TABLE_NAME)).thenReturn(mockWalletTable);
        when(mockDatabase.getTable(BitcoinWalletDatabaseConstants.BITCOIN_WALLET_BALANCE_TABLE_NAME)).thenReturn(mockBalanceTable);
        when(mockBalanceTable.getRecords()).thenReturn(mockRecords);
        when(mockWalletTable.getEmptyRecord()).thenReturn(mockWalletRecord);
        when(mockDatabase.newTransaction()).thenReturn(mockTransaction);
    }

    @Test
    public void AddDebit_TransactionExecuted_NoExceptions() throws Exception{
        addDebitNoExceptions(BalanceType.BOOK);
        addDebitNoExceptions(BalanceType.AVAILABLE);
    }

    @Test
    public void AddDebit_TransactionInTable_ThrowsCantRegisterCreditException() throws Exception{
        mockRecords.clear();
        mockRecords.add(mockWalletRecord);
        when(mockWalletTable.getRecords()).thenReturn(mockRecords);

        addDebitAndCatchException(BalanceType.BOOK);
        addDebitAndCatchException(BalanceType.AVAILABLE);
    }


    @Test
    public void AddDebit_CantGetBalanceRecordException_ThrowsCantRegisterCreditException() throws Exception{
        doThrow(new CantLoadTableToMemoryException("MOCK", null, null, null)).when(mockBalanceTable).loadToMemory();

        addDebitAndCatchException(BalanceType.BOOK);
        addDebitAndCatchException(BalanceType.AVAILABLE);
    }

    @Test
    public void AddDebit_CantExecuteBitconTransactionException_ThrowsCantRegisterCreditException() throws Exception{
        doThrow(new DatabaseTransactionFailedException("MOCK", null, null, null)).when(mockDatabase).executeTransaction(mockTransaction);

        addDebitAndCatchException(BalanceType.BOOK);
        addDebitAndCatchException(BalanceType.AVAILABLE);
    }

    private void addDebitNoExceptions(final BalanceType balanceType) throws Exception{
        catchException(testWalletDao).addDebit(mockTransactionRecord, balanceType);
        assertThat(caughtException()).isNull();
    }

    private void addDebitAndCatchException(final BalanceType balanceType) throws Exception {
        catchException(testWalletDao).addDebit(mockTransactionRecord, balanceType);
        assertThat(caughtException())
                .isNotNull()
                .isInstanceOf(CantRegisterDebitDebitException.class);
    }

}