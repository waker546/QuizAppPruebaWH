package com.thebighutch.quizapppruebawh;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HintActivity extends AppCompatActivity {
    TextView hint;
    Button back;
    Button click;
    int clicks=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hint);
        hint=(TextView) findViewById(R.id.hintText);

        back=(Button) findViewById(R.id.bb);
        click=(Button) findViewById(R.id.clickerB);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicks>1){
                    clicks--;
                    click.setText(Integer.toString(clicks));
                }else{
                    clicks=0;
                    click.setText(Integer.toString(clicks));
                    click.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    hint.setText(getIntent().getStringExtra("HINT_TEXT"));
                }
            }
        });

    }
}