package com.example.digitsofpi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String pi = "3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798";

    TextView numOfDigits;
    TextView display;

    int startIndex = 0;
    int endIndex = 4;
    int nums = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numOfDigits = findViewById(R.id.num_of_digits);
        display = findViewById(R.id.digits);

        updateDisplay();
    }

    public void updateDisplay() {
        numOfDigits.setText("Number of Digits: " + nums);
        display.setText(pi.substring(startIndex, endIndex));
    }

    public void next(View view) {
        if (nums == 102) {
            Toast.makeText(this, "Reached end of digits", Toast.LENGTH_SHORT).show();
            return;
        }
        if (startIndex == 0) {
            startIndex += 4;
        }
        else {
            startIndex += 3;
        }
        endIndex += 3;
        nums += 3;
        updateDisplay();
    }

    public void reset(View view) {
        nums = 3;
        startIndex = 0;
        endIndex = 4;
        updateDisplay();
    }

    public void back(View view) {
        if (nums == 3) {
            Toast.makeText(this, "Reached start of digits", Toast.LENGTH_SHORT).show();
            return;
        }
        if (startIndex == 4) {
            startIndex -= 4;
        }
        else {
            startIndex -= 3;
        }
        endIndex -= 3;
        nums -= 3;
        updateDisplay();
    }
}
