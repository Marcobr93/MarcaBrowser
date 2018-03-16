package com.example.marco.marcabrowser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.marco.marcabrowser.SearchActivity.MARCA_QUERY;

public class MainActivity extends BaseActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private List<Marca> mMarcaList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MarcaRecyclerViewAdapter mMarcaRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activateToolbar();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        mMarcaRecyclerViewAdapter = new MarcaRecyclerViewAdapter(
                MainActivity.this,
                new ArrayList<Marca>()
        );
        mRecyclerView.setAdapter(mMarcaRecyclerViewAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this,
                mRecyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(
                                MainActivity.this,
                                ViewNoticiaDetailsActivity.class
                        );

                        intent.putExtra(
                                MARCA_TRANSFER,
                                mMarcaRecyclerViewAdapter.getMarca(position)
                        );
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                }
        ));

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(
                        getApplicationContext()
                );

        String query = getSavedPreferenceData(MARCA_QUERY);

        if (query.length() > 0) {
            ProcessMarca processMarca = new ProcessMarca(query, true);
            processMarca.execute();
        }
    }

    private String getSavedPreferenceData(String marcaQuery) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        return sharedPreferences.getString(marcaQuery, "Real Madrid");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_settings) {
            return true;
        }

        if (id == R.id.menu_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ProcessMarca extends GetMarcaJsonData {

        public ProcessMarca(String searchCriteria, boolean matchAll) {
            super(searchCriteria, matchAll);
        }

        @Override
        public void execute() {
            super.execute();
            ProcessData processData = new ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            @Override
            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                mMarcaRecyclerViewAdapter.loadNewData(getMarca());
            }
        }
    }
}

