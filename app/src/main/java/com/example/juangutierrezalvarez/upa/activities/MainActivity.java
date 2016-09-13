package com.example.juangutierrezalvarez.upa.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.juangutierrezalvarez.upa.R;
import com.example.juangutierrezalvarez.upa.fragments.ConsultasFragment;
import com.example.juangutierrezalvarez.upa.fragments.LoginFragment;
import com.example.juangutierrezalvarez.upa.fragments.MensajesFragment;
import com.example.juangutierrezalvarez.upa.fragments.NoticiaDetailFragment;
import com.example.juangutierrezalvarez.upa.fragments.NoticiasFragment;
import com.example.juangutierrezalvarez.upa.fragments.SedesFragment;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    //menu lateral
    private DrawerLayout mDrawerLayout = null;
    private ListView lvMenu;
    private String[] mMenuArray;
    String[] arrayMenu = new String[] { "Noticias", "Consultas", "Sedes", "Mensajes"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //actionBar();
        drawerLayout();

        LoginFragment loginFragment = new LoginFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.flNoticias, loginFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();

    }



    private void drawerLayout() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        lvMenu = (ListView) findViewById(R.id.lvMenu);

        // Set the adapter for the list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayMenu);

        // Assign adapter to ListView
        lvMenu.setAdapter(adapter);

        // Set the list's click listener
        lvMenu.setOnItemClickListener(new DrawerItemClickListener());


    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);

            if (position == 0)
            {
                NoticiasFragment noticiasFragment = new NoticiasFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flNoticias, noticiasFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commitAllowingStateLoss();
            }
            if (position == 1)
            {
                MensajesFragment mensajesFragment = new MensajesFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flNoticias, mensajesFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commitAllowingStateLoss();
            }
            if (position == 2)
            {
                ConsultasFragment consultasFragment = new ConsultasFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flNoticias, consultasFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commitAllowingStateLoss();
            }
            if (position == 3)
            {
                SedesFragment sedesFragment = new SedesFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flNoticias, sedesFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commitAllowingStateLoss();
            }

            mDrawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position

        // Highlight the selected item, update the title, and close the drawer
        lvMenu.setItemChecked(position, true);
        setTitle(arrayMenu[position]);


        // mDrawerLayout.closeDrawer(lvMenu);
    }

    private void actionBar() {

        //toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        //setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle(R.string.upa);//titulo del toolbar

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.home_action_bar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)//Para los que no tengan lollipop
            getWindow().setStatusBarColor(getResources().getColor(R.color.orange_upa));
    }


}
