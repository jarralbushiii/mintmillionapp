package com.mintmillionapp.games;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mintmillionapp.R;
import java.util.Random;

public class RabbitRunnerGameActivity extends AppCompatActivity {
    private TextView scoreText;
    private Button jumpButton;
    private double balance = 0.0;
    private Handler handler = new Handler();
    private Random random = new Random();
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit_runner_game);

        scoreText = findViewById(R.id.score_text);
        jumpButton = findViewById(R.id.jump_button);

        jumpButton.setOnClickListener(v -> {
            if (!isRunning) startGame();
        });
    }

    private void startGame() {
        isRunning = true;
        jumpButton.setText("Jump");
        Runnable obstacleRunnable = new Runnable() {
            @Override
            public void run() {
                if (random.nextInt(100) < 20) {
                    scoreText.setText("Obstacle! Jump now!");
                } else {
                    balance += 0.1; // Fractional increase
                    scoreText.setText("Score: " + String.format("%.1f", balance) + " USDT");
                    handler.postDelayed(this, 1000);
                }
            }
        };
        handler.post(obstacleRunnable);
    }
}