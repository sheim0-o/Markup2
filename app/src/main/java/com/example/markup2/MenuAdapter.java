package com.example.markup2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> implements View.OnClickListener{

    private final LayoutInflater inflater;
    private final List<Menu> menu;
    public Menu product;
    public ClickMenu mClickMenu;
    private Context mContext;

    MenuAdapter(Context context, List<Menu> menu, ClickMenu clickMenu) {
        this.mClickMenu = clickMenu;
        this.mContext = context;
        this.menu = menu;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.menu, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        this.product = menu.get(position);
        holder.flagView.setImageResource(product.getImage());
        holder.nameView.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    @Override
    public void onClick(View v) {
        TextView clickedName=(TextView)v.findViewById(R.id.nameOfTypeOfProduct);
        for(int i =0;i<menu.size(); i++) {
            if (clickedName.getText().toString().equals(menu.get(i).getName())) {
                mClickMenu.onClickEl(this.mContext, menu.get(i).getProducts());
            }
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            flagView = (ImageView)view.findViewById(R.id.imageOfTypeOfProduct);
            nameView = (TextView) view.findViewById(R.id.nameOfTypeOfProduct);
        }
    }
}