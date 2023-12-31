package com.example.keyboard;

import android.content.Context;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class PopupKeyboard {

    View popupView;
    android.widget.PopupWindow popupWindow;
    public boolean isShow = false;
    private final Context context;
    Button closeButton;


    public PopupKeyboard(Context context) {
        this.context = context;
    }

    public void showPopup(EditText editText) {
        isShow = true;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.popup_keyboard, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        Keyboard keyboard = (Keyboard) popupView.findViewById(R.id.keyboard);
        Button closeButton = (Button) popupView.findViewById(R.id.button_close);
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
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidePopup();
            }
        });
    }

    public void hidePopup() {
        popupWindow.dismiss();
        isShow = false;
    }
}
