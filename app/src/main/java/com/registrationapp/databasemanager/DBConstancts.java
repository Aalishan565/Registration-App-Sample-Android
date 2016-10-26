package com.registrationapp.databasemanager;

/**
 * Created by aalishan on 9/3/16.
 */
public class DBConstancts {
    public static final int DATABASE_VERSION = 1;
    public static final String DBNAME = "RegisrtrationAppDB";
    //Table Names
    public static final String TABLE_USER_INFO = "UserProfile";
    //Coloumn Names
    public static final String COLOUMN_FNAME = "firstName";
    public static final String COLOUMN_LNAME = "lastName";
    public static final String COLOUMN_MOBILENO = "mobileNo";
    public static final String COLOUMN_EMAIL = "emailID";
    public static final String COLOUMN_USERNAME = "userName";
    public static final String COLOUMN_PWD = "password";
    //Query to create database
    public static final String CREATE_TABLE_USERPROFILE = "CREATE TABLE " + TABLE_USER_INFO
            + " ( " + COLOUMN_FNAME + " TEXT,"
            + COLOUMN_LNAME + " TEXT,"
            + COLOUMN_MOBILENO + " TEXT,"
            + COLOUMN_EMAIL + " TEXT,"
            + COLOUMN_USERNAME + " TEXT, "
            + COLOUMN_PWD + " TEXT" + " )";

    // "CREATE TABLE " + TABLE_EVENT + "(" + NAME + " TEXT," + NOTE + " TEXT," + DATE + " TEXT," + EVENT + " TEXT" + ")";


}
