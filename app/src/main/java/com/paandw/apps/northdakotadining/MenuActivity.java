package com.paandw.apps.northdakotadining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.paandw.apps.northdakotadining.view.pager.PagerFragment;

import icepick.Icepick;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if(savedInstanceState != null){
            Icepick.restoreInstanceState(getSupportFragmentManager().findFragmentByTag("pager"), savedInstanceState);
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new PagerFragment(), "pager")
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(getSupportFragmentManager().findFragmentByTag("pager"), outState);
    }
}
