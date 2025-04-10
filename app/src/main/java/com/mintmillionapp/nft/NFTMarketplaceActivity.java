package com.mintmillionapp.nft;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mintmillionapp.R;

public class NFTMarketplaceActivity extends AppCompatActivity {
    private double balance = 100.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nft_marketplace);

        TextView nftPrice = findViewById(R.id.nft_price);
        Button buyButton = findViewById(R.id.buy_button);

        nftPrice.setText("NFT Price: 50 USDT");

        buyButton.setOnClickListener(v -> {
            if (balance >= 50) {
                balance -= 50;
                nftPrice.setText("NFT Bought! Balance: " + balance + " USDT");
            } else {
                nftPrice.setText("Insufficient funds!");
            }
        });
    }
}