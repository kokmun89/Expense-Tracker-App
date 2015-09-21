package com.pedrocarrillo.expensetracker.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

import com.pedrocarrillo.expensetracker.ExpenseTrackerApp;
import com.pedrocarrillo.expensetracker.R;

/**
 * Created by Pedro on 9/20/2015.
 */
public class DialogManager {

    private static DialogManager ourInstance = new DialogManager();

    public static DialogManager getInstance() {
        return ourInstance;
    }

    private DialogManager() {
    }

    public void createEditTextDialog(Activity activity, String title, String confirmText, String negativeText, final DialogInterface.OnClickListener listener) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.layout_dialog_edit_text, null);
        createAlertDialog(activity, title, dialogLayout, null, confirmText, negativeText, listener);
    }

    public void createCustomAcceptDialog(Activity activity, String title, String message, String confirmText, String negativeText, final DialogInterface.OnClickListener listener) {
        createAlertDialog(activity, title, null, message, confirmText, negativeText, listener);
    }

    private void createAlertDialog(Activity activity, String title, View dialogLayout, String message, String confirmText, String negativeText, final DialogInterface.OnClickListener listener) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        dialogBuilder.setTitle(title);
        if (dialogLayout != null) dialogBuilder.setView(dialogLayout);
        if (message != null) dialogBuilder.setMessage(message);
        dialogBuilder.setPositiveButton(confirmText, listener);
        dialogBuilder.setNegativeButton(negativeText, listener);
        dialogBuilder.create().show();
    }
}