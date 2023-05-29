package com.example.appailatrieuphu.object;

import java.util.ArrayList;
import java.util.Random;

public class FaceData {
    public FaceData() {
        taoCauHoi1();
    }

    public CauHoi taoCauHoi(int capDo) {
        Random r = new Random();
        ArrayList<CauHoi> arr = arrCauHoi.get(capDo - 1);
        return arr.get(r.nextInt(arr.size()));
    }

    ArrayList<ArrayList<CauHoi>> arrCauHoi = new ArrayList<>();

    public void taoCauHoi1() {
        ArrayList<CauHoi> arrCauSo1 = new ArrayList<>();
        arrCauSo1.add(taoCauHoi("Điền từ còn thiếu vào câu ca dao: \"Gần mực thì đen, gần đèn thì...\"gì?", "Sáng", "Chói&Lóa&Tối"));
        arrCauSo1.add(taoCauHoi("Mưa ngâu là vào khoảng tháng mấy trong năm?", "7", "1&4&6"));
        // arrCauSo1.add(taoCauHoi("","",""));
        arrCauHoi.add(arrCauSo1);

        ///cau so 2

        ArrayList<CauHoi> arrCauSo2 = new ArrayList<>();
        arrCauSo2.add(taoCauHoi("Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên", "Sinh nở&Sinh sôi&Sinh đẻ"));
        arrCauSo2.add(taoCauHoi("Pha màu đỏ với màu xanh lam, ta được màu nào sau đây?", "Tím", "Vàng&Xanh&Nâu"));
        arrCauHoi.add(arrCauSo2);
        ///cau so 2

        ArrayList<CauHoi> a3 = new ArrayList<>();
        a3.add(taoCauHoi("Đâu là một loại hình chợ tạm tự phát thường xuất hiện trong các khu dân cư?",
                "44 quả",
                "88 quả&50 quả&60 quả"));
        a3.add(taoCauHoi("Nhà bà có tất cả 64 quả bưởi và na, trong đó số quả na là 24, vậy số quả bưởi là:",
                "Cóc",
                "Ếch&Thằn lằn&Nhái"));
        a3.add(taoCauHoi("Hà có 35 lá cờ, Hà cho An 5 lá cờ và cho Lan 10 lá cờ, số lá cờ Hà còn lại",
                "20",
                "10&25&30"));
        arrCauHoi.add(a3);
        ArrayList<CauHoi> a4 = new ArrayList<>();
        a4.add(taoCauHoi("Đâu là tên một loại chợ?",
                "Cóc",
                "Ếch&Thằn lằn&Nhái"));
        arrCauHoi.add(a4);
        ArrayList<CauHoi> a5 = new ArrayList<>();
        a5.add(taoCauHoi("Đâu là tên một bãi biển ở Quảng Bình?",
                "Đá Nhảy",
                "Đá Bò&Đá Chạy& Đá Lăn"));
        arrCauHoi.add(a5);
        ArrayList<CauHoi> a6 = new ArrayList<>();
        a6.add(taoCauHoi("Haiku là thể thơ truyền thống của nước nào?",
                "Nhật Bản",
                "Mông Cổ&Hàn Quốc&Trung Quốc"));
        arrCauHoi.add(a6);
        ArrayList<CauHoi> a7 = new ArrayList<>();
        a7.add(taoCauHoi("Giải Grand Slam đầu tiên trong năm là giải nào?",
                "Austrlia mở rộng",
                "Wimbledon&Roland Garos&Mỹ mở rộng"));
        arrCauHoi.add(a7);
        ArrayList<CauHoi> a8 = new ArrayList<>();
        a8.add(taoCauHoi("Hệ thống đô thị ở Việt Nam được phân thành mấy loại?",
                "6",
                "5&4&3"));
        arrCauHoi.add(a8);
        ArrayList<CauHoi> a9 = new ArrayList<>();
        a9.add(taoCauHoi("Tính đến năm 2012, thành phố nào 3 lần đăng cai Thế vận hội mùa hè?",
                "London",
                "Paris&Chicago&Tokyo"));
        arrCauHoi.add(a9);
        ArrayList<CauHoi> a10 = new ArrayList<>();
        a10.add(taoCauHoi("Cơ quan nào sau đây dự trữ tỉ lệ glycogen cao nhất so với tỉ trọng của nó?",
                "Gan",
                "Não" + "&"+
                        "Cơ" + "&"+
                        "Mô mỡ"));
        arrCauHoi.add(a10);
        ArrayList<CauHoi> a11 = new ArrayList<>();
        a11.add(taoCauHoi("AFC Asian Cup 2011 được tổ chức tại quốc gia nào?",
                "Qatar",
                "Hàn Quốc" + "&"+
                        "Nhật Bản" + "&"+
                        "Iraq"));
        arrCauHoi.add(a11);
        ArrayList<CauHoi> a12 = new ArrayList<>();
        a12.add(taoCauHoi("Cầu thủ nào đạt danh hiệu Quả bóng vàng Việt Nam năm 2010?",
                "Vũ Phong",
                "Tấn Trường" + "&"+
                        "Minh Phương" + "&"+
                        "Trọng Hoàng"));
        arrCauHoi.add(a12);
        ArrayList<CauHoi> a13 = new ArrayList<>();
        a13.add(taoCauHoi("Trên mặt thoáng chất lỏng có hai quá trình ngược nhau, đó là sự bay hơi và gì?",
                "Sự ngưng tụ",
                "Sự đông đặc" + "&"+
                        "Sự kết tủa" + "&"+
                        "Sự thăng hoa"));
        arrCauHoi.add(a13);
        ArrayList<CauHoi> a14 = new ArrayList<>();
        a14.add(taoCauHoi("“Thiếu nữ bên hoa sen”,”Hai thiếu nữ và em bé”,”Thiếu nữ ngồi bên tranh tam đa” là bức tranh nổi tiếng của ai?\n" +
                        "\n",
                "Tô Ngọc Vân",
                "Bùi Xuân Phái" + "&"+
                        "Nguyễn Tư Nghiêm" + "&"+
                        "Nguyễn Sáng"));
        arrCauHoi.add(a14);
        ArrayList<CauHoi> a15 = new ArrayList<>();
        a15.add(taoCauHoi("Ca khúc nào đạt giải thưởng Bài hát Việt của năm 2010?",
                "Việt Nam",
                "Chênh vênh" + "&"+
                        "Chuông gió" + "&"+
                        "Đồng hồ treo tường"));
        arrCauHoi.add(a15);
    }

    private CauHoi taoCauHoi(String s1, String s2, String s3) {
        CauHoi c1 = new CauHoi();
        c1.setNoiDung(s1);
        c1.setDapAnDung(s2);
        c1.setArrDapAnSai(s3);
        return c1;
    }
}
