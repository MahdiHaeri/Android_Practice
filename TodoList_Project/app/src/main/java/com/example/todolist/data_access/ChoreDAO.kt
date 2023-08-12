package com.example.todolist.data_access

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.todolist.models.Chore
import com.example.todolist.models.DATABASE_NAME
import com.example.todolist.models.DATABASE_VERSION
import com.example.todolist.models.KEY_CHORE_ASSIGNED_BY
import com.example.todolist.models.KEY_CHORE_ASSIGNED_TIME
import com.example.todolist.models.KEY_CHORE_ASSIGNED_TO
import com.example.todolist.models.KEY_CHORE_NAME
import com.example.todolist.models.KEY_ID
import com.example.todolist.models.TABLE_NAME
import java.util.Date

class ChoreDAO(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CHORE_TABLE: String = "CREATE TABLE $TABLE_NAME (" +
                "$KEY_ID INTEGER PRIMARY KEY," +
                "$KEY_CHORE_NAME TEXT," +
                "$KEY_CHORE_ASSIGNED_BY TEXT," +
                "$KEY_CHORE_ASSIGNED_TO TEXT," +
                "$KEY_CHORE_ASSIGNED_TIME LONG" +
                ")"

        db?.execSQL(CREATE_CHORE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")

        // create new table
        onCreate(db)
    }


    // CRUD -> Create, Read, Update, Delete

    // Create
    fun createChore(chore: Chore) {
        var db: SQLiteDatabase = writableDatabase
        var values: ContentValues = ContentValues()
        values.put(KEY_CHORE_NAME, chore.getChoreName())
        values.put(KEY_CHORE_ASSIGNED_BY, chore.getAssignedBy())
        values.put(KEY_CHORE_ASSIGNED_TO, chore.getAssignedTo())
        values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

        db.insert(TABLE_NAME, null, values)
        db.close()
        Log.d("DB", "Chore created")
    }

    // Read
    @SuppressLint("Range")
    fun getAChore(chore_id: Int): Chore? {
        var db: SQLiteDatabase = writableDatabase
        var selectQuery: String = "SELECT * FROM $TABLE_NAME WHERE $KEY_ID = $chore_id"
        var cursor = db.rawQuery(selectQuery, null)

        if (cursor != null) {
            cursor.moveToFirst()
            var chore = Chore()
            chore.setChoreName(cursor.getString(cursor.getColumnIndex(KEY_CHORE_NAME)))
            chore.setAssignedBy(cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_BY)))
            chore.setAssignedTo(cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TO)))
            chore.setTimeAssigned(cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME)))

            var dateFormat: java.text.DateFormat = java.text.DateFormat.getDateInstance()
            var formattedDate: String = dateFormat.format(Date(cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME))).time)
            return chore
        }

        return null
    }

    fun readChores(): ArrayList<Chore> {
        var db: SQLiteDatabase = readableDatabase
        var list: ArrayList<Chore> = ArrayList()
        var selectQuery: String = "SELECT * FROM $TABLE_NAME"
        var cursor = db.rawQuery(selectQuery, null)

        if (cursor != null) {
            cursor.moveToFirst()
            do {
                var chore = Chore()
                chore.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)))
                chore.setChoreName(cursor.getString(cursor.getColumnIndex(KEY_CHORE_NAME)))
                chore.setAssignedBy(cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_BY)))
                chore.setAssignedTo(cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TO)))
                chore.setTimeAssigned(cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME)))

                list.add(chore)
            } while (cursor.moveToNext())
        }

        return list
    }

    // Update
    fun updateChore(chore: Chore): Int {
        var db: SQLiteDatabase = writableDatabase
        var values: ContentValues = ContentValues()
        values.put(KEY_CHORE_NAME, chore.getChoreName())
        values.put(KEY_CHORE_ASSIGNED_BY, chore.getAssignedBy())
        values.put(KEY_CHORE_ASSIGNED_TO, chore.getAssignedTo())
        values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

        return db.update(TABLE_NAME, values, "$KEY_ID=?", arrayOf(chore.getId().toString()))
    }

    // Delete
    fun deleteChore(chore_id: Int) {
        var db: SQLiteDatabase = writableDatabase
        db.delete(TABLE_NAME, "$KEY_ID=?", arrayOf(chore_id.toString()))
        db.close()
    }

    fun getChoresCount(): Int {
        var db: SQLiteDatabase = readableDatabase
        var countQuery: String = "SELECT * FROM $TABLE_NAME"
        var cursor = db.rawQuery(countQuery, null)
        return cursor.count
    }
}