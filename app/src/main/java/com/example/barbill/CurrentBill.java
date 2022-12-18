package com.example.barbill;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CurrentBill extends AppCompatActivity {
    int zestinaCountInt;
    int trenutnaCenaZestinaInt;
    int trenutnaCenaVinaInt;
    int vinoCountInt;
    int pivoCountInt;
    int trenutnaCenaPivaInt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_bill_activity);
        int cenaPiva = getIntent().getIntExtra("cenaPiva", 0);
        int cenaVina = getIntent().getIntExtra("cenaVina", 0);
        int cenaZestine = getIntent().getIntExtra("cenaZestine", 0);

        TextView trenutnaCenaPiva = findViewById(R.id.trenutnaCenaPiva);
        TextView trenutnaCenaVina = findViewById(R.id.trenutnaCenaVina);
        TextView trenutnaCenaZestine = findViewById(R.id.trenutnaCenaZestina);

        Button dodajPivo = findViewById(R.id.dodajPivo);

        Button oduzmiPivo = findViewById(R.id.oduzmiPivo);
        EditText pivoCount = findViewById(R.id.pivoCount);
        pivoCount.setText("0");

        dodajPivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pivoCountString = pivoCount.getText().toString();
                pivoCountInt = Integer.parseInt(pivoCountString)+1;
                trenutnaCenaPivaInt = pivoCountInt*cenaPiva;
                trenutnaCenaPiva.setText("Trenutna Cena Piva: " + trenutnaCenaPivaInt);
                String backToStringPivoCount = Integer.toString(pivoCountInt);
                pivoCount.setText(backToStringPivoCount);
            }
        });
        oduzmiPivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pivoCountString = pivoCount.getText().toString();
                pivoCountInt = Integer.parseInt(pivoCountString)-1;
                if(pivoCountInt < 0){
                    Toast.makeText(getApplicationContext(),"Ne mozete otici u negativan broj pica", Toast.LENGTH_SHORT).show();
                }else{
                    trenutnaCenaPivaInt = pivoCountInt*cenaPiva;
                    trenutnaCenaPiva.setText("Trenutna Cena Piva: " + trenutnaCenaPivaInt);
                    String backToStringPivoCount = Integer.toString(pivoCountInt);
                    pivoCount.setText(backToStringPivoCount);
                }

            }
        });

        Button dodajVino = findViewById(R.id.dodajVino);
        Button oduzmiVino = findViewById(R.id.oduzmiVino);
        EditText vinoCount = findViewById(R.id.vinoCount);
        vinoCount.setText("0");
        dodajVino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vinoCountString = vinoCount.getText().toString();
                vinoCountInt = Integer.parseInt(vinoCountString)+1;
                trenutnaCenaVinaInt = vinoCountInt*cenaVina;
                trenutnaCenaVina.setText("Trenutna Cena Vina: " + trenutnaCenaVinaInt);
                if(vinoCountInt < 0){
                    Toast.makeText(getApplicationContext(),"Ne mozete otici u negativan broj pica", Toast.LENGTH_SHORT).show();
                }else{
                    String backToStringPivoCount = Integer.toString(vinoCountInt);
                    vinoCount.setText(backToStringPivoCount);
                }
            }
        });
        oduzmiVino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vinoCountString = vinoCount.getText().toString();
                vinoCountInt = Integer.parseInt(vinoCountString)-1;
                if(vinoCountInt < 0){
                    Toast.makeText(getApplicationContext(),"Ne mozete otici u negativan broj pica", Toast.LENGTH_SHORT).show();
                }else{
                    trenutnaCenaVinaInt = vinoCountInt*cenaVina;
                    trenutnaCenaVina.setText("Trenutna Cena Vina: " + trenutnaCenaVinaInt);
                    String backToStringPivoCount = Integer.toString(vinoCountInt);
                    vinoCount.setText(backToStringPivoCount);
                }
            }
        });

        Button dodajZestinu = findViewById(R.id.dodajZestinu);
        Button oduzmiZestinu = findViewById(R.id.oduzmiZestinu);
        EditText zestinaCount = findViewById(R.id.zestinaCount);
        zestinaCount.setText("0");
        dodajZestinu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zestinaCountString = zestinaCount.getText().toString();
                zestinaCountInt = Integer.parseInt(zestinaCountString)+1;
                trenutnaCenaZestinaInt = zestinaCountInt*cenaZestine;
                trenutnaCenaZestine.setText("Trenutna Cena Zestine: " + trenutnaCenaZestinaInt);

                String backToStringPivoCount = Integer.toString(zestinaCountInt);
                zestinaCount.setText(backToStringPivoCount);

            }
        });

        oduzmiZestinu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zestinaCountString = zestinaCount.getText().toString();
                zestinaCountInt = Integer.parseInt(zestinaCountString)-1;
                if(zestinaCountInt < 0){
                    Toast.makeText(getApplicationContext(),"Ne mozete otici u negativan broj pica", Toast.LENGTH_SHORT).show();
                }else{
                    trenutnaCenaZestinaInt = zestinaCountInt*cenaZestine;
                    trenutnaCenaZestine.setText("Trenutna Cena Zestine: " + trenutnaCenaZestinaInt);
                    String backToStringPivoCount = Integer.toString(zestinaCountInt);
                    zestinaCount.setText(backToStringPivoCount);
                }
            }
        });

        Button nazad = findViewById(R.id.nazadButton);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                Intent intent = new Intent(CurrentBill.this, NewBill.class);
//                startActivity(intent);
            }
        });
        Button platiRacun = findViewById(R.id.platiRacunButton);

        platiRacun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CurrentBill.this,PaidBill.class);
                intent.putExtra("trenutnaCenaPivaInt",trenutnaCenaPivaInt);
                intent.putExtra("trenutnaCenaVinaInt",trenutnaCenaVinaInt);
                intent.putExtra("trenutnaCenaZestinaInt",trenutnaCenaZestinaInt);
                intent.putExtra("zestinaCountInt",zestinaCountInt);
                intent.putExtra("pivoCountInt",pivoCountInt);
                intent.putExtra("vinoCountInt",vinoCountInt);
                startActivity(intent);

            }
        });




    }

}
