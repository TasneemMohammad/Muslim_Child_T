package com.example.l;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


    public class DataBase extends SQLiteOpenHelper {
        public static final String DB_NAME = " quraan_db ";
        public static final int DB_VERSION = 1;
        public static final String QURAAN_TABLE_NAME = "quraan";
        public static final String QURAAN_COLUMN_SORA = "name of sora";
        public static final String QURAAN_COLUMN_ID_IMG = "id ";
        public DataBase(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + QURAAN_TABLE_NAME + "(" + QURAAN_TABLE_NAME + "TEXT," + QURAAN_COLUMN_ID_IMG + "INTEGER )");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + QURAAN_TABLE_NAME);
            onCreate(db);
        }

        public boolean insertquraan(QuranDataBase quraanDataBase) {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(QURAAN_COLUMN_SORA, quraanDataBase.getName());
            contentValues.put(QURAAN_COLUMN_ID_IMG, quraanDataBase.getImg());
            long result = sqLiteDatabase.insert("QURAAN_TABLE_NAME", null, contentValues);
            return result != -1;

            // if (result == -1)
            //  return false;
            //else return true;
        }

        public ArrayList<QuranDataBase> getAllQuran() {
            ArrayList<QuranDataBase> Quraa_card = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + QURAAN_TABLE_NAME, null);
            if ((cursor != null) && cursor.moveToFirst()) {
                do {
                    String name;
                    int img;
                    name = cursor.getString(cursor.getColumnIndex("QURAAN_COLUMN_SORA"));
                    img = cursor.getInt(cursor.getColumnIndex("QURAAN_COLUMN_ID_IMG"));
                    QuranDataBase quraanDataBase = new QuranDataBase(name, img);
                    Quraa_card.add(quraanDataBase);
                    cursor.close();

                } while (cursor.moveToNext());
            }
            return Quraa_card;
        }
        /*

         */

    }

