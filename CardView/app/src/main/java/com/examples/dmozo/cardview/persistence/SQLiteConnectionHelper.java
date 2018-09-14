package com.examples.dmozo.cardview.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.examples.dmozo.cardview.utils.DbUtilities;

public class SQLiteConnectionHelper extends SQLiteOpenHelper {


    public SQLiteConnectionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DbUtilities.CREATE_TABLE_PRODUCTS);
        sqLiteDatabase.execSQL(DbUtilities.INSERT_PRODUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DbUtilities.DROP_TABLE_PRODUCTS);
        onCreate(sqLiteDatabase);
    }
}
