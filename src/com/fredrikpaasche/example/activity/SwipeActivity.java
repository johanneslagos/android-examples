package com.fredrikpaasche.example.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
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
		setContentView(R.layout.activity_swipe);
		setTitle(R.string.navigation_tabs);

		// Remember the view pager
		viewPager = (ViewPager) findViewById(R.id.view_pager);

		// When the pages are swiped, let the action bar tabs follow
		viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				getActionBar().setSelectedNavigationItem(position);
			}
		});

		// Set up a pager adapter
		FragmentManager fragmentManager = getSupportFragmentManager();
		pagerAdapter = new PagerAdapter(fragmentManager);

		// Connect the adapter to the view pager
		viewPager.setAdapter(pagerAdapter);

		// Specify that tabs should be displayed in the action bar.
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create a tab listener that is called when the user changes tabs.
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			// Tab was selected, move viewPager to correct page
			public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
				viewPager.setCurrentItem(tab.getPosition());
			}

			public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
				// hide the given tab
			}

			public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
				// probably ignore this event
			}
		};

		Tab tab = actionBar.newTab();
		tab.setText(R.string.people);
		tab.setTabListener(tabListener);
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.photos);
		tab.setTabListener(tabListener);
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.hierarchy);
		tab.setTabListener(tabListener);
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.settings);
		tab.setTabListener(tabListener);
		actionBar.addTab(tab);
	}

}
