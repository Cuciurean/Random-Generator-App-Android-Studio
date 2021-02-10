package rdm.randomize.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.randomapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainMenu extends AppCompatActivity {

    private Button bttn1;
    private Button bttn2;
    private Button bttn3;
    private Button bttn4;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        ///////// MainMenu to Number Generator
        bttn1 = (Button) findViewById(R.id.MainNumber);
        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumberGenerator();


            }
        });
        ///////// MainMenu to Number Generator

        ///////// MainMenu to Day Generator
        bttn2 = (Button) findViewById(R.id.MainDay);
        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDayGenerator();
            }
        });
        ///////// MainMenu to Day Generator

        ///////// MainMenu to Month Generator
        bttn3 = (Button) findViewById(R.id.MainMonth);
        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMonthGenerator();
            }
        });
        ///////// MainMenu to Month Generator

        ///////// MainMenu to Alphabet Generator
        bttn3 = (Button) findViewById(R.id.MainAlphabet);
        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlphabetGenerator();
            }
        });
        ///////// MainMenu to Alphabet Generator

        ///////// MainMenu to Alphabet Generator
        bttn4 = (Button) findViewById(R.id.MainCoin);
        bttn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCoinGenerator();
            }
        });
        ///////// MainMenu to Alphabet Generator



    }

    public void openNumberGenerator() {
        Intent intent = new Intent(this, NumberGenerator.class);
        startActivity(intent);
    }

    public void openDayGenerator() {
        Intent intent = new Intent(this, DayGenerator.class);
        startActivity(intent);
    }

    public void openMonthGenerator() {
        Intent intent = new Intent(this, MonthGeneratro.class);
        startActivity(intent);
    }

    public void openAlphabetGenerator() {
        Intent intent = new Intent(this, AlphabetGenerator.class);
        startActivity(intent);
    }

    public void openCoinGenerator() {
        Intent intent = new Intent(this, CoinGenerator.class);
        startActivity(intent);
    }




}