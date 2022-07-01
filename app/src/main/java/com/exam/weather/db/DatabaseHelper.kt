package com.exam.weather.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "CITY_DB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS CITIES(id NUMBER PRIMARY KEY, city_name TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL("DROP TABLE IF EXISTS CITIES");
            onCreate(db);
        }
    }

    fun createCity(cityName: String) {
        val db = writableDatabase
        db.beginTransaction()
        try {
            val values = ContentValues()
            values.put("city_name", cityName)
            db.insertOrThrow("CITIES", null, values)
            db.setTransactionSuccessful()
        } catch (e: Exception) {
            db.endTransaction()
        } finally {
            db.endTransaction()
        }
    }

    fun getRecords(): Cursor? {
        val db = readableDatabase
        return db.rawQuery("SELECT city_name FROM CITIES", null)
    }

    fun nukeTable() {
        val db = writableDatabase
        db.execSQL("DELETE FROM city_name")
    }
}
