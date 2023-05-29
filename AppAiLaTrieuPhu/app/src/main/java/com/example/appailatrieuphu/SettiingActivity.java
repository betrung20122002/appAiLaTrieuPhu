package com.example.appailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class SettiingActivity extends AppCompatActivity {
    CheckBox CBmusic;
    CheckBox CBeffect;
    ImageButton back;
    public static MediaPlayer musicfail;
    public static MediaPlayer musicsuccess;
    public static boolean musicEffectChecked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settiing);
        CBmusic=(CheckBox)findViewById(R.id.CBMusic);
        CBeffect=(CheckBox)findViewById(R.id.CBEffect);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettiingActivity.this, MainActivity.class));
            }
        });
        CBmusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    MainActivity.music = MediaPlayer.create(SettiingActivity.this, R.raw.start);
                    MainActivity.music.setLooping(true);
                    MainActivity.music.start();
                }
                else MainActivity.music.stop();
            }
        });
        CBeffect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    musicEffectChecked=true;
                    musicsuccess = MediaPlayer.create(SettiingActivity.this, R.raw.right);
                    musicfail = MediaPlayer.create(SettiingActivity.this, R.raw.wrong);
                }
                else
                {
                    musicEffectChecked=false;
                    musicsuccess = null;
                    musicfail=null;
                }
            }
        });
    }

    public void btnThoat(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}