package com.example.markup2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends Activity {
    Integer amount, cost;
    TextView amountText, costText, nameText, descriptionText;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        amount = 1;

        String txtName = getIntent().getStringExtra("name");
        String txtDescription = getIntent().getStringExtra("description");
        Integer txtCost = Integer.parseInt(getIntent().getStringExtra("cost"));
        Integer txtImage = Integer.parseInt(getIntent().getStringExtra("image"));

        amountText = (TextView)findViewById(R.id.countOfAmount);
        costText = (TextView)findViewById(R.id.btnBuyLeftTxt);
        nameText = (TextView)findViewById(R.id.namePrchPage);
        descriptionText = (TextView)findViewById(R.id.descriptionPrchPage);
        image = (ImageView)findViewById(R.id.imgPrchPage);

        nameText.setText(txtName);
        descriptionText.setText(txtDescription);
        costText.setText(txtCost+"");
        image.setImageResource(txtImage);

        cost = txtCost*1000;
        changeAmountAndCost(amountText, costText);
    }

    public void changeAmountAndCost(TextView amountText, TextView costText){
        amountText.setText(amount+"");
        costText.setText("R. " + amount*cost);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case(R.id.btnAmountMinus):
                if(amount>=2)
                    amount--;
                changeAmountAndCost(amountText, costText);
                break;
            case(R.id.btnAmountPlus):
                if(amount<=9)
                    amount++;
                changeAmountAndCost(amountText, costText);
                break;
            case(R.id.btnBack):
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}