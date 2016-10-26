package com.registrationapp.prefrences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ayesha on 23-01-2016.
 */
public class RegistrationPrefrence {
    // Preferences keys
    public static final boolean DEFAULT_BOOLEAN = false;
    public static final String DEFAULT_STRING = null;
    public static final float DEFAULT_FLOAT = 0.0f;
    public static final long DEFAULT_LONG = 0l;
    public static final int DEFAULT_INT = 0;
    public static final String DEFAULT_KEY = "0";

    private final SharedPreferences mSharedPreferences;
    private final SharedPreferences.Editor mSharedPreferencesEditor;

    /**
     * @param context A Context object to allow access to the default
     *                mSharedPreferences object.
     */

    public RegistrationPrefrence(Context context) {
        mSharedPreferences = context.getSharedPreferences("registrationApp", Context.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();
    }

    /**
     * clear all the stored value
     */
    public void clearAllPrefs() {
        mSharedPreferencesEditor.clear();
        mSharedPreferencesEditor.commit();
    }

    /**
     * clear particular stored value
     */
    public void clearParticular(String key) {
        if (mSharedPreferences.contains(key)) {
            mSharedPreferencesEditor.remove(key);
            mSharedPreferencesEditor.commit();
        }
    }

    // Getters methods for SharedPreference.

    /**
     * Gets boolean value from SharedPreference
     *
     * @param key to get the value from the preference file
     * @return boolean true or false
     */

    public boolean
    getBoolean(String key) {
        boolean returnVal = DEFAULT_BOOLEAN;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getBoolean(key, DEFAULT_BOOLEAN);
        }
        return returnVal;
    }

    /**
     * Gets float value from SharedPreference
     *
     * @param key to get the value from the preference file
     * @return float value
     */

    public float getFloat(String key) {
        float returnVal = DEFAULT_FLOAT;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getFloat(key, DEFAULT_FLOAT);
        }
        return returnVal;
    }

    /**
     * Gets int value from SharedPreference
     *
     * @param key to get the value from the preference file
     * @return int value
     */

    public int getInt(String key) {
        int returnVal = DEFAULT_INT;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getInt(key, DEFAULT_INT);
        }
        return returnVal;
    }

    /**
     * Gets int value from SharedPreference
     *
     * @param key          to get the value from the preference file
     * @param defaultvalue if return value is null, then this default value will be
     *                     returned
     * @return int value
     */
    public int getInt(String key, int defaultvalue) {
        int returnVal = DEFAULT_INT;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getInt(key, defaultvalue);
        }
        return returnVal;
    }

    /**
     * Gets long value from SharedPreference
     *
     * @param key to get the value from the preference file
     * @return long value
     */
    public long getLong(String key) {
        long returnVal = DEFAULT_LONG;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getLong(key, DEFAULT_LONG);
        }
        return returnVal;
    }

    /**
     * Gets String value from SharedPreference
     *
     * @param key to get the value from the preference file
     * @return string value
     */

    public String getString(String key) {
        String returnVal = DEFAULT_STRING;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getString(key, DEFAULT_STRING);
        }
        return returnVal;
    }

    /**
     * Gets string value from SharedPreference
     *
     * @param key          to get the value from the preference file
     * @param defaultvalue if return value is null, then this default value will be
     *                     returned
     * @return string value
     */

    public String getString(String key, String defaultvalue) {
        String returnVal = defaultvalue;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getString(key, defaultvalue);
        }
        return returnVal;
    }




    /**
     * Gets string value from SharedPreference
     *
     * @param key to get the value from the preference file
     * @return string value
     */

    public String getKeyString(String key) {
        String returnVal = DEFAULT_STRING;
        if (mSharedPreferences != null) {
            returnVal = mSharedPreferences.getString(key, DEFAULT_KEY);
        }
        return returnVal;
    }

    // Setters methods for SharedPreference.

    /**
     * Sets boolean value into shared preference
     *
     * @param key   to set the value into preference file
     * @param value value to insert
     */

    public void addOrUpdateBoolean(String key, boolean value) {
        synchronized (this) {
            if (mSharedPreferencesEditor != null) {
                mSharedPreferencesEditor.putBoolean(key, value);
                mSharedPreferencesEditor.commit();
            }
        }
    }

    /**
     * Sets float value into shared preference
     *
     * @param key   to set the value into preference file
     * @param value value to insert
     */

    public void addOrUpdateFloat(String key, float value) {
        synchronized (this) {
            if (mSharedPreferencesEditor != null) {
                mSharedPreferencesEditor.putFloat(key, value);
                mSharedPreferencesEditor.commit();
            }
        }
    }

    /**
     * Sets integer value into shared preference
     *
     * @param key   to set the value into preference file
     * @param value value to insert
     */

    public void addOrUpdateInt(String key, int value) {
        synchronized (this) {
            if (mSharedPreferencesEditor != null) {
                mSharedPreferencesEditor.putInt(key, value);
                mSharedPreferencesEditor.commit();
            }
        }
    }

    /**
     * Sets long value into shared preference
     *
     * @param key   to set the value into preference file
     * @param value value to insert
     */

    public void addOrUpdateLong(String key, long value) {
        synchronized (this) {
            if (mSharedPreferencesEditor != null) {
                mSharedPreferencesEditor.putLong(key, value);
                mSharedPreferencesEditor.commit();
            }
        }
    }

    /**
     * Sets string value into shared preference
     *
     * @param key   to set the value into preference file
     * @param value value to insert
     */

    public void addOrUpdateString(String key, String value) {
        synchronized (this) {
            if (mSharedPreferencesEditor != null) {
                mSharedPreferencesEditor.putString(key, value);
                mSharedPreferencesEditor.commit();
            }
        }
    }

    /**
     * Deletes the preference values into shared preference
     *
     * @param key to delete value
     */

    public void delete(String key) {
        synchronized (this) {
            if (mSharedPreferencesEditor != null) {
                mSharedPreferencesEditor.remove(key);
                mSharedPreferencesEditor.commit();
            }
        }
    }

}
