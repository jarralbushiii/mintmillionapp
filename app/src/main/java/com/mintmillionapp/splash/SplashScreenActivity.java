package com.mintmillionapp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import com.mintmillionapp.R;
import com.mintmillionapp.auth.LoginActivity;
import com.mintmillionapp.games.GamesActivity;
import com.mintmillionapp.nft.NFTMarketplaceActivity;
import com.mintmillionapp.wallet.WalletActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Updated to activity_splash

        // Load the scale animation
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_button);

        // Find the buttons
        Button loginButton = findViewById(R.id.button_login);
        Button walletButton = findViewById(R.id.button_wallet);
        Button gamesButton = findViewById(R.id.button_games);
        Button nftButton = findViewById(R.id.button_nft);

        // Set click listeners for navigation with animation
        loginButton.setOnClickListener(v -> {
            v.startAnimation(scaleAnimation);
            Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        walletButton.setOnClickListener(v -> {
            v.startAnimation(scaleAnimation);
            Intent intent = new Intent(SplashScreenActivity.this, WalletActivity.class);
            startActivity(intent);
        });

        gamesButton.setOnClickListener(v -> {
            v.startAnimation(scaleAnimation);
            Intent intent = new Intent(SplashScreenActivity.this, GamesActivity.class);
            startActivity(intent);
        });

        nftButton.setOnClickListener(v -> {
            v.startAnimation(scaleAnimation);
            Intent intent = new Intent(SplashScreenActivity.this, NFTMarketplaceActivity.class);
            startActivity(intent);
        });
    }
}