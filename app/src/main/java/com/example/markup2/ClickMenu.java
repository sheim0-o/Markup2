package com.example.markup2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ClickMenu {
    private MainActivity view1;
    private Class<MainActivity2> view2;
    ClickMenu clickMenu = this;

    public ClickMenu(MainActivity view1, Class<MainActivity2> view2){
        this.view1 = view1;
        this.view2 = view2;
    }

    public void onClickEl(Context context, List<Product> products){
        RecyclerView list = (RecyclerView) this.view1.findViewById(R.id.listProduct);
        ProductAdapter adapter = new ProductAdapter(context, products, this.clickMenu);
        list.setAdapter(adapter);
    }

    public void onClickPrBtn(Product product){
        Intent intent = new Intent(this.view1, this.view2);
        intent.putExtra("name", product.getProductName());
        intent.putExtra("description", product.getProductDescription());
        intent.putExtra("cost", Integer.toString(product.getCost()));
        intent.putExtra("image", Integer.toString(product.getProductImage()));
        this.view1.startActivity(intent);
    }
}
