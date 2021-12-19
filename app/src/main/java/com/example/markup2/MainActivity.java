package com.example.markup2;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<Menu> menu = new ArrayList<Menu>();
    ArrayList<Product> coffeeProducts = new ArrayList<Product>();
    ArrayList<Product> teaProducts = new ArrayList<Product>();
    ArrayList<Product> milkshakeProducts = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();

        ClickMenu clickMenu = new ClickMenu(this, MainActivity2.class);

        RecyclerView list = (RecyclerView) findViewById(R.id.listMenu);
        MenuAdapter adapter = new MenuAdapter(this, menu, clickMenu);
        list.setAdapter(adapter);
    }

    private void setInitialData(){
        coffeeProducts.add(new Product("Latte art speciality", "Espresso with milk", R.drawable.latte,35));
        coffeeProducts.add(new Product("Long dark coffee", "Black Colombian coffee", R.drawable.long_dark_coffee,25));
        coffeeProducts.add(new Product("Caramel macchiato", "Macchiato with caramel and nuts", R.drawable.caramel_macchiato,40));

        milkshakeProducts.add(new Product("Strawberry milkshake", "Milkshake with strawberry", R.drawable.milk_strawberry,45));
        milkshakeProducts.add(new Product("Banana milkshake", "Milkshake with banana slices", R.drawable.milk_banana,45));
        milkshakeProducts.add(new Product("Chocolate milkshake", "Milkshake with chocolate", R.drawable.milk_chocolate,45));

        teaProducts.add(new Product("Black tea", "Black tea with lemon", R.drawable.bl_tea_lemon,25));
        teaProducts.add(new Product("Green tea", "Green tea with mint", R.drawable.gr_tea_mint,20));
        teaProducts.add(new Product("Relax green tea", "Relax green tea", R.drawable.gr_tea_relax,20));

        menu.add(new Menu ("Coffee", R.drawable.coffee, coffeeProducts));
        menu.add(new Menu ("Milkshake", R.drawable.milkshake, milkshakeProducts));
        menu.add(new Menu ("Tea", R.drawable.tea, teaProducts));
    }
}