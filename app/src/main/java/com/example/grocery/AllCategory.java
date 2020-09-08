package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.grocery.adapter.AllCategoryAdapter;
import com.example.grocery.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
    RecyclerView allCategoryRecyclerView;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> allCategoriesList;
    ImageView backImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);
        allCategoryRecyclerView =findViewById(R.id.allCategoryRview);
        backImageView = findViewById(R.id.back);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(AllCategory.this , MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        allCategoriesList =new ArrayList<>();
        allCategoriesList.add(new AllCategoryModel(1,R.drawable.ic_veggies));
        allCategoriesList.add(new AllCategoryModel(2,R.drawable.ic_fruits));
        allCategoriesList.add(new AllCategoryModel(3,R.drawable.ic_juce));
        allCategoriesList.add(new AllCategoryModel(4,R.drawable.ic_dairy));
        allCategoriesList.add(new AllCategoryModel(5,R.drawable.ic_meat));
        allCategoriesList.add(new AllCategoryModel(6,R.drawable.ic_fish));
        allCategoriesList.add(new AllCategoryModel(7,R.drawable.ic_egg));
        allCategoriesList.add(new AllCategoryModel(8,R.drawable.ic_drink));
        allCategoriesList.add(new AllCategoryModel(9,R.drawable.ic_desert));
        allCategoriesList.add(new AllCategoryModel(10,R.drawable.ic_salad));
        allCategoriesList.add(new AllCategoryModel(11,R.drawable.ic_cookies));
        allCategoriesList.add(new AllCategoryModel(12,R.drawable.ic_spices));
        setAllCategoryRecycler();
    }

    private void setAllCategoryRecycler() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,4);
        allCategoryRecyclerView.setLayoutManager(layoutManager);

        allCategoryRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4 ,dpToPx(16) ,true) );
        allCategoryRecyclerView.setItemAnimator(new DefaultItemAnimator());

        allCategoryAdapter = new AllCategoryAdapter(this,allCategoriesList);
        allCategoryRecyclerView.setAdapter(allCategoryAdapter);
    }
    // now we need some item decoration class for manage spacing

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parentRecyclerView, RecyclerView.State state){
            int position = parentRecyclerView.getChildAdapterPosition(view); //Item Position
            int column = position % spanCount; //Items Column

            if (includeEdge){
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if(position < spanCount){ // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            }
            else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount){
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}