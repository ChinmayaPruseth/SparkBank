package com.example.BasicBankingSystem.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.BasicBankingSystem.database.UserParams.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1456,'Chinmaya Pruseth', 'chinmaya@gmail.com','1403','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2146,'Pritam Senapati', 'pritam@gmail.com','0426','8995641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2149,'Biplab Sandha', 'biplab@gmail.com','0347','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7845,'Priya Sharma', 'priya@gmail.com','0737','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3248,'Subhram Patel', 'subhram@gmail.com','7103','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1496,'Shanj Husain', 'shanj@gmail.com','9726','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7136,'Gourab Sethi', 'gourab@gmail.com','7053','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4698,'Rohit Sharma', 'rohit@gmail.com','8036','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7391,'Hardik Pandya', 'hardik@gmail.com','7235','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1597,'Raj Malhotra', 'raj@gmail.com','0538','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(1493,'Riya Sharma', 'riya@gmail.com','0387','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(2486,'Binay Roy', 'binay@gmail.com','8064','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4921,'Rishab panth', 'rishab@gmail.com','0686','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(0169,'Neha Thakur', 'neha@gmail.com','5034','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7036,'Soumya Kumari', 'soumya@gmail.com','7803','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}