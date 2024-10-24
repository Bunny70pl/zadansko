package com.example.galerianieruszaj3a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ZdjZOpisem> obrazki= new ArrayList<>();
    private int licznikI;
    private Button poprzedni;
    private Button nastepeny;
    private Button polub;
    private ImageView poleZdjecia;
    private TextView dobraNowina;
    private TextView tekstPolubien;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poprzedni = findViewById(R.id.button);
        nastepeny = findViewById(R.id.button2);
        polub = findViewById(R.id.button3);
        poleZdjecia = findViewById(R.id.imageView);
        dobraNowina = findViewById(R.id.textView1);
        tekstPolubien = findViewById(R.id.textView2);
        if(savedInstanceState != null){
            licznikI = savedInstanceState.getInt("licznikI",0);
        }
        ZdjZOpisem pies1 = new ZdjZOpisem(R.drawable.pies1,"Dobrego dnia");
        ZdjZOpisem pies2 = new ZdjZOpisem(R.drawable.pies2,"Ten dzien bedzie dobry");
        ZdjZOpisem pies3 = new ZdjZOpisem(R.drawable.pies3,"Powodzenia dzisiaj");
        ZdjZOpisem pies4 = new ZdjZOpisem(R.drawable.pies4,"Oby bylo dobrze");
        ZdjZOpisem pies5 = new ZdjZOpisem(R.drawable.pies5,"Bedzie super");
        obrazki.add(pies1);
        obrazki.add(pies2);
        obrazki.add(pies3);
        obrazki.add(pies4);
        obrazki.add(pies5);
        poleZdjecia.setImageResource(obrazki.get(licznikI).getZdjPsa());
        dobraNowina.setText(obrazki.get(licznikI).getOpis());
        tekstPolubien.setText("Liczba polubien: "+String.valueOf(obrazki.get(licznikI).getLiczbaPolubien()));
        poprzedni.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        licznikI--;
                        if(licznikI<=0){
                            licznikI = 4;
                        }
                        poleZdjecia.setImageResource(obrazki.get(licznikI).getZdjPsa());
                        dobraNowina.setText(obrazki.get(licznikI).getOpis());
                        tekstPolubien.setText("Liczba polubien: "+String.valueOf(obrazki.get(licznikI).getLiczbaPolubien()));
                    }
                }
        );
        nastepeny.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        licznikI++;
                        if(licznikI>=4){
                            licznikI = 0;
                        }
                        poleZdjecia.setImageResource(obrazki.get(licznikI).getZdjPsa());
                        dobraNowina.setText(obrazki.get(licznikI).getOpis());
                        tekstPolubien.setText("Liczba polubien: "+String.valueOf(obrazki.get(licznikI).getLiczbaPolubien()));
                    }
                }
        );
        polub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        obrazki.get(licznikI).polub();
                        tekstPolubien.setText("Liczba polubien: "+String.valueOf(obrazki.get(licznikI).getLiczbaPolubien()));
                    }
                }
        );
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("licznikI",licznikI);
    }
}