package com.mintmillionapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.mintmillionapp.auth.LoginActivity;
import com.mintmillionapp.games.AviatorGameActivity;
import com.mintmillionapp.nft.NFTMarketplaceActivity;
import com.mintmillionapp.wallet.WalletActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.login_button);
        Button walletButton = findViewById(R.id.wallet_button);
        Button gamesButton = findViewById(R.id.games_button);
        Button nftButton = findViewById(R.id.nft_button);

        loginButton.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
        walletButton.setOnClickListener(v -> startActivity(new Intent(this, WalletActivity.class)));
        gamesButton.setOnClickListener(v -> startActivity(new Intent(this, AviatorGameActivity.class)));
        nftButton.setOnClickListener(v -> startActivity(new Intent(this, NFTMarketplaceActivity.class)));
    }
}