package com.example.makeupproject.activites;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.makeupproject.R;

import java.util.ArrayList;
import modules.Product;
import adapters.MyProductsAdapter;
import db.DBHelper;

public class AllProduct extends AppCompatActivity {
    ListView listView;
    DBHelper dbHelper;
    ArrayList<Product> products;
    MyProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_product);
        listView = findViewById(R.id.listView);
        dbHelper = new DBHelper(this);

        products = dbHelper.getAllProducts();
        adapter = new MyProductsAdapter(products, this);
        listView.setAdapter(adapter);
        ImageView settin= findViewById(R.id.icon2);
        settin.setOnClickListener(v -> {
            Intent intent =new Intent(AllProduct.this, MainActivitySetting.class);
            startActivity(intent);
        });
        ImageView love= findViewById(R.id.icon1);
        love.setOnClickListener(v -> {
            Intent intent =new Intent(AllProduct.this, Home.class);
            startActivity(intent);
        });
        ImageView cart= findViewById(R.id.icon_cart);
        cart.setOnClickListener(v -> {
            Intent intent =new Intent(AllProduct.this, Cart.class);
            startActivity(intent);
        });
        Button btnAddProduct = findViewById(R.id.add_product);

        btnAddProduct.setOnClickListener(v -> {
            showAddDialog();
        });
    }
    private void showAddDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);

        EditText etName = dialog.findViewById(R.id.etProductName);
        Button btnSave = dialog.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if (!name.isEmpty()) {
                dbHelper.insertProduct(name, R.drawable.makeupp);
                products.clear();
                products.addAll(dbHelper.getAllProducts());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}