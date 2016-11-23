package com.customprogressdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private final int SCAN_PERIOD = 5000;

    private Handler mHandler;

    private CustomProgressDialog mProgress;

    private Button mBtnShowProgress1;

    private Button mBtnShowProgress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();
        mProgress = CustomProgressDialog.createDialog(this);

        mProgress.setCancelable(true);
        mProgress.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {

                mProgress.dismiss();
                mHandler.removeCallbacks(mRunnable);
            }
        });

        mBtnShowProgress1 = (Button) findViewById(R.id.btn_show_progress1);
        mBtnShowProgress1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                /* Show the progress. */
                mProgress.setMessage("进度条加载中~点击任意空白处可中断。");
                mProgress.show();
            }
        });

        mBtnShowProgress2 = (Button) findViewById(R.id.btn_show_progress2);
        mBtnShowProgress2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                /* Show the progress. */
                mProgress.setMessage("进度条加载中~会自动停止的哦。");
                mProgress.show();

                // Stops scanning after a pre-defined scan period.
                mHandler.postDelayed(mRunnable, SCAN_PERIOD);
            }
        });
    }

    /**
     * An instance of Runnable.
     */
    private Runnable mRunnable = new Runnable() {

        @Override
        public void run() {

            mProgress.dismiss();
        }
    };
}
