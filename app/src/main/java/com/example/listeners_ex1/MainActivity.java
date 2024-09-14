package com.example.listeners_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener
{
    Button redTeam,blueTeam;
    int redCount,blueCount;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        redTeam = findViewById(R.id.redButton);
        blueTeam = findViewById(R.id.blueButton);

        redCount = 0;
        blueCount = 0;

        redTeam.setOnLongClickListener(this);

        blueTeam.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                blueCount +=1;
            }
        });


    }

    @Override
    public boolean onLongClick(View v)
    {
        redCount += 2;
        return false;
    }

    public void results(View view)
    {
        Intent giveResults = new Intent(this, resultScreen.class);
        giveResults.putExtra("blueCount", blueCount);
        giveResults.putExtra("redCount",redCount);
        redCount = 0;
        blueCount = 0;
        startActivity(giveResults);
    }
}