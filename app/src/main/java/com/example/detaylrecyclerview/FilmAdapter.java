package com.example.detaylrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.detaylrecyclerview.databinding.CardTasarimBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<Filmler> filmlerListesi;

    public FilmAdapter(Context mContext, List<Filmler> filmlerListesi) {
        this.mContext = mContext;
        this.filmlerListesi = filmlerListesi;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;
        public CardTasarimTutucu( CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Filmler film = filmlerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        //This is for get image id as a string and adapt it
        t.imageViewFilmResim.setImageResource(
                mContext.getResources().getIdentifier(film.getFilmResimAdi(),"drawable",mContext.getPackageName()));
        t.textViewFilmAdi.setText(film.getFilmAdi());
        t.textViewFilmFiyat.setText(film.getFilmFiyat()+" ₺");
        t.buttonSepeteEkle.setOnClickListener(view -> {
            Snackbar.make(view,film.getFilmAdi()+" sepete eklendi!",Snackbar.LENGTH_SHORT).show();
        });


    }

    @Override
    public int getItemCount() {
        return filmlerListesi.size();
    }
}
