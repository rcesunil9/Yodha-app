package com.yodha.gadvasu.Otherdatacls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class Sharepredata {
    public static final String USERID = "USERID";
    public static final String USERNAME = "USERNAME";
    public static final String USEREMAIL = "USEREMAIL";
    public static final String USERMOBILE = "USERMOBILE";
    public static final String GENDER = "GENDER";
    public static final String EDUCATION = "EDUCATION";
    public static final String FARMNAME = "FARMNAME";
    public static final String FARMSIZE = "FARMSIZE";
    public static final String STREET = "STREET";
    public static final String CITY = "CITY";
    public static final String DISTRIC = "DISTRIC";
    public static final String STATE = "STATE";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";


    private static final String PREF_NAME = "Yodha";
    public static final String USER_TOKEN = "USERTOKEN";
    public static final String TOKEN = "TOKEN";
    public static final String COMPLETE_PROFILE = "COMPLETE_PROFILE";
    public static final String HAS_LOGIN = "HAS_LOGIN";


    @SuppressLint("CommitPrefEdits")
    public Sharepredata(Context _context) {
        prefs = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setData(String key, String val) {
        prefs.edit().putString(key, val).apply();
    }

    public void setData(String key, int val) {
        prefs.edit().putInt(key, val).apply();
    }

    public String getData(String key) {
        return prefs.getString(key, "");
    }

    public void setDataamount(String key, double val) {
        prefs.edit().putLong(key, Double.doubleToRawLongBits(val)).apply();
    }

    public double getDoubleDataamount(String key) {
        return Double.longBitsToDouble(prefs.getLong(key, 0));
    }

    public int getIntData(String key) {

        return prefs.getInt(key, 0);
    }


    public void setBooleanData(String key, boolean val) {
        prefs.edit().putBoolean(key, val).apply();
    }

    public boolean getBooleanData(String key) {
        return prefs.getBoolean(key, false);
    }

    public String getToken() {
        String token = prefs.getString(TOKEN, "");
        if (token.isEmpty()) {
            return prefs.getString(USER_TOKEN, "");
        } else {
            return token;
        }
    }

    public void setToken(String token) {
        prefs.edit().putString(TOKEN, token).apply();
    }

    public void Dataclear() {
        prefs.edit().clear().apply();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return prefs.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
