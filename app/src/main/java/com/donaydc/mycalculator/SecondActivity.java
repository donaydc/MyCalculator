package com.donaydc.mycalculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SecondActivity extends AppCompatActivity {

    String Op = "";
    String NumL = "";
    String GetNum = "";
    String OpCorrected = "";
    
    int NumBt = 1;
    int PosBt = 0;

    ArrayList<String> StrOp = new ArrayList<>();

    LinearLayout Opd;
    Button Back2Main;
    TextView TxP;

    CharSequence Symbols[] = new CharSequence[] {"+","-","x","/","."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TxP = findViewById(R.id.TxPrueba);
        Opd = findViewById(R.id.Operandos);
        Back2Main = findViewById(R.id.Back);

        Op = getIntent().getStringExtra("Operation");
        OpCorrected = Op;
        TxP.setText(Op);

        Pattern pat = Pattern.compile("[-x+/.]+|\\d+");
        Matcher Mtch = pat.matcher(Op);
        
        while (Mtch.find()) {

            StrOp.add(Mtch.group());

            if (Mtch.group().matches("\\+|\\.|-|x|/")){

                LinearLayout LChild = new LinearLayout(SecondActivity.this);
                LChild.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                LChild.setPadding(20, 10, 20, 10);
                LChild.setBackgroundResource(R.drawable.my_custom_background);
                Opd.addView(LChild);

                final TextView TxV = new TextView(this);
                TxV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,2.0f));
                TxV.setGravity(Gravity.CENTER);
                TxV.setTextColor(getResources().getColor(android.R.color.black));
                TxV.setBackgroundColor(Color.parseColor("#b3b3b3"));
                TxV.setPadding(15, 20, 15, 20);
                TxV.setTextSize(20);
                TxV.setText(NumL);

                final Button BtE = new Button(this);
                BtE.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
                BtE.setGravity(Gravity.CENTER);
                BtE.setTextColor(getResources().getColor(android.R.color.white));
                BtE.setBackgroundColor(Color.parseColor("#666666"));
                BtE.setPadding(15, 20, 15, 20);
                BtE.setTextSize(20);
                BtE.setText("#"+String.valueOf(NumBt)+" Editar");
                NumBt++;

                LChild.addView(TxV);
                LChild.addView(BtE);

                BtE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String numChange = BtE.getText().toString();
                        PosBt = Character.getNumericValue(numChange.charAt(1));
                        AlertDialog.Builder alert = new AlertDialog.Builder(SecondActivity.this);
                        alert.setTitle("Editar Número");
                        alert.setMessage("Ingrese el número: ");
                        final EditText input = new EditText(SecondActivity.this);
                        input.setInputType(InputType.TYPE_CLASS_NUMBER);
                        input.setRawInputType(Configuration.KEYBOARD_12KEY);
                        alert.setView(input);
                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                GetNum = input.getText().toString();
                                TxV.setText(GetNum);
                                StrOp.set(PosBt-1,GetNum);
                                OpCorrected = "";
                                for (String s : StrOp){OpCorrected+=s;}
                                TxP.setText(OpCorrected);
                            }
                        });
                        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) { }
                        });
                        alert.show();
                    }
                });

                LinearLayout LChild2 = new LinearLayout(SecondActivity.this);
                LChild2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                LChild2.setPadding(20, 6, 20, 6);
                Opd.addView(LChild2);

                final TextView TxVS = new TextView(this);
                TxVS.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,2.0f));
                TxVS.setGravity(Gravity.CENTER);
                TxVS.setTextColor(getResources().getColor(android.R.color.black));
                TxVS.setBackgroundColor(Color.parseColor("#b3b3b3"));
                TxVS.setPadding(10, 20, 10, 20);
                TxVS.setTextSize(20);
                TxVS.setText(Mtch.group());

                final Button BtE2 = new Button(this);
                BtE2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
                BtE2.setGravity(Gravity.CENTER);
                BtE2.setTextColor(getResources().getColor(android.R.color.white));
                BtE2.setBackgroundColor(Color.parseColor("#666666"));
                BtE2.setPadding(10, 20, 10, 20);
                BtE2.setTextSize(20);
                BtE2.setText("#"+String.valueOf(NumBt)+" Editar");;
                NumBt++;

                LChild2.addView(TxVS);
                LChild2.addView(BtE2);

                BtE2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String numChange = BtE2.getText().toString();
                        PosBt = Character.getNumericValue(numChange.charAt(1));
                        AlertDialog.Builder AlDig = new AlertDialog.Builder(SecondActivity.this);
                        AlDig.setTitle("Editar Operación");
                        AlDig.setItems(Symbols, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                GetNum = Symbols[i].toString();
                                TxVS.setText(GetNum);
                                StrOp.set(PosBt-1,GetNum);
                                OpCorrected = "";
                                for (String s : StrOp){OpCorrected+=s;}
                                TxP.setText(OpCorrected);
                            }
                        });
                        AlDig.show();
                    }
                });

                NumL="";

            } else {
                NumL = NumL + Mtch.group();
            }

        }

        LinearLayout LChild = new LinearLayout(SecondActivity.this);
        LChild.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        LChild.setPadding(20, 10, 20, 10);
        LChild.setBackgroundResource(R.drawable.my_custom_background);
        Opd.addView(LChild);

        final TextView TxV = new TextView(this);
        TxV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,2.0f));
        TxV.setGravity(Gravity.CENTER);
        TxV.setTextColor(getResources().getColor(android.R.color.black));
        TxV.setBackgroundColor(Color.parseColor("#b3b3b3"));
        TxV.setPadding(15, 20, 15, 20);
        TxV.setTextSize(20);
        TxV.setText(NumL);

        final Button BtE = new Button(this);
        BtE.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
        BtE.setGravity(Gravity.CENTER);
        BtE.setTextColor(getResources().getColor(android.R.color.white));
        BtE.setBackgroundColor(Color.parseColor("#666666"));
        BtE.setPadding(15, 20, 15, 20);
        BtE.setTextSize(20);
        BtE.setText("#"+String.valueOf(NumBt)+" Editar");
        NumBt++;

        LChild.addView(TxV);
        LChild.addView(BtE);

        BtE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numChange = BtE.getText().toString();
                PosBt = Character.getNumericValue(numChange.charAt(1));
                AlertDialog.Builder alert = new AlertDialog.Builder(SecondActivity.this);
                alert.setTitle("Editar Numero");
                alert.setMessage("Ingrese el numero caracter: ");
                final EditText input = new EditText(SecondActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setRawInputType(Configuration.KEYBOARD_12KEY);
                alert.setView(input);
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        GetNum = input.getText().toString();
                        TxV.setText(GetNum);
                        StrOp.set(PosBt-1,GetNum);
                        OpCorrected = "";
                        for (String s : StrOp){OpCorrected+=s;}
                        TxP.setText(OpCorrected);
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) { }
                });
                alert.show();
            }
        });


        Back2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Goto = new Intent(SecondActivity.this, MainActivity.class);
                Goto.putExtra("Operation", OpCorrected);
                setResult(Activity.RESULT_OK,Goto);
                finish();
            }
        });

    }
}
