//package com.example.aleksey.learnhebrew.registration;
//
//import android.content.DialogInterface;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.aleksey.learnhebrew.R;
//
//public class ForgotPassword extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_forgot_password);
//    }
//
//    public void sendForgotMail(View view) {
//
//        EditText et = (EditText) findViewById(R.id.recoveryEmail);
//        String recoveryEmail = et.getText().toString();
//
//        ParseUser.requestPasswordResetInBackground(recoveryEmail,
//                new RequestPasswordResetCallback() {
//                    public void done(ParseException e) {
//                        if (e == null) {
//                            AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this);
//                            builder.setMessage("Link to recover password sent to your e-mail address").setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            finish();
//                                        }
//                                    });
//                            AlertDialog dialog = builder.create();
//                            dialog.show();
//
//
//                        } else {
//                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//}
