package com.example.ahmed_jarboui_mesure_glycemie;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculer(View view){
        SeekBar sbAge = findViewById(R.id.sbAge);
        EditText etValeur = findViewById(R.id.valeur);
        RadioButton rbnOui = findViewById(R.id.rbnOui);

        int age = sbAge.getProgress();
        String valeurTexte = etValeur.getText().toString();

        if (valeurTexte.isEmpty()) {
            return;
        }

        double glycemie = Double.parseDouble(valeurTexte);
        boolean aJeune = rbnOui.isChecked();
        String message = "";

        if (aJeune) {
            if (age > 13) {
                if (glycemie < 5.0) {
                    message = "niveau de glycémie est trop bas";
                } else if (glycemie > 7.2) {
                    message = "niveau de glycémie est trop élevée";
                } else {
                    message = "niveau de glycémie est normale";
                }
            } else if (age >= 6 && age <= 12) {
                if (glycemie < 5.0) {
                    message = "niveau de glycémie est trop bas";
                } else if (glycemie > 10.0) {
                    message = "niveau de glycémie est trop élevée";
                } else {
                    message = "niveau de glycémie est normale";
                }
            } else {
                if (glycemie < 5.5) {
                    message = "niveau de glycémie est trop bas";
                } else if (glycemie > 10.0) {
                    message = "niveau de glycémie est trop élevée";
                } else {
                    message = "niveau de glycémie est normale";
                }
            }
        } else {
            if (glycemie > 10.5) {
                message = "niveau de glycémie est trop élevée";
            } else {
                message = "niveau de glycémie est normale";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
} // <-- Fixed: Removed the extra closing brace here