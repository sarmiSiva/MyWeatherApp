package com.example.myweatherapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract

val dbname ="userDB"
val factory =null
val version =1

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,dbname,factory, version)
{
    /*
    companion object{
        internal val dbname ="userDB"
        internal val factory =null
        internal val version =1
    }
    */


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(30),email varchar(100),password varchar(20))")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    //crete Insert Sql statement

    fun insertUserData(name:String ,email:String,password:String){
        val db:SQLiteDatabase =writableDatabase
        val values:ContentValues= ContentValues()

        values.put("name",name)
        values.put("email",email)
        values.put("password",password)

        db.insert("user",null,values)
        db.close()
    }

    //crete select Sql statement for find user name password

    fun userPresent(email:String,password:String):Boolean{
        val db=writableDatabase

        val query="SELECT * FROM user WHERE email=$email and password =$password"

        val cursor =db.rawQuery(query,null)

        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
    //crete select Sql statement for find user name password

    fun resetPassword(email:String,password:String):Boolean{
        val db=writableDatabase
        /*UPDATE table_name
        SET column1 = value1, column2 = value2, ...
        WHERE condition*/
        val query="UPDATE user SET password=$password WHERE email=$email"

        val cursor =db.rawQuery(query,null)

        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

}

