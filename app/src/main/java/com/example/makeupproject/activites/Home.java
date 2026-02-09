package com.example.makeupproject.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.makeupproject.R;

import java.util.ArrayList;

import adapters.GradeAdapter;
import modules.Grade;

public class Home extends AppCompatActivity {


    GridView gv;
    ArrayList<Grade> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        gv=findViewById(R.id.gridview);

        Button pbtn= findViewById(R.id.Pbutton);
                pbtn.setOnClickListener(v -> {
                    Intent intent =new Intent(Home.this, Product.class);
                    startActivity(intent);
                });

        ImageView settin= findViewById(R.id.icon2);
        settin.setOnClickListener(v -> {
            Intent intent =new Intent(Home.this, MainActivitySetting.class);
            startActivity(intent);
        });
        ImageView love= findViewById(R.id.icon1);
        love.setOnClickListener(v -> {
            Intent intent =new Intent(Home.this, AllProduct.class);
            startActivity(intent);
        });
        ImageView cart= findViewById(R.id.icon_cart);
        cart.setOnClickListener(v -> {
            Intent intent =new Intent(Home.this, Cart.class);
            startActivity(intent);
        });
        ImageView searchimage=findViewById(R.id.search);
        searchimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, Search.class);
                startActivity(intent);
            }
        });
        productList=new ArrayList<>();
        productList.add(new Grade("Lipstick",R.drawable.lf));
        productList.add(new Grade("Foundation", R.drawable.fn));

        GradeAdapter adapter = new GradeAdapter(this,productList);
        gv.setAdapter(adapter);
    }
}
