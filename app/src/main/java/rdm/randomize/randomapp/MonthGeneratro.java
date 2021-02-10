package rdm.randomize.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.randomapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class MonthGeneratro extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_generatro);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        final TextView textRandom;
        Random r = new Random();

        String[] list = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        Button bttgenerate = (Button)findViewById(R.id.btngenerateMonth);
        textRandom = (TextView)findViewById(R.id.textgenerateMonth);

        bttgenerate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                textRandom.setText(String.valueOf(list[r.nextInt(list.length)]));
            }
        });
    }
}