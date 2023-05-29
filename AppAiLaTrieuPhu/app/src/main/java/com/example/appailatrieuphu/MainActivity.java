package com.example.appailatrieuphu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnStartGame, btnTutorial, btnOutGame;
    public static MediaPlayer music;
    ImageButton btn_about,btn_bangxephang,btn_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if(SettiingActivity.musicEffectChecked)
        {
            SettiingActivity.musicsuccess = MediaPlayer.create(MainActivity.this,R.raw.right);
            SettiingActivity.musicfail  = MediaPlayer.create(MainActivity.this,R.raw.wrong);
        }
        if(music == null)
        {
            music = MediaPlayer.create(MainActivity.this,R.raw.start);
            music.setLooping(true);
            music.start();
        }
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnOutGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialogOutGame();
            }
        });

        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Huongdan.class));
            }
        });
        btn_bangxephang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Bang_xep_hang.class));
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);

                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(20);
                tv.setBackgroundColor(Color.GREEN);

                Typeface t = Typeface.create("serif", Typeface.BOLD_ITALIC);
                tv.setTypeface(t);
                tv.setPadding(5,5,5,5);
                tv.setText("Thành viên nhóm:\n 12520084 - Trần Quang Trung\n 10120692 - Nguyễn Huy Hoàng Phương");
                toast.setView(tv);
                toast.show();
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettiingActivity.class));
            }
        });
    }
    private void initView() {
        btnStartGame = findViewById(R.id.btn_start_game);
        btnOutGame = findViewById(R.id.btn_out_game);
        btnTutorial = findViewById(R.id.btn_tutorial);
        btn_bangxephang = findViewById(R.id.btn_high_score);
        btn_setting = findViewById(R.id.btn_setting);
        btn_about = findViewById(R.id.btn_about);
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setDialogOutGame();
    }

    private void setDialogOutGame() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_stop_game);
        TextView tvAnswer = (TextView) dialog.findViewById(R.id.tv_dialog_stop);
        tvAnswer.setText("Bạn có muốn thoát trò chơi không ?");
        Button btnOKStop = (Button) dialog.findViewById(R.id.btn_ok_stop_game);
        Button btnCancelStop = (Button) dialog.findViewById(R.id.btn_cancel_stop_game);
        btnOKStop.setText("OK");
        btnCancelStop.setText("Chơi tiếp!");

        btnOKStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        btnCancelStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}