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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnConsulter;
    private TextView msg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnConsulter=findViewById(R.id.btnConsulter);
        msg=findViewById(R.id.msg);;


        btnConsulter.setOnClickListener(new View.OnClickListener(){@Override
        public void onClick(View v){msg.setText("Felicitation");}});




    }
    //public void calculer(View v){
      //  Toast.makeText(this, "le bouton consulter a ete clique", Toast.LENGTH_SHORT).show();
    //}


    }