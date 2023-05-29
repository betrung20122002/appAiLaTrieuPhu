package com.example.appailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appailatrieuphu.object.Diem;
import com.example.appailatrieuphu.object.DiemDatabase;

import java.util.ArrayList;
import java.util.List;

public class Bang_xep_hang extends AppCompatActivity {

    List<Diem> list=new ArrayList<>();
    ArrayAdapter<Diem> arrayAdapter;
    ListView listView;
    DiemDatabase diemDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_xep_hang);
        listView = findViewById(R.id.lsvBangXepHang);
        diemDatabase=new DiemDatabase(this);

        list=diemDatabase.getTopDiem();
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
    }

    public void btnThoat(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}