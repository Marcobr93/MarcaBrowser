package com.example.marco.marcabrowser;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewNoticiaDetailsActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marca_details);

        activateToolbarWithBackEnabled();

        Intent intent = getIntent();
        Marca marca = (Marca) intent.getSerializableExtra(MARCA_TRANSFER);

        TextView marcaTitle = findViewById(R.id.marca_title);
        marcaTitle.setText(marca.getTitle());

        TextView marcaDescription = findViewById(R.id.marca_description);
        marcaDescription.setText(marca.getmDescription());
        marcaDescription.setMovementMethod(new ScrollingMovementMethod());

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
