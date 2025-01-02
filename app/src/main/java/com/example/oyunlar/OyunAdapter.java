package com.example.oyunlar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OyunAdapter extends BaseAdapter {
    Context context;
    ArrayList<Oyunlar> veriler;

    public OyunAdapter(Context context, ArrayList<Oyunlar> veriler) {
        this.context = context;
        this.veriler = veriler;
    }

    @Override
    public int getCount() {
        return veriler.size();
    }

    @Override
    public Object getItem(int i) {
        return veriler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View yeniGorunum = inflater.inflate(R.layout.oyun_item,null);

        TextView oyunAd = yeniGorunum.findViewById(R.id.txtAd);
        TextView oyunYil = yeniGorunum.findViewById(R.id.txtYil);
        TextView oyunBoyut = yeniGorunum.findViewById(R.id.txtBoyut);
        TextView oyunTur = yeniGorunum.findViewById(R.id.txtTur);
        ImageView oyunResim = yeniGorunum.findViewById(R.id.imgOyun);

        Picasso.get()
                .load(veriler.get(i).getOyunResim())
                .resize(150, 150)
                .centerCrop()
                .into(oyunResim);

        oyunAd.setText(veriler.get(i).getOyunAd());
        oyunYil.setText(veriler.get(i).getOyunYil());
        oyunBoyut.setText(veriler.get(i).getOyunBoyut());
        oyunTur.setText(veriler.get(i).getOyunTur());

        return yeniGorunum;
    }
}
