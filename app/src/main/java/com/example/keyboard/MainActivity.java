package com.example.keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    PopupNumpad popupNumpad;
    PopupKeyboard popupKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        editText.setShowSoftInputOnFocus(false);
        editText2.setShowSoftInputOnFocus(false);
        popupNumpad = new PopupNumpad(this);
        popupKeyboard = new PopupKeyboard(this);


        // prevent system keyboard from appearing when EditText is tapped


        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    if (!popupNumpad.isShow) {
                        popupNumpad.showPopup(editText);
                    }
                    else {
                        popupNumpad.hidePopup();
                    }
                }
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!popupNumpad.isShow) {
                    popupNumpad.showPopup(editText);
                }
            }
        });
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    if (!popupKeyboard.isShow) {
                        popupKeyboard.showPopup(editText2);
                    }
                    else {
                        popupKeyboard.hidePopup();
                    }
                }
            }
        });

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!popupKeyboard.isShow) {
                    popupKeyboard.showPopup(editText2);
                }
            }
        });

        // pass the InputConnection from the EditText to the keyboard

    }
}
