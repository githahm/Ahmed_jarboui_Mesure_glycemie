package com.example.ahmed_jarboui_mesure_glycemie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnConsulter;
    private TextView msg;
    private SeekBar sbAge;
    private RadioButton rbnOui;
    private RadioButton rbnNon;
    private EditText etValeur;
    private TextView textAge;

    private int Age = 0;

    private void init() {
        btnConsulter = findViewById(R.id.btnConsulter);
        sbAge        = findViewById(R.id.sbAge);
        rbnOui       = findViewById(R.id.rbnOui);
        rbnNon       = findViewById(R.id.rbnNon);
        etValeur     = findViewById(R.id.etValeur);
        msg          = findViewById(R.id.msg);
        textAge      = findViewById(R.id.textAge);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Age = progress;
                textAge.setText("Votre âge : " + progress + " ans");
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consulterGlycemie();
            }
        });
    }


    private void consulterGlycemie() {
        String valeurString = etValeur.getText().toString().trim();

        if (valeurString.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer la valeur mesurée", Toast.LENGTH_SHORT).show();
            return;
        }

        double valeur;
        try {
            valeur = Double.parseDouble(valeurString);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valeur invalide", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean aJeune = rbnOui.isChecked();
        double min, max;

        if (aJeune) {
            if (Age > 13) {
                min = 5.0;
                max = 7.2;
            } else if (Age >= 6) {
                min = 5.0;
                max = 10.0;
            } else {
                min = 5.5;
                max = 10.0;
            }
        } else {
            min = 0.0;
            max = 10.5;
        }

        String resultat;
        if (valeur < min) {
            resultat = "Le niveau de glycémie est trop bas";
        } else if (valeur > max) {
            resultat = "Le niveau de glycémie est trop élevé";
        } else {
            resultat = "Le niveau de glycémie est normal";
        }

        msg.setText(resultat);
    }
}