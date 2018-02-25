package com.example.android.zahra_1202150246_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView title, liter;
    ImageView photo,baterry;
    private int liters = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String Title = intent.getStringExtra("Title");
        Integer Background = intent.getIntExtra("Background",0);

        title = (TextView)findViewById(R.id.detailTitle);
        liter = (TextView)findViewById(R.id.Liter);
        photo = (ImageView)findViewById(R.id.banner);
        baterry = (ImageView)findViewById(R.id.gallon);

        title.setText(Title);
        Bottle();
        photo.setImageResource(Background);
    }

    public void onClickPlus(View view) {
        liters++;
        Bottle();
    }

    public void onClickMinus(View view) {
        liters--;
        Bottle();
    }
    public void Bottle(){
        if (liters <= 0 ){
            liter.setText("2L");
            baterry.setImageResource(R.drawable.ic_gallon1);
            Toast.makeText(this,"Galon baru terisi sedikit",Toast.LENGTH_SHORT).show();
        }else if (liters == 1){
            liter.setText("5L");
            baterry.setImageResource(R.drawable.ic_gallon2);
        }else if(liters == 2){
            liter.setText("7L");
            baterry.setImageResource(R.drawable.ic_gallon3);
        }else if(liters == 3){
            liter.setText("9L");
            baterry.setImageResource(R.drawable.ic_gallon4);
        }else if(liters == 4){
            liter.setText("11L");
            baterry.setImageResource(R.drawable.ic_gallon5);
        }else if(liters == 5){
            liter.setText("15L");
            baterry.setImageResource(R.drawable.ic_gallon6);
        }else{
            // 100%
            liter.setText("19L");
            baterry.setImageResource(R.drawable.ic_gallon7);
            Toast.makeText(this,"Galon sudah penuh",Toast.LENGTH_SHORT).show();
        }
    }
}

