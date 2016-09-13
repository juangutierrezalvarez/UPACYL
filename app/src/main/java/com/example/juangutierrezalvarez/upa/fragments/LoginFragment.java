package com.example.juangutierrezalvarez.upa.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.juangutierrezalvarez.upa.R;

/**
 * Created by juangutierrezalvarez on 11/4/16.
 */
public class LoginFragment extends Fragment {


    private Button btLogin;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view =   inflater.inflate(R.layout.fragment_login,container,false);

        btLogin = (Button) view.findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NoticiasFragment noticiasFragment = new NoticiasFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flNoticias, noticiasFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commitAllowingStateLoss();

            }
        });


        return view;
    }


}
