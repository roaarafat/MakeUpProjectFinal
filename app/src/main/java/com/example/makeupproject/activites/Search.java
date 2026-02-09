package com.example.makeupproject.activites;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.makeupproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.MyProductsAdapter;
import api.AppController;
import api.SearchProduct;
import modules.Product;

public class Search extends AppCompatActivity {

    EditText serchet;
    Button searhbtn;
    private ListView listView;
    private MyProductsAdapter adapter;
    private ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        serchet = findViewById(R.id.serchet);
        searhbtn = findViewById(R.id.searhbtn);
        listView = findViewById(R.id.listView);

        adapter = new MyProductsAdapter(productList, this);
        listView.setAdapter(adapter);

        searhbtn.setOnClickListener(v -> {
            String keyword = serchet.getText().toString().trim();
            if (!keyword.isEmpty()) {
                searchProduct(keyword);
            } else {
                Toast.makeText(this, "write the name of product", Toast.LENGTH_SHORT).show();
            }
        });
}
    private void searchProduct(String keyword) {
        String link = SearchProduct.searchProducts(keyword);
        JsonObjectRequest js = new JsonObjectRequest(Request.Method.GET, link, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("SearchResponse", response.toString());
                try {
                    int count = response.optInt("count",0);
                    JSONArray entries = response.getJSONArray("products");
                    if(entries!=null && entries.length()>0){
                        for (int i=0;i<entries.length();i++){
                            JSONObject jsonObject = entries.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String title = jsonObject.getString("title");
                            Product p = new Product(id,title,R.drawable.history);
                            productList.add(p);
                        }
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Search.this, error+ "", Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(js);
    }
}