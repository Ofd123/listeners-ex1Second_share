package com.example.listeners_ex1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class resultScreen extends AppCompatActivity
{
    TextView redScore,blueScore,winner;
    int redPt,bluePt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        redScore = (TextView) findViewById(R.id.redScore);
        winner = (TextView) findViewById(R.id.winner);
        blueScore = (TextView) findViewById(R.id.blueScore);

        Intent getScore = getIntent();
        redPt = getScore.getIntExtra("redCount",0);
        bluePt = getScore.getIntExtra("blueCount",0);

        redScore.setText("red team score: "+String.valueOf(redPt));
        blueScore.setText("blue team score: "+String.valueOf(bluePt));

        if(redPt > bluePt)
        {
            winner.setText("RED TEAM WINS!!!");
            winner.setTextColor(Color.parseColor("#F44336"));
        }
        else if (bluePt > redPt)
        {
            winner.setText("BLUE TEAM WINS!!!");
            winner.setTextColor(Color.parseColor("#3F51B5"));
        }
        else
        {
            winner.setText("Its a tie!!!");
            winner.setTextColor(Color.parseColor("#000000"));
        }
    }

    public void restartButton(View view)
    {
        finish();
    }
}