package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private Button btnConvert;
    private RadioGroup radioGroup;
    private RadioButton radioInchesToCm, radioCmToInches;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnConvert = findViewById(R.id.btnConvert);
        radioGroup = findViewById(R.id.radioGroup);
        radioInchesToCm = findViewById(R.id.radioInchesToCm);
        radioCmToInches = findViewById(R.id.radioCmToInches);
        tvResult = findViewById(R.id.tvResult);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    private void performConversion() {
        String inputValue = etInput.getText().toString().trim();

        if (inputValue.isEmpty()) {
            Toast.makeText(this, "Please enter a value.", Toast.LENGTH_SHORT).show();
            return;
        }

        double input = Double.parseDouble(inputValue);
        double result;

        if (radioInchesToCm.isChecked()) {
            // Convert inches to centimeters
            result = input * 2.54;
            tvResult.setText(String.format("%.2f inches = %.2f cm", input, result));
        } else {
            // Convert centimeters to inches
            result = input / 2.54;
            tvResult.setText(String.format("%.2f cm = %.2f inches", input, result));
        }
    }
}
