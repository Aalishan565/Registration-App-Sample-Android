package com.registrationapp.databasemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.registrationapp.model.UserInfoDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aalishan on 9/3/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, DBConstancts.DBNAME, null, DBConstancts.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConstancts.CREATE_TABLE_USERPROFILE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ");
        onCreate(db);
    }

    public void addUserProfile(String firstName, String lastName, String mobileNo, String emailId, String mUserName, String pwd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBConstancts.COLOUMN_FNAME, firstName);
        values.put(DBConstancts.COLOUMN_LNAME, lastName);
        values.put(DBConstancts.COLOUMN_MOBILENO, mobileNo);
        values.put(DBConstancts.COLOUMN_EMAIL, emailId);
        values.put(DBConstancts.COLOUMN_USERNAME, mUserName);
        values.put(DBConstancts.COLOUMN_PWD, pwd);
        // Inserting Row
        db.insert(DBConstancts.TABLE_USER_INFO, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public boolean login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + DBConstancts.TABLE_USER_INFO + " WHERE username=? AND password=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public List<UserInfoDto> getUserInfo(String userName) {
        List<UserInfoDto> userInfoDtoList = new ArrayList<UserInfoDto>();
        // Select All Query
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBConstancts.TABLE_USER_INFO + " WHERE username=?", new String[]{userName});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserInfoDto userInfoDto = new UserInfoDto();
                userInfoDto.setFirstname(cursor.getString(0));
                userInfoDto.setLastname(cursor.getString(1));
                userInfoDto.setMobileNo(cursor.getString(2));
                userInfoDto.setEmailId(cursor.getString(3));
                userInfoDtoList.add(userInfoDto);
            } while (cursor.moveToNext());
        }

        // return event list
        return userInfoDtoList;
    }
}
