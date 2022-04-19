package com.example.detaylrecyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.detaylrecyclerview.databinding.FragmentAnasayfaBinding;

import java.util.ArrayList;


public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding tasarim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);

        tasarim.toolbarAnasayfa.setTitle("Filmler");
        tasarim.rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        ArrayList<Filmler> filmlerListesi = new ArrayList<>();
        Filmler f1 = new Filmler(1,"Anadoluda","anadoluda",2008,7.0,"Nuri Bilge Ceylan");
        Filmler f2 = new Filmler(2,"Django","django",2009,15.0,"Quentin Tarantino");
        Filmler f3 = new Filmler(3,"Inception","inception",2006,8.0,"Christopher Nolan");
        Filmler f4 = new Filmler(4,"Interstellar","interstellar",2013,9.0,"Christopher Nolan");
        Filmler f5 = new Filmler(5,"The Hateful Eight","thehatefuleight",2011,5.0,"Quentin Tarantino");
        Filmler f6 = new Filmler(6,"The Pianist","thepianist",200,12.99,"Christopher Nolan");
        filmlerListesi.add(f1);
        filmlerListesi.add(f2);
        filmlerListesi.add(f3);
        filmlerListesi.add(f4);
        filmlerListesi.add(f5);
        filmlerListesi.add(f6);

        FilmAdapter adapter = new FilmAdapter(requireContext(),filmlerListesi);
        tasarim.rv.setAdapter(adapter);

        return tasarim.getRoot();
    }

}