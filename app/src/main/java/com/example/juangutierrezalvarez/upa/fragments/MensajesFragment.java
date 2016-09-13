package com.example.juangutierrezalvarez.upa.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.juangutierrezalvarez.upa.R;

/**
 * Created by juangutierrezalvarez on 7/4/16.
 */
public class MensajesFragment extends Fragment {


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view =   inflater.inflate(R.layout.fragment_mensajes,container,false);


        return view;
    }

}
