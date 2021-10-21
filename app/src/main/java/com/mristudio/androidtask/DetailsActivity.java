package com.mristudio.androidtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mristudio.androidtask.model.ItemModel;

import static android.content.ContentValues.TAG;

public class DetailsActivity extends AppCompatActivity {

    TextView tittle, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("Item Details ");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tittle = findViewById(R.id.tittle);
        description = findViewById(R.id.description);


        ItemModel itemModel = (ItemModel) getIntent().getSerializableExtra("model");
        getSupportActionBar().setTitle(itemModel.getTittle());
        if (itemModel != null) {
            tittle.setText(itemModel.getTittle());
            description.setText(itemModel.getDescription());
        } else {
            Log.e(TAG, "onCreate: null ");
        }
        Log.e(TAG, "onCreate: ");


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}