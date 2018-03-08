package com.example.marco.marcabrowser;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPhotoDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marca_details);

        activateToolbarWithBackEnabled();

        Intent intent = getIntent();
        Marca marca = (Marca) intent.getSerializableExtra(PHOTO_TRANSFER);

        TextView photoTitle = findViewById(R.id.marca_title);
        photoTitle.setText(marca.getTitle());

        TextView photoTags = findViewById(R.id.marca_description);
        photoTags.setText(marca.getmDescription());

        TextView photoAuthor = findViewById(R.id.marca_author);
        photoAuthor.setText(marca.getAuthor());

        ImageView photoImage = findViewById(R.id.marca_image);
        Picasso.with(this).load(marca.getImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(photoImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_photo_details, menu);

        return true;
    }
}
