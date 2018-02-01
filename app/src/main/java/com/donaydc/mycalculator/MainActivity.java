package com.donaydc.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String TextoLeido = "";
    String NumeroLeido = "0";
    String Signo = "Ind";
    double Num = 0;
    double Ans = 0;
    DecimalFormat DAns = new DecimalFormat("#.0000");
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

        Button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "0";
                NumeroLeido = NumeroLeido + "0";
                TxVCal.setText(TextoLeido);
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "1";
                NumeroLeido = NumeroLeido + "1";
                TxVCal.setText(TextoLeido);
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "2";
                NumeroLeido = NumeroLeido + "2";
                TxVCal.setText(TextoLeido);
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "3";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + "3";
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "4";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + "4";
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "5";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + "5";
            }
        });

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "6";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + "6";
            }
        });

        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "7";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + "7";
            }
        });

        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "8";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + "8";
            }
        });

        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + "9";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + "9";
            }
        });

        ButtonPun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = TextoLeido + ".";
                TxVCal.setText(TextoLeido);
                NumeroLeido = NumeroLeido + ".";
            }
        });

        ButtonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextoLeido.equals("")){
                    NumeroLeido = Double.toString(Ans);
                    TextoLeido = Double.toString(Ans);
                }

                if (Signo.equals("Ind")){
                    TextoLeido = TextoLeido + "+";
                    Num = Double.parseDouble(NumeroLeido);
                } else {
                    if (Signo.equals("Mas")){
                        Ans=Num+Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "+";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Menos")) {
                        Ans=Num-Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "+";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Por")) {
                        Ans=Num*Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "+";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Entre")) {
                        Ans=Num/Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "+";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else { Ans = 0; }
                }

                TxVCal.setText(TextoLeido);
                Signo="Mas";
                NumeroLeido = "0";
            }
        });

        ButtonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextoLeido.equals("")){
                    NumeroLeido = Double.toString(Ans);
                    TextoLeido = Double.toString(Ans);
                }

                if (Signo.equals("Ind")){
                    TextoLeido = TextoLeido + "-";
                    Num = Double.parseDouble(NumeroLeido);
                } else {
                    if (Signo.equals("Mas")){
                        Ans=Num+Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "-";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Menos")) {
                        Ans=Num-Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "-";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Por")) {
                        Ans=Num*Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "-";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Entre")) {
                        Ans=Num/Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "-";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else { Ans = 0; }
                }

                TxVCal.setText(TextoLeido);
                Signo="Menos";
                NumeroLeido = "0";
            }
        });

        ButtonPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextoLeido.equals("")){
                    NumeroLeido = Double.toString(Ans);
                    TextoLeido = Double.toString(Ans);
                }

                if (Signo.equals("Ind")){
                    TextoLeido = TextoLeido + "*";
                    Num = Double.parseDouble(NumeroLeido);
                } else {
                    if (Signo.equals("Mas")){
                        Ans=Num+Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "*";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Menos")) {
                        Ans=Num-Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "*";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Por")) {
                        Ans=Num*Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "*";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Entre")) {
                        Ans=Num/Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "*";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else { Ans = 0; }
                }

                TxVCal.setText(TextoLeido);
                Signo="Por";
                NumeroLeido = "0";
            }
        });

        ButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextoLeido.equals("")){
                    NumeroLeido = Double.toString(Ans);
                    TextoLeido = Double.toString(Ans);
                }

                if (Signo.equals("Ind")){
                    TextoLeido = TextoLeido + "/";
                    Num = Double.parseDouble(NumeroLeido);
                } else {
                    if (Signo.equals("Mas")){
                        Ans=Num+Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "/";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Menos")) {
                        Ans=Num-Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "/";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Por")) {
                        Ans=Num*Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "/";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else if (Signo.equals("Entre")) {
                        Ans=Num/Double.parseDouble(NumeroLeido);
                        TextoLeido = Ans + "/";
                        TxVRes.setText(Double.toString(Ans));
                        Num = Ans;
                    } else { Ans = 0; }
                }

                TxVCal.setText(TextoLeido);
                Signo="Entre";
                NumeroLeido = "0";
            }
        });

        ButtonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextoLeido = "";
                NumeroLeido = "0";
                Ans=0;
                Num=0;
                Signo="Ind";
                TxVCal.setText(TextoLeido);
                TxVRes.setText(Double.toString(Ans));
            }
        });

        ButtonIgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Num != 0){
                    if (Signo.equals("Mas")){
                        Ans=Num+Double.parseDouble(NumeroLeido);
                    } else if (Signo.equals("Menos")) {
                        Ans=Num-Double.parseDouble(NumeroLeido);
                    } else if (Signo.equals("Por")) {
                        Ans=Num*Double.parseDouble(NumeroLeido);
                    } else if (Signo.equals("Entre")) {
                        Ans=Num/Double.parseDouble(NumeroLeido);
                    } else { Ans = 0; }
                } else {
                    Ans=Double.parseDouble(NumeroLeido);
                }

                Signo="Ind";
                TxVRes.setText(Double.toString(Ans));
                NumeroLeido = "0";
                TextoLeido = "";
                Num=0;

            }
        });

    }
}
