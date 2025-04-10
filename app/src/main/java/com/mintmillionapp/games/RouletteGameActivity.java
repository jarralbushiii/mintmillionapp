package com.mintmillionapp.games;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mintmillionapp.R;
import java.util.Random;

public class RouletteGameActivity extends AppCompatActivity {
    private TextView resultText;
    private Button spinButton;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette_game);

        resultText = findViewById(R.id.result_text);
        spinButton = findViewById(R.id.spin_button);

        spinButton.setOnClickListener(v -> {
            int number = random.nextInt(37); // 0-36
            resultText.setText("Number: " + number);
        });
    }
}