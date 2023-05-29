package com.example.appailatrieuphu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appailatrieuphu.adapter.TienThuongAdapter;
import com.example.appailatrieuphu.object.CauHoi;
import com.example.appailatrieuphu.object.FaceData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    ListView lsvTienThuong;
    TienThuongAdapter tienThuongAdapter;
    ArrayList<String> arrTienThuong;
    CauHoi cauHoi;
    public static int viTriCauHoi = 1;
    View.OnClickListener listener;
    TextView txvCauHoi, txvCauTL1, txvCauTL2, txvCauTL3, txvCauTL4, txvThuaGame;
    ArrayList<TextView> arrTxvCauTraLoi;
    String cauTraoLoi;
    String prizeMoney="0";
    private Dialog dialog;
    FaceData faceData;
    private Button btnStopGame;
    MediaPlayer correct, incorrect;
    private ImageView  imgHeplPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        anhXa();
        setUp();
        setClick();
        setStopGame();
    }
    boolean isHeplCall = true;
    private void setStopGame() {
        btnStopGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienthuong();
                AlertDialog.Builder b=new AlertDialog.Builder(MainActivity2.this);
                b.setTitle("Điểm của bạn là "+ listtt[viTriCauHoi]);
                b.setMessage("Bạn có muôn lưu tên không?");
                b.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity2.this, LuuTen.class);
                        long tienThuong=listtt[viTriCauHoi];
                        intent.putExtra("tien",tienThuong+"");
                        startActivity(intent);
                    }
                });
                b.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                b.create().show();
            }
        });
    }


    public void init() {
        arrTienThuong = new ArrayList<>();
        arrTienThuong.add("150.000.000");
        arrTienThuong.add("85.000.000");
        arrTienThuong.add("60.000.000");
        arrTienThuong.add("40.000.000");
        arrTienThuong.add("30.000.000");
        arrTienThuong.add("22.000.000");
        arrTienThuong.add("14.000.000");
        arrTienThuong.add("10.000.000");
        arrTienThuong.add("6.000.000");
        arrTienThuong.add("3.000.000");
        arrTienThuong.add("2.000.000");
        arrTienThuong.add("1.000.000");
        arrTienThuong.add("600.000");
        arrTienThuong.add("400.000");
        arrTienThuong.add("200.000");

        tienThuongAdapter = new TienThuongAdapter(this, 0, arrTienThuong);

        cauHoi = new CauHoi();

        arrTxvCauTraLoi = new ArrayList<>();

        faceData = new FaceData();
    }

    public void anhXa() {
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
        txvCauHoi = findViewById(R.id.txvCauHoi);
        txvCauTL1 = findViewById(R.id.txvCauTL1);
        txvCauTL2 = findViewById(R.id.txvCauTL2);
        txvCauTL3 = findViewById(R.id.txvCauTL3);
        txvCauTL4 = findViewById(R.id.txvCauTL4);
        txvThuaGame = findViewById(R.id.txvThuaGame);

        arrTxvCauTraLoi.add(txvCauTL1);
        arrTxvCauTraLoi.add(txvCauTL2);
        arrTxvCauTraLoi.add(txvCauTL3);
        arrTxvCauTraLoi.add(txvCauTL4);

        btnStopGame = findViewById(R.id.btn_stop_game);

        correct = MediaPlayer.create(this, R.raw.right);
        incorrect = MediaPlayer.create(this, R.raw.wrong);

        imgHeplPhone = findViewById(R.id.help_phone);
    }

    public void setUp() {
        txvThuaGame.setVisibility(View.GONE);
        lsvTienThuong.setAdapter(tienThuongAdapter);
        hienCauHoi();
    }

    public void setClick() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCauTraLoi(((TextView) view));
            }
        };
        for (TextView t : arrTxvCauTraLoi) {
            t.setOnClickListener(listener);
        }
    }

    public void checkCauTraLoi(final TextView txv) {
        cauTraoLoi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_cau_chon);

        new CountDownTimer(2000, 100) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                for (TextView t : arrTxvCauTraLoi) {
                    String s = t.getText().toString();
                    if (s.equals(cauHoi.getDapAnDung())) {
                        t.setBackgroundResource(R.drawable.bg_cau_dung);
                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        if (cauTraoLoi.equals(cauHoi.getDapAnDung())) {
                            correct.start();
                            viTriCauHoi++;
                            if (viTriCauHoi > 15) {
                                viTriCauHoi = 15;
                                txvThuaGame.setVisibility(View.VISIBLE);
                                LuuTen();
                                return;
                            }
                            hienCauHoi();
                        } else {
                            txvThuaGame.setVisibility(View.VISIBLE);
                            //int posOfPrizeMoney = (posOfQuestion / 5) * 5;
                            int posOfPrizeMoney = viTriCauHoi;
                            Intent intent = new Intent(MainActivity2.this, PrizeMoneyActivity.class);
                            //String prizeMoney;
                            if (posOfPrizeMoney <= 4) {
                                prizeMoney = arrTienThuong.get(14);
                            } else if (posOfPrizeMoney > 5 && posOfPrizeMoney < 11) {
                                prizeMoney = arrTienThuong.get(10);
                            } else if (posOfPrizeMoney >= 10 && posOfPrizeMoney < 13) {
                                prizeMoney = arrTienThuong.get(5);
                            } else {
                                prizeMoney = arrTienThuong.get(0);
                            }
                            //String prizeMoney = arrPrizeMoney.get(14 - posOfPrizeMoney);
                            Bundle bundle = new Bundle();
                            bundle.putString("key_end", prizeMoney);
                            bundle.putBoolean("isEnd", true);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }
                }.start();
            }
        }.start();

    }

    public void setCauHoi() {
        cauHoi = faceData.taoCauHoi(viTriCauHoi);
    }

    public void hienCauHoi() {
        setCauHoi();
        txvCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int vt1 = r.nextInt(arrCauTraLoi.size());
            int vt2 = r.nextInt(arrCauTraLoi.size());
            String a = arrCauTraLoi.get(vt1);// 0 1 2 3
            arrCauTraLoi.set(vt1, arrCauTraLoi.get(vt2));
            arrCauTraLoi.set(vt2, a);
        }

        for (int i = 0; i < arrTxvCauTraLoi.size(); i++) {
            arrTxvCauTraLoi.get(i).setOnClickListener(listener);
            arrTxvCauTraLoi.get(i).setVisibility(View.VISIBLE);
            arrTxvCauTraLoi.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrTxvCauTraLoi.get(i).setText(arrCauTraLoi.get(i));
        }

        tienThuongAdapter.setViTriCauHoi(viTriCauHoi);
    }

    boolean troGiup5050 = true;
    public void trogiup5050(View view) {
        if(troGiup5050 == false){
            return;
        }
        Random r= new Random();
        int sodanAnAnDi =2;
        do{
            int vitriDanAnAn = r.nextInt(4);// 1
            TextView t = arrTxvCauTraLoi.get(vitriDanAnAn);

            if(t.getVisibility() == View.VISIBLE && t.getText().toString().equals(cauHoi.getDapAnDung())==false){
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                sodanAnAnDi --;
            }
        }while (sodanAnAnDi>0);
        troGiup5050 = false;
    }

    boolean troGiupKhanGia = true;
    public void troGiupKhanGia(View view) {
        if (troGiupKhanGia == false){
            return;
        }
        for (int i=0;i<arrTxvCauTraLoi.size();i++){
            TextView t = arrTxvCauTraLoi.get(i);
            if(t.getText().toString().equals(cauHoi.getDapAnDung())){
                new DialogKhanGiaTraLoi(this,i+1).show();
                break;
            }
        }
        troGiupKhanGia =false;
    }

    boolean troGiupDoiCauHoi = true;
    public void trogiupDoiCauHoi(View view) {
        if(troGiupDoiCauHoi == false){
            return;
        }
        hienCauHoi();
        troGiupDoiCauHoi =false;
    }
    public void troGiupPhone(View view)
    {
        imgHeplPhone.setEnabled(false);
        showDialog();
    }
    public void showDialog() {
        dialog = new Dialog(MainActivity2.this);
        dialog.setTitle("Trợ giúp gọi điện thoại");
        dialog.setContentView(R.layout.dialog_goi_dien);
        dialog.show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        correct.release();
        incorrect.release();
        finish();
    }
    public void btnTom(View view) {
        showAlertDialog();
    }
    public void btnDoremon(View view) {
        showAlertDialog();
    }

    public void btnProfessor(View view) {
        showAlertDialog();
    }
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Đáp án của mình là "+cauHoi.getDapAnDung());
        builder.setCancelable(false);
        builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    long[] listtt;
    int k;
    public void tienthuong(){
        listtt=new long[16];
        listtt[1]=200000;
        listtt[2]=400000;
        listtt[3]=600000;
        listtt[4]=1000000;
        listtt[5]=2000000;
        listtt[6]=3000000;
        listtt[7]=6000000;
        listtt[8]=10000000;
        listtt[9]=14000000;
        listtt[10]=22000000;
        listtt[11]=30000000;
        listtt[12]=40000000;
        listtt[13]=60000000;
        listtt[14]=85000000;
        listtt[15]=150000000;
    }
    public void LuuTen(){
       tienthuong();
        k=viTriCauHoi;
        if(k<5){
            k=1;
        }
        if(k>=5&&k<10){
            k=5;
        }
        if(k>=10&&k<15){
            k=10;
        }
        AlertDialog.Builder b=new AlertDialog.Builder(MainActivity2.this);
        if(k==16){
            b.setTitle("XIN CHÚC MỪNG BẠN LÀ MỘT THIÊN TÀI\n"+"Bạn đã đạt tiền thưởng tối đa\n"+"Điểm của bạn là "+ listtt[k-1]);
        }else {
            b.setTitle("Điểm của bạn là "+ listtt[k]);
        }
        b.setMessage("Bạn có muôn lưu tên không?");
        b.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity2.this, LuuTen.class);
                long tienThuong=listtt[k];
                intent.putExtra("tien",tienThuong+"");
                startActivity(intent);
            }
        });
        b.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        b.create().show();
    }

}