package com.stkaskin.java_mobille_education_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    EditText ad,pass,pass_a,date;
    TextView view_Error;
    CheckBox sey_chb,inter_chb,kitap_chb;
    Button login_Button;
 public int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void Button_Login(View v)
    {
        inter_chb=findViewById(R.id.internet_chb);
        kitap_chb=findViewById(R.id.kitap_chb);
        sey_chb=findViewById(R.id.seyahat_chb);
        date=findViewById(R.id.date_tb);
        ad=findViewById(R.id.ad_tb);
        pass=findViewById(R.id.pass_tb);
        pass_a=findViewById(R.id.pass_a_tb);
        inter_chb.isChecked();
        TextView error =findViewById(R.id.eroor);

        user_info info =new user_info();
        String[] split_s=(ad.getText()+"").split(" ");
        info.Ad=split_s[0]+"";
        info.Soyad=split_s.length>1?split_s[1]:"null";
        info.Dogum=date.getText()+"";

        info.Parola=pass.getText()+"";
        String pass2=pass_a.getText().toString();
        if (inter_chb.isChecked()) {
            hobi hobi=new hobi();
            hobi.hobiadi="İNTERNET";
            info.hobiler.add(hobi);
        }
        if (sey_chb.isChecked()) {
            hobi hobi=new hobi();
            hobi.hobiadi="SEYAHAT";
            info.hobiler.add(hobi);
        }
        if (kitap_chb.isChecked()) {
            hobi hobi=new hobi();
            hobi.hobiadi="KİTAP";
            info.hobiler.add(hobi);
        }

        if (!pass2.equals(info.Parola) || pass.length()==0 )
        {
            error.setText("Parola uyuşmuyor veya Geçersiz Parola");

        }
        else if (info.Ad.length()==0)
        {
            error.setText("Ad ve Soyad girin");

        }
        else if (info.Soyad.equals("null"))
        {
            error.setText("Soyad girin");

        }
        else if (info.Dogum.length()!=4)
        {
            error.setText("4 haneli doğum yılı girin");

        }
        else if (info.hobiler.size()==0)
        {
            error.setText("Lütfen Hobi Seçin");

        }
        else
            {
        Intent intent = new Intent(this,Main_Page.class);
        intent.putExtra("info",  info);
        intent.putExtra("intent",  this.getClass());
        startActivity(intent);
        }

    }

}