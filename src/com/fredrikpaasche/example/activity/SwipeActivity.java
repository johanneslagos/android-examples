package com.fredrikpaasche.example.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.fredrikpaasche.example.R;
import com.fredrikpaasche.example.adapter.PagerAdapter;

public class SwipeActivity extends FragmentActivity {
	
	PagerAdapter pagerAdapter;
	ViewPager viewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.navigation_tabs);
		setContentView(R.layout.activity_swipe);

		// Remember the view pager
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        // Set up a pager adapter
		FragmentManager fragmentManager = getSupportFragmentManager();
        pagerAdapter = new PagerAdapter(fragmentManager);
        
        // Connect the adapter to the view pager
        viewPager.setAdapter(pagerAdapter);
	}
}
