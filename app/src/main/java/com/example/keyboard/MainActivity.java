package com.example.keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    PopupKeyboard popupKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setShowSoftInputOnFocus(false);
        popupKeyboard = new PopupKeyboard(this);


        // prevent system keyboard from appearing when EditText is tapped


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!popupKeyboard.isShow) {
                    popupKeyboard.showPopup(editText);
                }
            }
        });

        // pass the InputConnection from the EditText to the keyboard

    }
}
