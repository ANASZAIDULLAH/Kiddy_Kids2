package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class FirstB extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_b);

        tabLayout= findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.veiwpager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addfragment(new ToysFragment(),"TOYS");
        vpAdapter.addfragment(new FeedingFragment(),"FEEDING");
        vpAdapter.addfragment(new ClothingFregment(),"CLOTHES");
        viewPager.setAdapter(vpAdapter);
    }
}