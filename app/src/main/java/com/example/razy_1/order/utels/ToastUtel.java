package com.example.razy_1.order.utels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.razy_1.order.R;

public class ToastUtel {


    public static void showToast(Context context, String text) {
        Toast m_currentToast = null;
        if (m_currentToast == null) {
            m_currentToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }

        m_currentToast.setText(text);
        m_currentToast.setDuration(Toast.LENGTH_SHORT);
        m_currentToast.show();
    }

    public static void COLORTOAST(Context context, String txt) {
        Toast toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.getBackground().setColorFilter(context.getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(context.getResources().getColor(R.color.darkwhite));

        toast.show();
    }
}
