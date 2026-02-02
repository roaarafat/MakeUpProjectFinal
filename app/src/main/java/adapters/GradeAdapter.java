package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import com.example.makeupproject.R;

import java.util.ArrayList;
import java.util.List;
import com.example.makeupproject.activites.Product;
import modules.Grade;

public class GradeAdapter extends BaseAdapter {

    Context context ;
    List<Grade> productList = new ArrayList<>();
    LayoutInflater inflater;

    public GradeAdapter(Context context, List<Grade> itemArrayList) {
        this.context = context;
        this.productList = itemArrayList;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getImageId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = inflater.inflate(R.layout.itemgradveiw,null);
        ImageView imageItem= root.findViewById(R.id.gradImage);
        TextView textItem = root.findViewById(R.id.gradeName);
        Button btn = root.findViewById(R.id.con_btn);
        Grade product = productList.get(position);
        imageItem.setImageResource(productList.get(position).getImageId());
        textItem.setText(productList.get(position).getName());
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(context, Product.class);
            context.startActivity(intent);
        });
        return root;
    }
}
