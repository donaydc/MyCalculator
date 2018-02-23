package com.donaydc.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TextoLeido = "";
    String NumeroLeido = "0";
    String OpEnviar = TextoLeido;
    String Signo = "Ind";
    double Num = 0;
    double Ans = 0;
    LinearLayout Wsp;
    TextView TxVCal, TxVRes;
    Button Button0, Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9;
    Button ButtonMas, ButtonMenos, ButtonPor, ButtonDiv, ButtonPun, ButtonDel, ButtonIgl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button0 = findViewById(R.id.Bt0);
        Button1 = findViewById(R.id.Bt1);
        Button2 = findViewById(R.id.Bt2);
        Button3 = findViewById(R.id.Bt3);
        Button4 = findViewById(R.id.Bt4);
        Button5 = findViewById(R.id.Bt5);
        Button6 = findViewById(R.id.Bt6);
        Button7 = findViewById(R.id.Bt7);
        Button8 = findViewById(R.id.Bt8);
        Button9 = findViewById(R.id.Bt9);
        ButtonMas = findViewById(R.id.BtMas);
        ButtonMenos = findViewById(R.id.BtMenos);
        ButtonPor = findViewById(R.id.BtPor);
        ButtonDiv = findViewById(R.id.BtDivision);
        ButtonPun = findViewById(R.id.BtPunto);
        ButtonDel = findViewById(R.id.BtDel);
        ButtonIgl = findViewById(R.id.BtIgual);
        TxVCal = findViewById(R.id.TxCalculos);
        TxVRes = findViewById(R.id.TxResultado);
        TxVRes = findViewById(R.id.TxResultado);
        Wsp = findViewById(R.id.Workspace);

        Button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "0";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "1";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "2";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "3";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "4";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "5";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "6";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "7";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "8";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "9";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        ButtonPun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + ".";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        ButtonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "+";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        ButtonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "-";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        ButtonPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "x";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        ButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "/";
                TxVCal.setText(TextoLeido);
                OpEnviar = TextoLeido;
            }
        });

        ButtonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = "";
                NumeroLeido = "0";
                Ans=0;
                Num=0;
                Signo = "Ind";
                OpEnviar = TextoLeido;
                TxVCal.setText(TextoLeido);
                TxVRes.setText(Double.toString(Ans));
            }
        });

        ButtonIgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Ln = TextoLeido.length();
                String[] TxL = TextoLeido.split("");

                for (int i=1; i<=Ln; i++) {
                    if (TxL[i].equals("+")){
                        Num = Double.parseDouble(NumeroLeido);
                        FindSign(Signo, Num);
                        Signo="Mas";
                        NumeroLeido="";
                    } else if (TxL[i].equals("-")){
                        Num = Double.parseDouble(NumeroLeido);
                        FindSign(Signo, Num);
                        Signo="Menos";
                        NumeroLeido="";
                    } else if (TxL[i].equals("x")){
                        Num = Double.parseDouble(NumeroLeido);
                        FindSign(Signo, Num);
                        Signo="Por";
                        NumeroLeido="";
                    } else if (TxL[i].equals("/")){
                        Num = Double.parseDouble(NumeroLeido);
                        FindSign(Signo, Num);
                        Signo="Entre";
                        NumeroLeido="";
                    } else {
                        NumeroLeido = NumeroLeido + TxL[i];
                    }
                }

                Num = Double.parseDouble(NumeroLeido);
                FindSign(Signo, Num);
                NumeroLeido="";

                TxVRes.setText(Double.toString(Ans));
                OpEnviar = TextoLeido;
                TextoLeido=Double.toString(Ans);
                Signo = "Ind";
            }
        });

        Wsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Goto = new Intent(MainActivity.this, SecondActivity.class);
                Goto.putExtra("Operation", OpEnviar);
                startActivityForResult(Goto,1);
            }
        });

    }

    private void FindSign(String Sg, double Nu ) {
        if (Sg.equals("Mas")){
            Ans=Ans+Nu;
        } else if (Sg.equals("Menos")) {
            Ans=Ans-Nu;
        } else if (Sg.equals("Por")) {
            Ans=Ans*Nu;
        } else if (Sg.equals("Entre")) {
            Ans=Ans/Nu;
        } else { Ans = Nu; }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                TextoLeido = data.getStringExtra("Operation");
                TxVCal.setText(TextoLeido);
                ButtonIgl.performClick();
            }
        }
    }

}


