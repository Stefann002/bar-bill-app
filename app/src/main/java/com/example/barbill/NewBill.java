package com.example.barbill;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewBill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_bill_activity);

        Button odustaniButton = findViewById(R.id.odustaniButton);

        EditText inputCenaPiva = findViewById(R.id.cenaPiva);
        EditText inputCenaVina = findViewById(R.id.cenaVina);
        EditText inputCenaZestine= findViewById(R.id.cenaZestine);

        odustaniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button daljeButton = findViewById(R.id.daljeButton);
        daljeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cenaPivaString = inputCenaPiva.getText().toString();
                String cenaVinaString = inputCenaVina.getText().toString();
                String cenaZestineString = inputCenaZestine.getText().toString();
                int cenaPiva = Integer.parseInt(cenaPivaString);
                int cenaVina = Integer.parseInt(cenaVinaString);
                int cenaZestine = Integer.parseInt(cenaZestineString);
                System.out.println(cenaPiva);
                Intent intent = new Intent(NewBill.this, CurrentBill.class);
                intent.putExtra("cenaPiva",cenaPiva);
                intent.putExtra("cenaVina",cenaVina);
                intent.putExtra("cenaZestine",cenaZestine);
                startActivity(intent);
            }
        });
    }
}

