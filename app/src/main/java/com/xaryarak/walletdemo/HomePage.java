package com.xaryarak.walletdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xaryarak.walletdemo.Fragment.CategoryFg;
import com.xaryarak.walletdemo.Fragment.HomeFg;
import com.xaryarak.walletdemo.Fragment.SettingFg;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        loadFragment(new HomeFg(),true);

        FrameLayout flyout = findViewById(R.id.flayout);
        BottomNavigationView bottomnavi = findViewById(R.id.bottomnavi);

        bottomnavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home :
                        loadFragment(new HomeFg(),true);
                        break;
                    case R.id.category :
                        loadFragment(new CategoryFg(),true);
                        break;
                    case R.id.setting :
                        loadFragment(new SettingFg(),true);
                        break;
                }
                return true;
            }
        });

    }

    private void loadFragment(Fragment fragment,boolean stack){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(stack){
            transaction.addToBackStack(fragment.getTag());
        }
        transaction.replace(R.id.flayout,fragment);
        transaction.commit();
    }

}