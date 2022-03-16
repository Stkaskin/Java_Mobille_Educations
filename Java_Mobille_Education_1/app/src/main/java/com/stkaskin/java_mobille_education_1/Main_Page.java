package com.stkaskin.java_mobille_education_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class Main_Page extends AppCompatActivity {

    TextView pass,yas,hobi,ad,soy,wel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        user_info info = (user_info) getIntent().getSerializableExtra("info");
        pass=  findViewById(R.id.parola_tw);
        ad=findViewById(R.id.ad_tw);
        hobi=findViewById(R.id.hobi_tw);
        soy=findViewById(R.id.soyad_tw);
        yas=findViewById(R.id.yas_tw);
        wel=findViewById(R.id.welcome_tw);
        ad.setText("AD     :"+info.Ad);
        yas.setText("Yaş    :"+(2022 - Integer.parseInt(info.Dogum))+"");
        pass.setText("Parola :"+info.Parola);
        soy.setText("Soyad  :"+info.Soyad);
        wel.setText("Hoşgeldiniz sayın "+info.Ad+" "+info.Soyad);
        String hobis="Hobileriniz : \n";
        for (hobi a:info.hobiler) {

            hobis+=a.hobiadi+",";
        }
    hobis=    hobis.substring(0,hobis.length()-1);
        hobi.setText(hobis);
    }
    public void button_click(View v)
    {   this.finish();
      //  super.onBackPressed();

    }
}