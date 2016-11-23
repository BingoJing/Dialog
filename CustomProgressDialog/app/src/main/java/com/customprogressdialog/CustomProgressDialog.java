package com.customprogressdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BingoNjf on 2016/11/2.
 * 自定义  dialog
 */
public class CustomProgressDialog extends Dialog {

    private static CustomProgressDialog mCustomProgressDialog = null;

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * Creates a dialog.
     *
     * @param context
     *        context allows access to resources and types of features to the
     *        application.
     * @return the instance of CustomProgressDialog.
     */
    public static CustomProgressDialog createDialog(Context context) {

        mCustomProgressDialog = new CustomProgressDialog(context,R.style.CustomProgressDialog);
        mCustomProgressDialog.setContentView(R.layout.progressdialog_style);
        mCustomProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;

        return  mCustomProgressDialog;
    }

    public void onWindowFocusChanged(boolean hasFocus) {

        if (null==mCustomProgressDialog) {
            return;
        }
        ImageView imageView = (ImageView) mCustomProgressDialog.findViewById(R.id.image_loading_view);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }

    /**
     * Sets message.
     *
     * @param strMessage
     *        message.
     * @return the instance of CustomProgressDialog.
     */
    public void setMessage(String strMessage) {

        TextView tvMsg = (TextView) mCustomProgressDialog.findViewById(R.id.text_loading_msg);
        if (null!=tvMsg) {
            tvMsg.setText(strMessage);
        }
    }
}
