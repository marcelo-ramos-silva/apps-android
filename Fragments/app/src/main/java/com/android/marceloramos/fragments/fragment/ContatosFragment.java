package com.android.marceloramos.fragments.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.marceloramos.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContatosFragment extends Fragment {

    private TextView textContato;


    public ContatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_contatos, container, false);
        /*View view = inflater.inflate(R.layout.fragment_contatos, container, false);

        textContato = view.findViewById(R.id.idTextContato);
        textContato.setText("Contatos Alterados!");

        return view;*/
    }

}
