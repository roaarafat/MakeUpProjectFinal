package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.makeupproject.R;

import java.util.ArrayList;

import modules.Product;

public class MyProductsAdapter extends BaseAdapter {
    ArrayList<Product> productArrayList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public MyProductsAdapter(ArrayList<Product> productArrayList, Context context) {
        this.productArrayList = productArrayList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return productArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return productArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return productArrayList.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View root = layoutInflater.inflate(R.layout.product_item, null);
        ImageView imgProduct = root.findViewById(R.id.img_product);
        TextView productName = root.findViewById(R.id.product_name);
        imgProduct.setImageResource(productArrayList.get(i).getImg());
        productName.setText(productArrayList.get(i).getName());
        return root;
    }
}
