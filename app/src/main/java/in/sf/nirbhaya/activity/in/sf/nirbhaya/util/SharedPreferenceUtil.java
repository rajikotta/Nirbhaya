package in.sf.nirbhaya.activity.in.sf.nirbhaya.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import in.sf.nirbhaya.activity.model.UserModel;

/**
 * Created by raji on 5/31/16.
 */
public class SharedPreferenceUtil {

    private static String USER_DETAILS = "USER_DETAILS";

    private static String USER_NAME = "USER_NAME";
    private static String PH_NUM1 = "PH_NUM1";
    private static String PH_NUM2 = "PH_NUM2";
    private static String PH_NUM3 = "PH_NUM3";
    private static String EMAIL = "EMAIL";

    public static void saveConfiguration(Context context, UserModel userModel) {

        context.getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE).edit().putString(USER_NAME, userModel.getUsername()).putString(PH_NUM1, userModel.getPhNum1()).putString(PH_NUM2, userModel.getPhNum2()).putString(PH_NUM3, userModel.getPhNum3()).putString(EMAIL, userModel.getEmailId()).commit();
    }

    public static UserModel getConfiguration(Context context) {

        SharedPreferences prefs =context.getSharedPreferences(USER_DETAILS,Context.MODE_PRIVATE);

        UserModel userModel = new UserModel();
        userModel.setUsername(prefs.getString(USER_NAME, ""));
        userModel.setEmailId(prefs.getString(EMAIL, ""));
        userModel.setPhNum1(prefs.getString(PH_NUM1, ""));
        userModel.setPhNum2(prefs.getString(PH_NUM2, ""));
        userModel.setPhNum3(prefs.getString(PH_NUM3, ""));

        return userModel;
    }
}
