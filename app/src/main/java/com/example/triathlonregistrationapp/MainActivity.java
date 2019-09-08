package com.example.triathlonregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double athleteCost = 725;
    double totalCost;
    int numAthletes;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText athletes = (EditText)findViewById(R.id.numAthletes);
        final Spinner group = (Spinner)findViewById(R.id.locationSpinner);
        Button submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.resultText));
            @Override
            public void onClick(View view) {
                numAthletes = Integer.parseInt(athletes.getText().toString());
                totalCost = numAthletes * athleteCost;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for " + numAthletes + " at " + groupChoice + " is " + currency.format(totalCost));
            }
        });
    }
}
