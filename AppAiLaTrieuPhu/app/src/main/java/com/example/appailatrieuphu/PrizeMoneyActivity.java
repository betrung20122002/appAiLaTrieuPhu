package com.example.appailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class PrizeMoneyActivity extends AppCompatActivity {
    TextView btn_dialog;
    Button back_main;
    ArrayList<String> arrTienThuong;
    String diem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_money);
        AnhXa();
        Intent intent=getIntent();
        diem=intent.getStringExtra("key_stop");
        btn_dialog.setText("Bạn sẽ ra về với tiền thưởng là  "+diem+"VNĐ");
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrizeMoneyActivity.this, MainActivity.class));
            }
        });
    }

    private void AnhXa() {
        btn_dialog = findViewById(R.id.btn_dialog);
        back_main = findViewById(R.id.back_main);
    }
}