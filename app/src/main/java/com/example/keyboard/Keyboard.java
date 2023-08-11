package com.example.keyboard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Keyboard extends LinearLayout implements View.OnClickListener {

    // constructors
    public Keyboard(Context context) {
        this(context, null, 0);
    }

    public Keyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Keyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // keyboard keys (buttons)
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;
    private RelativeLayout mButtonDelete;
    private RelativeLayout mButtonEnter;

    private Button mButtonQ;
    private Button mButtonW;
    private Button mButtonE;
    private Button mButtonR;
    private Button mButtonT;
    private Button mButtonY;
    private Button mButtonU;
    private Button mButtonI;
    private Button mButtonO;
    private Button mButtonP;
    private Button mButtonĞ;
    private Button mButtonÜ;
    private Button mButtonA;
    private Button mButtonS;
    private Button mButtonD;
    private Button mButtonF;
    private Button mButtonG;
    private Button mButtonH;
    private Button mButtonJ;
    private Button mButtonK;
    private Button mButtonL;
    private Button mButtonŞ;
    private Button mButtonİ;
    private Button mButtonZ;
    private Button mButtonX;
    private Button mButtonC;
    private Button mButtonV;
    private Button mButtonB;
    private Button mButtonN;
    private Button mButtonM;
    private Button mButtonÖ;
    private Button mButtonÇ;
    private Button mButtonDOT;
    private Button mButtonSpace;
    private RelativeLayout mButtonEnter2;
    private RelativeLayout mButtonDelete2;
    private RelativeLayout mButtonCapslock;
    private boolean capslock = false;
    PopupKeyboard popupKeyboard;




    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    SparseArray<String> keyValues = new SparseArray<>();

    // Our communication link to the EditText
    InputConnection inputConnection;

    private void init(Context context, AttributeSet attrs) {

        // initialize buttons
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mButton5 = (Button) findViewById(R.id.button_5);
        mButton6 = (Button) findViewById(R.id.button_6);
        mButton7 = (Button) findViewById(R.id.button_7);
        mButton8 = (Button) findViewById(R.id.button_8);
        mButton9 = (Button) findViewById(R.id.button_9);
        mButton0 = (Button) findViewById(R.id.button_0);
        mButtonDelete = (RelativeLayout) findViewById(R.id.button_delete);
        mButtonEnter = (RelativeLayout) findViewById(R.id.button_enter);
        mButtonQ = (Button) findViewById(R.id.button_Q);
        mButtonW = (Button) findViewById(R.id.button_W);
        mButtonE = (Button) findViewById(R.id.button_E);
        mButtonR = (Button) findViewById(R.id.button_R);
        mButtonT = (Button) findViewById(R.id.button_T);
        mButtonY = (Button) findViewById(R.id.button_Y);
        mButtonU = (Button) findViewById(R.id.button_U);
        mButtonI = (Button) findViewById(R.id.button_I);
        mButtonO = (Button) findViewById(R.id.button_O);
        mButtonP = (Button) findViewById(R.id.button_P);
        mButtonĞ = (Button) findViewById(R.id.button_Ğ);
        mButtonÜ = (Button) findViewById(R.id.button_Ü);
        mButtonA = (Button) findViewById(R.id.button_A);
        mButtonS = (Button) findViewById(R.id.button_S);
        mButtonD = (Button) findViewById(R.id.button_D);
        mButtonF = (Button) findViewById(R.id.button_F);
        mButtonG = (Button) findViewById(R.id.button_G);
        mButtonH = (Button) findViewById(R.id.button_H);
        mButtonJ = (Button) findViewById(R.id.button_J);
        mButtonK = (Button) findViewById(R.id.button_K);
        mButtonL = (Button) findViewById(R.id.button_L);
        mButtonŞ = (Button) findViewById(R.id.button_Ş);
        mButtonİ = (Button) findViewById(R.id.button_İ);
        mButtonZ = (Button) findViewById(R.id.button_Z);
        mButtonX = (Button) findViewById(R.id.button_X);
        mButtonC = (Button) findViewById(R.id.button_C);
        mButtonV = (Button) findViewById(R.id.button_V);
        mButtonB = (Button) findViewById(R.id.button_B);
        mButtonN = (Button) findViewById(R.id.button_N);
        mButtonM = (Button) findViewById(R.id.button_M);
        mButtonÖ = (Button) findViewById(R.id.button_Ö);
        mButtonÇ = (Button) findViewById(R.id.button_Ç);
        mButtonDOT = (Button) findViewById(R.id.button_DOT);
        mButtonSpace = (Button) findViewById(R.id.button_space);
        mButtonEnter2 = (RelativeLayout) findViewById(R.id.button_enter2);
        mButtonDelete2 = (RelativeLayout) findViewById(R.id.button_delete2);
        mButtonCapslock = (RelativeLayout) findViewById(R.id.button_capslock);


        // set button click listeners
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButton0.setOnClickListener(this);
        mButtonDelete.setOnClickListener(this);
        mButtonDelete.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                inputConnection.deleteSurroundingText(99, 0);
                return false;
            }
        });
        mButtonDelete2.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                inputConnection.deleteSurroundingText(99, 0);

                return false;
            }
        });


        mButtonCapslock.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                capslock = !capslock;

                if (capslock) {
                    mButtonCapslock.setBackgroundResource(R.drawable.btn_hover_active);
                    mButtonA.setText("A");
                    mButtonB.setText("B");
                    mButtonC.setText("C");
                    mButtonÇ.setText("Ç");
                    mButtonD.setText("D");
                    mButtonE.setText("E");
                    mButtonF.setText("F");
                    mButtonG.setText("G");
                    mButtonĞ.setText("Ğ");
                    mButtonH.setText("H");
                    mButtonI.setText("I");
                    mButtonİ.setText("İ");
                    mButtonJ.setText("J");
                    mButtonK.setText("K");
                    mButtonL.setText("L");
                    mButtonM.setText("M");
                    mButtonN.setText("N");
                    mButtonO.setText("O");
                    mButtonÖ.setText("Ö");
                    mButtonP.setText("P");
                    mButtonR.setText("R");
                    mButtonS.setText("S");
                    mButtonŞ.setText("Ş");
                    mButtonT.setText("T");
                    mButtonU.setText("U");
                    mButtonÜ.setText("Ü");
                    mButtonV.setText("V");
                    mButtonY.setText("Y");
                    mButtonZ.setText("Z");
                    mButtonQ.setText("Q");
                    mButtonW.setText("W");
                    mButtonX.setText("X");


                    keyValues.put(R.id.button_1, "1");
                    keyValues.put(R.id.button_2, "2");
                    keyValues.put(R.id.button_3, "3");
                    keyValues.put(R.id.button_4, "4");
                    keyValues.put(R.id.button_5, "5");
                    keyValues.put(R.id.button_6, "6");
                    keyValues.put(R.id.button_7, "7");
                    keyValues.put(R.id.button_8, "8");
                    keyValues.put(R.id.button_9, "9");
                    keyValues.put(R.id.button_0, "0");
                    keyValues.put(R.id.button_enter, "\n");
                    keyValues.put(R.id.button_Q, "Q");
                    keyValues.put(R.id.button_W, "W");
                    keyValues.put(R.id.button_E, "E");
                    keyValues.put(R.id.button_R, "R");
                    keyValues.put(R.id.button_T, "T");
                    keyValues.put(R.id.button_Y, "Y");
                    keyValues.put(R.id.button_U, "U");
                    keyValues.put(R.id.button_I, "I");
                    keyValues.put(R.id.button_O, "O");
                    keyValues.put(R.id.button_P, "P");
                    keyValues.put(R.id.button_Ğ, "Ğ");
                    keyValues.put(R.id.button_Ü, "Ü");
                    keyValues.put(R.id.button_A, "A");
                    keyValues.put(R.id.button_S, "S");
                    keyValues.put(R.id.button_D, "D");
                    keyValues.put(R.id.button_F, "F");
                    keyValues.put(R.id.button_G, "G");
                    keyValues.put(R.id.button_H, "H");
                    keyValues.put(R.id.button_J, "J");
                    keyValues.put(R.id.button_K, "K");
                    keyValues.put(R.id.button_L, "L");
                    keyValues.put(R.id.button_Ş, "Ş");
                    keyValues.put(R.id.button_İ, "İ");
                    keyValues.put(R.id.button_Z, "Z");
                    keyValues.put(R.id.button_X, "X");
                    keyValues.put(R.id.button_C, "C");
                    keyValues.put(R.id.button_V, "V");
                    keyValues.put(R.id.button_B, "B");
                    keyValues.put(R.id.button_N, "N");
                    keyValues.put(R.id.button_M, "M");
                    keyValues.put(R.id.button_Ö, "Ö");
                    keyValues.put(R.id.button_Ç, "Ç");
                    keyValues.put(R.id.button_DOT, ".");
                    keyValues.put(R.id.button_space, " ");
                    keyValues.put(R.id.button_enter2, "\n");


                } else {
                    mButtonCapslock.setBackgroundResource(R.drawable.btn_hover_stop);
                    mButtonA.setText("a");
                    mButtonB.setText("b");
                    mButtonC.setText("c");
                    mButtonÇ.setText("ç");
                    mButtonD.setText("d");
                    mButtonE.setText("e");
                    mButtonF.setText("f");
                    mButtonG.setText("g");
                    mButtonĞ.setText("ğ");
                    mButtonH.setText("h");
                    mButtonI.setText("ı");
                    mButtonİ.setText("i");
                    mButtonJ.setText("j");
                    mButtonK.setText("k");
                    mButtonL.setText("l");
                    mButtonM.setText("m");
                    mButtonN.setText("n");
                    mButtonO.setText("o");
                    mButtonÖ.setText("ö");
                    mButtonP.setText("p");
                    mButtonR.setText("r");
                    mButtonS.setText("s");
                    mButtonŞ.setText("ş");
                    mButtonT.setText("t");
                    mButtonU.setText("u");
                    mButtonÜ.setText("ü");
                    mButtonV.setText("v");
                    mButtonY.setText("y");
                    mButtonZ.setText("z");
                    mButtonQ.setText("q");
                    mButtonW.setText("w");
                    mButtonX.setText("x");


                    keyValues.put(R.id.button_1, "1");
                    keyValues.put(R.id.button_2, "2");
                    keyValues.put(R.id.button_3, "3");
                    keyValues.put(R.id.button_4, "4");
                    keyValues.put(R.id.button_5, "5");
                    keyValues.put(R.id.button_6, "6");
                    keyValues.put(R.id.button_7, "7");
                    keyValues.put(R.id.button_8, "8");
                    keyValues.put(R.id.button_9, "9");
                    keyValues.put(R.id.button_0, "0");
                    keyValues.put(R.id.button_enter, "\n");
                    keyValues.put(R.id.button_Q, "q");
                    keyValues.put(R.id.button_W, "w");
                    keyValues.put(R.id.button_E, "e");
                    keyValues.put(R.id.button_R, "r");
                    keyValues.put(R.id.button_T, "t");
                    keyValues.put(R.id.button_Y, "y");
                    keyValues.put(R.id.button_U, "u");
                    keyValues.put(R.id.button_I, "ı");
                    keyValues.put(R.id.button_O, "o");
                    keyValues.put(R.id.button_P, "p");
                    keyValues.put(R.id.button_A, "a");
                    keyValues.put(R.id.button_S, "s");
                    keyValues.put(R.id.button_D, "d");
                    keyValues.put(R.id.button_F, "f");
                    keyValues.put(R.id.button_G, "g");
                    keyValues.put(R.id.button_H, "h");
                    keyValues.put(R.id.button_J, "j");
                    keyValues.put(R.id.button_K, "k");
                    keyValues.put(R.id.button_L, "l");
                    keyValues.put(R.id.button_Z, "z");
                    keyValues.put(R.id.button_X, "x");
                    keyValues.put(R.id.button_C, "c");
                    keyValues.put(R.id.button_V, "v");
                    keyValues.put(R.id.button_B, "b");
                    keyValues.put(R.id.button_N, "n");
                    keyValues.put(R.id.button_M, "m");
                    keyValues.put(R.id.button_Ğ, "ğ");
                    keyValues.put(R.id.button_Ü, "ü");
                    keyValues.put(R.id.button_Ç, "ç");
                    keyValues.put(R.id.button_Ö, "ö");
                    keyValues.put(R.id.button_Ş, "ş");
                    keyValues.put(R.id.button_İ, "i");
                    keyValues.put(R.id.button_DOT, ".");
                    keyValues.put(R.id.button_space, " ");
                    keyValues.put(R.id.button_enter2, "\n");

                }
            }
        });
        mButtonEnter.setOnClickListener(this);
        mButtonQ.setOnClickListener(this);
        mButtonW.setOnClickListener(this);
        mButtonE.setOnClickListener(this);
        mButtonR.setOnClickListener(this);
        mButtonT.setOnClickListener(this);
        mButtonY.setOnClickListener(this);
        mButtonU.setOnClickListener(this);
        mButtonI.setOnClickListener(this);
        mButtonO.setOnClickListener(this);
        mButtonP.setOnClickListener(this);
        mButtonĞ.setOnClickListener(this);
        mButtonÜ.setOnClickListener(this);
        mButtonA.setOnClickListener(this);
        mButtonS.setOnClickListener(this);
        mButtonD.setOnClickListener(this);
        mButtonF.setOnClickListener(this);
        mButtonG.setOnClickListener(this);
        mButtonH.setOnClickListener(this);
        mButtonJ.setOnClickListener(this);
        mButtonK.setOnClickListener(this);
        mButtonL.setOnClickListener(this);
        mButtonŞ.setOnClickListener(this);
        mButtonİ.setOnClickListener(this);
        mButtonZ.setOnClickListener(this);
        mButtonX.setOnClickListener(this);
        mButtonC.setOnClickListener(this);
        mButtonV.setOnClickListener(this);
        mButtonB.setOnClickListener(this);
        mButtonN.setOnClickListener(this);
        mButtonM.setOnClickListener(this);
        mButtonÖ.setOnClickListener(this);
        mButtonÇ.setOnClickListener(this);
        mButtonDOT.setOnClickListener(this);
        mButtonSpace.setOnClickListener(this);
        mButtonEnter2.setOnClickListener(this);
        mButtonDelete2.setOnClickListener(this);


        keyValues.put(R.id.button_1, "1");
        keyValues.put(R.id.button_2, "2");
        keyValues.put(R.id.button_3, "3");
        keyValues.put(R.id.button_4, "4");
        keyValues.put(R.id.button_5, "5");
        keyValues.put(R.id.button_6, "6");
        keyValues.put(R.id.button_7, "7");
        keyValues.put(R.id.button_8, "8");
        keyValues.put(R.id.button_9, "9");
        keyValues.put(R.id.button_0, "0");
        keyValues.put(R.id.button_enter, "\n");
        keyValues.put(R.id.button_Q, "q");
        keyValues.put(R.id.button_W, "w");
        keyValues.put(R.id.button_E, "e");
        keyValues.put(R.id.button_R, "r");
        keyValues.put(R.id.button_T, "t");
        keyValues.put(R.id.button_Y, "y");
        keyValues.put(R.id.button_U, "u");
        keyValues.put(R.id.button_I, "ı");
        keyValues.put(R.id.button_O, "o");
        keyValues.put(R.id.button_P, "p");
        keyValues.put(R.id.button_A, "a");
        keyValues.put(R.id.button_S, "s");
        keyValues.put(R.id.button_D, "d");
        keyValues.put(R.id.button_F, "f");
        keyValues.put(R.id.button_G, "g");
        keyValues.put(R.id.button_H, "h");
        keyValues.put(R.id.button_J, "j");
        keyValues.put(R.id.button_K, "k");
        keyValues.put(R.id.button_L, "l");
        keyValues.put(R.id.button_Z, "z");
        keyValues.put(R.id.button_X, "x");
        keyValues.put(R.id.button_C, "c");
        keyValues.put(R.id.button_V, "v");
        keyValues.put(R.id.button_B, "b");
        keyValues.put(R.id.button_N, "n");
        keyValues.put(R.id.button_M, "m");
        keyValues.put(R.id.button_Ğ, "ğ");
        keyValues.put(R.id.button_Ü, "ü");
        keyValues.put(R.id.button_Ç, "ç");
        keyValues.put(R.id.button_Ö, "ö");
        keyValues.put(R.id.button_Ş, "ş");
        keyValues.put(R.id.button_İ, "i");
        keyValues.put(R.id.button_DOT, ".");
        keyValues.put(R.id.button_space, " ");
        keyValues.put(R.id.button_enter2, "\n");
    }

    @Override
    public void onClick(View v) {

        // do nothing if the InputConnection has not been set yet
        if (inputConnection == null) return;

        // Delete text or input key value
        // All communication goes through the InputConnection
        if ((v.getId() == R.id.button_delete) || v.getId() == R.id.button_delete2) {
            CharSequence selectedText = inputConnection.getSelectedText(0);
            if (TextUtils.isEmpty(selectedText)) {
                // no selection, so delete previous character
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                // delete the selection
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(v.getId());
            inputConnection.commitText(value, 1);
        }
    }

    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    public void setInputConnection(InputConnection ic) {
        this.inputConnection = ic;
    }
}