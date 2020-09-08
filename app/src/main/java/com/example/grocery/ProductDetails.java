package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    ImageView imageViewProduct, imageViewBack;
    TextView txtName, txtDesc, txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent i =getIntent();
        String name = i.getStringExtra("name");
        String desc = i.getStringExtra("desc");
        String price = i.getStringExtra("price");
        int image = i.getIntExtra("image",R.drawable.b1);
        txtName = findViewById(R.id.lblPName);
        txtDesc = findViewById(R.id.lblPDesc);
        txtPrice = findViewById(R.id.lblPPrice);
        imageViewProduct= findViewById(R.id.imgProduct);
        imageViewBack = findViewById(R.id.imgBack);
        txtName.setText(name);
        txtPrice.setText(price);
        txtDesc.setText(desc);
        imageViewProduct.setImageResource(image);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProductDetails.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}