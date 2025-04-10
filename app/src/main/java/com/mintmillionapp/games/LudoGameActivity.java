package com.mintmillionapp.games;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mintmillionapp.R;
import java.util.Random;

public class LudoGameActivity extends AppCompatActivity {
    private TextView diceText;
    private Button rollButton;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ludo_game);

        diceText = findViewById(R.id.dice_text);
        rollButton = findViewById(R.id.roll_button);

        rollButton.setOnClickListener(v -> {
            int roll = random.nextInt(6) + 1;
            diceText.setText("Dice: " + roll);
        });
    }
}