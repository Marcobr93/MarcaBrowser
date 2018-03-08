package com.example.marco.marcabrowser;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetMarcaJsonData extends GetRawData {

    private static final String LOG_TAG = GetMarcaJsonData.class.getSimpleName();

    private List<Marca> mMarca;
    private Uri mDestinationUri;

    public GetMarcaJsonData(String searchCriteria, boolean matchAll) {
        super(null);
        createAndUpdateUri(searchCriteria, matchAll);
        mMarca = new ArrayList<>();
    }

    public List<Marca> getMarca() {
        return mMarca;
    }

    private boolean createAndUpdateUri(String searchCriteria, boolean matchAll) {
        final String MARCA_BASE_API_URL = "https://newsapi.org/v2/everything?sources=marca&apiKey=49cf272994044489a162711525a25530";
        final String TAGS_PARAM = "tags";
        final String TAGMODE_PARAM = "tagmode";
        final String FORMAT_PARAM = "format";

        mDestinationUri = Uri.parse(MARCA_BASE_API_URL).buildUpon()
                .appendQueryParameter(TAGS_PARAM, searchCriteria)
                .appendQueryParameter(TAGMODE_PARAM, (matchAll?"all":"any"))
                .appendQueryParameter(FORMAT_PARAM, "json")
                .build();

        return mDestinationUri != null;
    }

    private void processResult() {
        final String MARCA_ARTICLES = "articles";
        final String MARCA_AUTHOR = "author";
        final String MARCA_TITLE = "title";
        final String MARCA_DESCRIPTION = "description";
        final String MARCA_PHOTO_URL = "urlToImage";

        if ( getDownloadStatus() != DownloadStatus.OK ) {
            Log.e(LOG_TAG, "No se ha descargado el JSON");
            return;
        }

        try {
            JSONObject jsonData = new JSONObject(getData());
            JSONArray itemsArray = jsonData.getJSONArray(MARCA_ARTICLES);

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject jsonPhoto = itemsArray.getJSONObject(i);
                String author = jsonPhoto.getString(MARCA_AUTHOR);
                String title = jsonPhoto.getString(MARCA_TITLE);
                String description = jsonPhoto.getString(MARCA_DESCRIPTION);
                String photoUrl =  jsonPhoto.getString(MARCA_PHOTO_URL);

                Marca marca = new Marca(title,author,description,photoUrl);
                mMarca.add(marca);
            }

            for(Marca marca : mMarca){
                Log.d(LOG_TAG, "Marca: " + marca.toString());
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "No se puede crear el objeto JSON");
            e.printStackTrace();
        }
    }

    public void execute() {
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        Log.v(LOG_TAG, "Build Uri: " + mDestinationUri.toString());
        downloadJsonData.execute(mDestinationUri.toString());
    }

    public class DownloadJsonData extends DownloadRawData {

        @Override
        protected void onPostExecute(String webData) {
            super.onPostExecute(webData);
            processResult();
        }

        @Override
        protected String doInBackground(String... params) {
            String [] par = { mDestinationUri.toString() };

            return super.doInBackground(par);
        }
    }
}