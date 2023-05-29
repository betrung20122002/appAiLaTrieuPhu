package com.example.appailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appailatrieuphu.object.Diem;
import com.example.appailatrieuphu.object.DiemDatabase;

public class LuuTen extends AppCompatActivity {

    private DiemDatabase diemDatabase;
    private EditText txtten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luu_ten);
        diemDatabase=new DiemDatabase(this);
        txtten=findViewById(R.id.txtTen);
    }

    public void LuuTen(View view) {
        Diem diem=new Diem();
        diem.setTen(txtten.getText()+"");
        if(diemDatabase.CheckTen(diem.getTen())){
            Intent intent=getIntent();
            String tienthuong=intent.getStringExtra("tien");
            diem.setTienThuong(Long.parseLong(tienthuong));
            long result=diemDatabase.insertDiemSo(diem);
            if(result>0){
                Toast.makeText(this,"Lưu thành công",Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(this,MainActivity.class);
                startActivity(intent1);
            }
            else {
                Toast.makeText(this, "Lỗi", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Tên đã tồn tại, vui lòng nhập tên khác", Toast.LENGTH_LONG).show();
        }

    }

    public void btnThoat(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}