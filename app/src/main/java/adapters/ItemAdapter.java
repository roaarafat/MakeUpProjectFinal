package adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makeupproject.R;

import java.util.ArrayList;

import modules.Item;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolderClass> {
    ArrayList<Item> arrayList;
    Activity activity;

    public ItemAdapter(ArrayList<Item> arrayList, Activity activity) {
        this.arrayList = arrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_design, parent, false);
        return new ViewHolderClass(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        Item item = arrayList.get(position);
        holder.imageItem.setImageResource(item.getImage());
        holder.titleItem.setText(item.getName());
        holder.rating.setRating(item.getRating());
        holder.price.setText(item.getPrice() + "");
        holder.pricerr.setText(item.getPricerr() + "");
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {

        ImageView imageItem;
        TextView titleItem, price, pricerr;
        RatingBar rating;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.imageItem);
            titleItem = itemView.findViewById(R.id.titleItem);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);
            pricerr = itemView.findViewById(R.id.pricerr);
        }
    }
}
