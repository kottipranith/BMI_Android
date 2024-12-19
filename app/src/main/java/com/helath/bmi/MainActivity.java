package com.helath.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        EditText weight, feet, inches;
        Button btn;
        TextView txt;

        weight = findViewById(R.id.editWeight);
        feet = findViewById(R.id.editFeet);
        inches = findViewById(R.id.editInches);
        btn = findViewById(R.id.btnCal);
        txt = findViewById(R.id.result);

        btn.setOnClickListener((view)->{
            int wt = Integer.parseInt(weight.getText().toString());
            int ft = Integer.parseInt(feet.getText().toString());
            int inch = Integer.parseInt(inches.getText().toString());
            int totalIn = ft*12+inch;

            double totalCm = totalIn*2.53;

            double totalM = totalCm/100;

            double bmi = wt/(totalM*totalM);

            if(bmi > 25)
                txt.setText("you are overweight");
            else if(bmi < 18)
                    txt.setText("you are underweight");
            else
                txt.setText("you are healthy");
        });
    }


}