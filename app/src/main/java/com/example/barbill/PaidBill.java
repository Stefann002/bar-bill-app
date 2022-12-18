package com.example.barbill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaidBill extends AppCompatActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paid_bill_activity);
        int trenutnaCenaPivaInt = getIntent().getIntExtra("trenutnaCenaPivaInt", 0);
        int trenutnaCenaVinaInt = getIntent().getIntExtra("trenutnaCenaVinaInt", 0);
        int trenutnaCenaZestineInt = getIntent().getIntExtra("trenutnaCenaZestinaInt", 0);
        int zestinaCountInt = getIntent().getIntExtra("zestinaCountInt", 0);
        int vinoCountInt = getIntent().getIntExtra("vinoCountInt", 0);
        int pivoCountInt = getIntent().getIntExtra("pivoCountInt", 0);

        TextView brojPivaTv = findViewById(R.id.brojPiva);
        TextView brojVinaTv = findViewById(R.id.brojVina);
        TextView brojZestinaTv = findViewById(R.id.brojZestina);
        TextView racun = findViewById(R.id.racun);

        System.out.println(pivoCountInt);
        brojPivaTv.setText("Popili ste " + pivoCountInt + " pivo/a i kosta " + trenutnaCenaPivaInt + "din");
        brojVinaTv.setText("Popili ste " + vinoCountInt + " vino/a i kosta " + trenutnaCenaVinaInt + "din");
        brojZestinaTv.setText("Popili ste " + zestinaCountInt + " shot/ova zestine i kosta " + trenutnaCenaZestineInt + "din");

        int totalBill = trenutnaCenaPivaInt + trenutnaCenaZestineInt + trenutnaCenaVinaInt;
        racun.setText("Vas racun je  " + totalBill + "din");

        Button zavrsi = findViewById(R.id.zavrsiRacun);
        zavrsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaidBill.this,
                        MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        Button nazad = findViewById(R.id.nazadRacun);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
