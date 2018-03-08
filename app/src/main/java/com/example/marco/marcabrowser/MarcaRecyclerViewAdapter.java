package com.example.marco.marcabrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MarcaRecyclerViewAdapter extends RecyclerView.Adapter<MarcaRecyclerViewHolder> {

    private static final String LOG_TAG = MarcaRecyclerViewAdapter.class.getSimpleName();

    private List<Marca> mMarcaList;
    private Context     mContext;

    public MarcaRecyclerViewAdapter(Context context, List<Marca> marcaList) {
        mMarcaList = marcaList;
        mContext = context;
    }

    @Override
    public MarcaRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.browse, null, false);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(lp);

        MarcaRecyclerViewHolder marcaRecyclerViewHolder =
                new MarcaRecyclerViewHolder(view);

        return marcaRecyclerViewHolder;
    }

    @Override
    public int getItemCount() {
        return (mMarcaList != null ? mMarcaList.size() : 0 );
    }

    @Override
    public void onBindViewHolder(MarcaRecyclerViewHolder holder, int position) {
        Marca marcaItem = mMarcaList.get(position);

        Log.d(LOG_TAG, "Processing: " + marcaItem.getTitle() + " -> " + Integer.toString(position));

        Picasso.with(mContext).load(marcaItem.getImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.getThumbnail());

        holder.mTitle.setText(marcaItem.getTitle());
    }

    public void loadNewData(List<Marca> marcas){
        mMarcaList = marcas;

        notifyDataSetChanged();
    }

    public Marca getMarca(int position) {
        return (mMarcaList != null ? mMarcaList.get(position) : null );
    }
}





















