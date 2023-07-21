package com.example.temperatureconverter;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText temperatureInput;
    private TextView fahrenheitText;
    private TextView kelvinText;
    private TextView Celsius;
    private Button convertButton;
    private Spinner unitSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unitSpinner = findViewById(R.id.spinner);
        temperatureInput = findViewById(R.id.input);
        fahrenheitText = findViewById(R.id.fer);
        kelvinText = findViewById(R.id.kel);
        Celsius = findViewById(R.id.cel);
        convertButton = findViewById(R.id.but);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperatures, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        unitSpinner.setAdapter(adapter);
        int colorValue = Color.parseColor("#F6AA5D");
        convertButton.setTag(R.id.but, colorValue);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
                int currentColor = (Integer) convertButton.getTag(R.id.but);
                int nextColor = colors[0];

                for (int i = 0; i < colors.length; i++) {
                    if (currentColor == colors[i]) {
                        nextColor = colors[(i + 1) % colors.length]; // Get the next color in the array
                        break;
                    }
                }

                convertButton.setBackgroundColor(nextColor);
                convertButton.setTag(R.id.but, nextColor); // Save the new colo}

                Integer index = unitSpinner.getSelectedItemPosition();
                if (index == 0) {
                    //C To F , K
                    String temperatureString = temperatureInput.getText().toString();
                    double temperature = Double.parseDouble(temperatureString);
                    Celsius.setText("-");
                    double f = (temperature * 9 / 5) + 32;
                    fahrenheitText.setText(String.valueOf(f));
                    double k = temperature + 273.15;
                    kelvinText.setText(String.valueOf(k));
                }
                else if (index == 1) {
                    //F to C,K
                    String temperatureString2 = temperatureInput.getText().toString();
                    double tempfer = Double.parseDouble(temperatureString2);
                    double c = 5 / 9 * (tempfer - 32);
                    Celsius.setText(String.valueOf(c));
                    fahrenheitText.setText("-");
                    double k1 = (tempfer - 32) * 5 / 9 + 273.15;
                    kelvinText.setText(String.valueOf(k1));
                }
                else if (index == 2) {

                    //kelvin to c and f
                    String temperatureString3 = temperatureInput.getText().toString();
                    double tempkel = Double.parseDouble(temperatureString3);

                    kelvinText.setText("-");
                    double c1 = tempkel - 273.15;
                    Celsius.setText(String.valueOf(c1));
                    double f1 = (tempkel - 273.15) * 9 / 5 + 32;
                    fahrenheitText.setText(String.valueOf(f1));

                } else {
                    Celsius.setText("");
                    fahrenheitText.setText("");
                    kelvinText.setText("");
                }
            }
        });
    }
}







