package com.kangsangyeon.baromukza.lib;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by pc-1 on 2017-11-12.
 */

public class MySnack {

    public static void show(View view, CharSequence message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }
    public static void show(View view, CharSequence message, CharSequence actionName, View.OnClickListener actionEvent){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction(actionName, actionEvent).show();
    }
}