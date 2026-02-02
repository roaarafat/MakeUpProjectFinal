package com.example.makeupproject.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupproject.R;

import java.util.ArrayList;

import adapters.ItemAdapter;
import modules.Item;

public class Cart extends AppCompatActivity {
    RecyclerView rv;
    ItemAdapter adapter;
    ArrayList<Item> cartItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        rv=findViewById(R.id.cartList);
        Button order = findViewById(R.id.con_order);
        order.setOnClickListener(v -> {
            Intent intent = new Intent(Cart.this, Delivery.class);
            startActivity(intent);
        });
        ImageView settin = findViewById(R.id.icon2);
        settin.setOnClickListener(v -> {
            Intent intent = new Intent(Cart.this, MainActivitySetting.class);
            startActivity(intent);
        });
        cartItem = new ArrayList<>();
        cartItem.add(new Item(1,"Lipstick Revlon",4,30f,300,R.drawable.lf));
        cartItem.add(new Item(2,"Foundation Maybelline",3,50f,330,R.drawable.fn));
        cartItem.add(new Item(3,"Concealer Tarte",5,20f,400,R.drawable.ct));
        adapter= new ItemAdapter(cartItem,Cart.this);
        rv.setLayoutManager(new LinearLayoutManager(Cart.this));
        rv.setAdapter(adapter);
    }
}

