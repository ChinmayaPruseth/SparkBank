package com.example.BasicBankingSystem.database;

import android.provider.BaseColumns;

public final class TransactionParams {
    private TransactionParams() {}

    public static final class TransactionEntry implements BaseColumns {
        /**Name of database table for pets*/
        public final static String TABLE_NAME = "Transaction_table";

        /**Table Fields*/
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_FROM_NAME = "from_name";
        public final static String COLUMN_TO_NAME = "to_name";
        public final static String COLUMN_AMOUNT = "amount";
        public final static String COLUMN_STATUS = "status";
    }
}
