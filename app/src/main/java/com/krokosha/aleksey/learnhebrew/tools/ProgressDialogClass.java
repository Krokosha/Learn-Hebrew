package com.krokosha.aleksey.learnhebrew.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class ProgressDialogClass {
    private ProgressDialog dialog;
    private Context context;
    private String openWord;
    private String closeWord;

    public ProgressDialogClass(Context context, String openWord, String closeWord) {
        this.context = context;
        this.openWord = openWord;
        this.closeWord = closeWord;
    }

    public void showProgressDialog() {
        Toast.makeText(context, openWord, Toast.LENGTH_SHORT).show();
        if (dialog == null) {
            dialog = new ProgressDialog(context);
            dialog.setMessage("Waiting...");
            dialog.setIndeterminate(true);
        }
        dialog.show();
    }

    public void hideProgressDialog() {
        Toast.makeText(context, closeWord, Toast.LENGTH_SHORT).show();
        if (dialog != null && dialog.isShowing()) {
            dialog.hide();
        }
    }
}
