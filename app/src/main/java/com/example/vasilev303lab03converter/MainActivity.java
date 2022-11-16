package com.example.vasilev303lab03converter;

import android.app.ApplicationErrorReport;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.EmptyStackException;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spFrom = findViewById(R.id.listFrom);
        spTo = findViewById(R.id.listTo);
        etFrom = findViewById(R.id.txtFrom);
        tvTo = findViewById(R.id.labTo);

        ArrayAdapter<String> adp = new <String>ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void my_on_convert_click(View V) {
        double from = Double.parseDouble(etFrom.getText().toString());

        String sFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        double to = 0.0;
        double m = 0.0;

        if (from != 0.0)
        {
            if (sFrom.equals("mm")) m = from / 1000.0;
            if (sFrom.equals("cm")) m = from / 100.0;
            if (sFrom.equals("m")) m = from / 1.0;
            if (sFrom.equals("km")) m = from * 1000.0;

            if (sTo.equals("mm")) to = m * 1000.0;
            if (sTo.equals("cm")) to = m * 100.0;
            if (sTo.equals("m")) to = m * 1.0;
            if (sTo.equals("km")) to = m / 1000.0;
        }

        else
        {
            Toast.makeText(this, "Поле не может быть пустым или не должно содержать 0", Toast.LENGTH_SHORT).show();
        }

        tvTo.setText(String.valueOf(to));
    }
}