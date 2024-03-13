package com.example.dangnhap_week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtTaiKhoan, txtMatKhau;
    Button btnDN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTaiKhoan = (EditText) findViewById(R.id.txtTaiKhoan);
        txtMatKhau=(EditText) findViewById(R.id.txtMatKhau);
        btnDN = (Button) findViewById(R.id.btnDangNhap);
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtTaiKhoan.getText().toString().equals("LaDat") && txtMatKhau.getText().toString().equals("123456"))    {
                    // Chuyển hướng sang màn hình mới
                    Toast.makeText(getApplicationContext(), "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ThongTinCaNhan_week4.class);
                    startActivity(intent);
                    finish(); // Đóng màn hình hiện tại
                }
                else Toast.makeText(getApplicationContext(),"Dang nhap that bai", Toast.LENGTH_SHORT).show();
            }
        });
    }
}