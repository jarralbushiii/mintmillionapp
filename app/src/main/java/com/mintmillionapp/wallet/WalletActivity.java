package com.mintmillionapp.wallet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mintmillionapp.R;

public class WalletActivity extends AppCompatActivity {
    private double balance = 100.0; // Mock USDT balance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        TextView balanceText = findViewById(R.id.balance_text);
        Button depositButton = findViewById(R.id.deposit_button);

        balanceText.setText("Balance: " + balance + " USDT");

        depositButton.setOnClickListener(v -> {
            balance += 10.0; // Mock deposit
            balanceText.setText("Balance: " + balance + " USDT");
        });
    }
}