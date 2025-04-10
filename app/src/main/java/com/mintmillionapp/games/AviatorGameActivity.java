package com.mintmillionapp.games;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mintmillionapp.R;
import java.util.Random;

public class AviatorGameActivity extends AppCompatActivity {
    private TextView multiplierText;
    private Button betButton;
    private double balance = 100.0;
    private float multiplier = 1.0f; // Moved to class field
    private Handler handler = new Handler();
    private Random random = new Random();
    private boolean isFlying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviator_game);

        multiplierText = findViewById(R.id.multiplier_text);
        betButton = findViewById(R.id.bet_button);

        betButton.setOnClickListener(v -> startGame());
    }

    private void startGame() {
        if (!isFlying) {
            isFlying = true;
            betButton.setEnabled(false);
            double betAmount = 10.0;
            balance -= betAmount;
            multiplier = 1.0f; // Reset multiplier at the start of the game
            multiplierText.setText("Multiplier: " + String.format("%.2f", multiplier) + "x");

            Runnable flightRunnable = new Runnable() {
                @Override
                public void run() {
                    multiplier += 0.1f; // Now safe to modify
                    multiplierText.setText("Multiplier: " + String.format("%.2f", multiplier) + "x");
                    if (random.nextInt(100) < 5) {
                        crash(multiplier, betAmount);
                    } else {
                        handler.postDelayed(this, 100);
                    }
                }
            };
            handler.post(flightRunnable);
        }
    }

    private void crash(float multiplier, double betAmount) {
        isFlying = false;
        betButton.setEnabled(true);
        balance += betAmount * multiplier;
        multiplierText.setText("Crashed at " + String.format("%.2f", multiplier) + "x! Balance: " + balance + " USDT");
    }
}