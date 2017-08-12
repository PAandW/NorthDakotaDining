package com.paandw.apps.northdakotadining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.paandw.apps.northdakotadining.menu.MenuFragment;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, new MenuFragment())
                .commit();
    }
}
