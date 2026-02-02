package com.example.makeupproject.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.makeupproject.R;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView back_btn= findViewById(R.id.imageView3);
        back_btn.setOnClickListener(v -> {
            Intent intent =new Intent(Product.this, Home.class);
            startActivity(intent);
        });
        ImageView settin= findViewById(R.id.icon2);
        settin.setOnClickListener(v -> {
            Intent intent =new Intent(Product.this, MainActivitySetting.class);
            startActivity(intent);
        });
        ImageView cart= findViewById(R.id.icon_cart);
        cart.setOnClickListener(v -> {
            Intent intent =new Intent(Product.this, Cart.class);
            startActivity(intent);
        });
        Button addcart= findViewById(R.id.add_to_cart_button);
        addcart.setOnClickListener(v -> {
            Intent intent =new Intent(Product.this, Cart.class);
            startActivity(intent);
        });
    }
}