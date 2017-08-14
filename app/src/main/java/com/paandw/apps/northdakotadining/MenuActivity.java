package com.paandw.apps.northdakotadining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.paandw.apps.northdakotadining.view.pager.PagerFragment;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, new PagerFragment())
                .commit();
    }
}
