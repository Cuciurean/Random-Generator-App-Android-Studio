package rdm.randomize.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.randomapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class NumberGenerator extends AppCompatActivity {
    EditText e1;
    EditText e2;

    private AdView mAdView;

    int min;
    int max;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        ///////// Number Generator
        final Random myRandom = new Random();
        final TextView textRandom;

        e1 = (EditText) findViewById(R.id.Editmin);
        e2 = (EditText) findViewById(R.id.Editmax);



        Button bttgenerate = (Button)findViewById(R.id.generate);
        textRandom = (TextView)findViewById(R.id.generatenumber);

        bttgenerate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                closeKeyboard();
                min = Integer.parseInt(e1.getText().toString());
                max = Integer.parseInt(e2.getText().toString());

                random = myRandom.nextInt(max - min +1)+min;
                textRandom.setText(String.valueOf(random));

                //textRandom.setText(String.valueOf(myRandom.nextInt(100)));

            }
        });
        ///////// Number Generator
    }

    private void closeKeyboard()
    {
        View v = this.getCurrentFocus();
        if(v != null)
        {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

}