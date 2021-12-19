package com.example.markup2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Product> products;
    public Product product;
    public ClickMenu mClickMenu;

    ProductAdapter(Context context, List<Product> products, ClickMenu clickMenu) {
        this.mClickMenu = clickMenu;
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        this.product = products.get(position);
        holder.flagView.setImageResource(product.getProductImage());
        holder.nameView.setText(product.getProductName());
        holder.descriptionView.setText(product.getProductDescription());
        holder.costView.setText(product.getCost()+ "k");

        holder.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i =0;i<products.size(); i++) {
                    if (holder.nameView.getText().toString().equals(products.get(i).getProductName())) {
                        mClickMenu.onClickPrBtn(products.get(i));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView, descriptionView, costView;
        final Button button;
        ViewHolder(View view){
            super(view);
            flagView = (ImageView)view.findViewById(R.id.imageOfProduct);
            nameView = (TextView) view.findViewById(R.id.nameOfProduct);
            descriptionView = (TextView) view.findViewById(R.id.description);
            costView = (TextView) view.findViewById(R.id.cost);

            button = (Button) view.findViewById(R.id.btnBuy);
        }
    }
}