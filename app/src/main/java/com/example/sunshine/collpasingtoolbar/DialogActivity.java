package com.example.sunshine.collpasingtoolbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    String[] items = {" Easy ", " Medium ", " Hard ", " Very Hard "};
    String result = "";

    Handler handler;
    Runnable runnable;
    Timer timer;
    int  i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        showAlertDialog();

        showConformationDialog();

        showCircularProgressDialog();

        showLinearProgressDialog();
    }

    private void showLinearProgressDialog() {
        findViewById(R.id.linear_progress_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(DialogActivity.this, R.style.ConformationDialogTheme);

                progressDialog.setTitle("Progress Dialog");
                progressDialog.setMessage("please wait");

                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setIndeterminate(false);

                progressDialog.show();
                progressDialog.setProgress(0);
                progressDialog.setMax(100);

                handler = new Handler();

                runnable = new Runnable() {
                    @Override
                    public void run() {
                        i += 5;
                        if ( i <= 100 ){
                            progressDialog.setProgress(i);
                        }else {
                            timer.cancel();
                            progressDialog.cancel();
                            i=0;
                        }
                    }

                };

                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(runnable);

                    }
                }, 8000, 500);

            }
        });

    }

    private void showCircularProgressDialog() {
        findViewById(R.id.circular_progress_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(DialogActivity.this, R.style.ConformationDialogTheme);
                progressDialog.setTitle("Progress Dialog");
                progressDialog.setMessage("please wait");

                progressDialog.show();
//                progressDialog.cancel(); // to cancel progress dialog
            }
        });
    }

    private void showConformationDialog() {
        findViewById(R.id.confirmation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this, R.style.ConformationDialogTheme);
                builder.setTitle("select the difficulty level");


                // -1 means don't selected to any choice by default. 0 select first one by default
                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result = items[which];
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, result, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    private void showAlertDialog() {
        findViewById(R.id.alert_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //second method to change text color of button in the dialog, by adding the 2nd para. to AlertDialog.Builder. All Button have same color
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this, R.style.AlertDialogTheme);

                builder.setMessage("Discard draft?");
                builder.setPositiveButton("DISCARD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "Discard", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();

                //first method to change text color of button in the dialog. each button may have different color
                //alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorAlertDialog));


            }
        });
    }
}
