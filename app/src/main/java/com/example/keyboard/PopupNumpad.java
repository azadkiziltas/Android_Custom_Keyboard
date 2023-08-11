package com.example.keyboard;

import android.content.Context;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class PopupNumpad {

    View popupView;
    android.widget.PopupWindow popupWindow;
    public boolean isShow = false;
    private final Context context;


    public PopupNumpad(Context context) {
        this.context = context;
    }

    public void showPopup(EditText editText) {
        isShow = true;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.popup_numpad, null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        Numpad keyboard = (Numpad) popupView.findViewById(R.id.keyboard);
        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        popupWindow = new PopupWindow(popupView, width, height, true);
        popupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                isShow = false;
            }
        });
    }

    public void hidePopup() {
        popupWindow.dismiss();
        isShow = false;
    }
}
