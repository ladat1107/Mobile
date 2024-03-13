package com.example.dangnhap_week4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ThongTinCaNhan_week4 extends AppCompatActivity {

    EditText txtHoTen,txtCMND,txtBoSung;
    CheckBox chksach, chkcode, chkbao;
    Button btnGui;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan_week4);
        txtHoTen = (EditText) findViewById(R.id.edtHoTen);
        txtCMND = (EditText) findViewById(R.id.edtCMND);
        txtBoSung = (EditText) findViewById(R.id.edtBoSung);
        chkbao = (CheckBox) findViewById(R.id.chkdocbao);
        chkcode = (CheckBox) findViewById(R.id.chkdoccode);
        chksach = (CheckBox) findViewById(R.id.chkdocsach);
        radioGroup = (RadioGroup) findViewById(R.id.groupBangCap);
        btnGui = (Button) findViewById(R.id.btnguitt);
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Kiểm tra Họ tên đúng chuẩn
                String hoTen = txtHoTen.getText().toString();
                if(hoTen.length()<=3){
                    Toast.makeText(getApplicationContext(),"Họ tên phải nhiều hơn 3 ký tự", Toast.LENGTH_LONG).show();
                    txtHoTen.requestFocus();
                    txtHoTen.selectAll();
                    return;
                }
                //Kiểm tra CMND đúng ko
                String cmnd = txtCMND.getText().toString();
                if(cmnd.length()!=9){
                    Toast.makeText(getApplicationContext(),"CMND phải đủ 9 số", Toast.LENGTH_LONG).show();
                    txtCMND.requestFocus();
                    txtCMND.selectAll();
                    return;
                }
                //Kiểm tra bằng cấp
                int idgroup = radioGroup.getCheckedRadioButtonId();
                RadioButton radioBangCap = (RadioButton) findViewById(idgroup);
                String bangCap = radioBangCap.getText().toString();

                //Kiểm tra Sở thích
                String soThich = "Sở thích: ";
                if(chksach.isChecked()) soThich+=" Đọc sách - ";
                if (chkbao.isChecked()) soThich+= " Đọc báo - ";
                if (chkcode.isChecked()) soThich+=" Code ";
                String boSung = txtBoSung.getText().toString();
                if (boSung.length()==0) boSung="Không có";
                String output = hoTen+"\n"+cmnd +"\n" + bangCap+"\n"+soThich+"\n";
                output+="----------------THÔNG TIN BỔ SUNG-----------------\n";
                output+=boSung+"\n";
                output+="-------------------------------------------------------------------";

                AlertDialog.Builder mydialog = new AlertDialog.Builder(ThongTinCaNhan_week4.this);
                mydialog.setTitle("THÔNG TIN CÁ NHÂN");
                mydialog.setMessage(output);
                mydialog.setPositiveButton("ĐÓNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                mydialog.show();
            }
        });
    }
}