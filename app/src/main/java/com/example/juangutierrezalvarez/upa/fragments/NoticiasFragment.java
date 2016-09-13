package com.example.juangutierrezalvarez.upa.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.juangutierrezalvarez.upa.R;

/**
 * Created by juangutierrezalvarez on 28/3/16.
 */
public class NoticiasFragment extends Fragment {


    private LinearLayout ly_noticia;


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view =   inflater.inflate(R.layout.fragment_noticia,container,false);

        ly_noticia = (LinearLayout) view.findViewById(R.id.ly_noticia);

        ly_noticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(getActivity(),"holaa",Toast.LENGTH_SHORT).show();

                NoticiaDetailFragment noticiaDetailFragment = new NoticiaDetailFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flNoticias, noticiaDetailFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commitAllowingStateLoss();
            }
        });


        return view;
    }

}
