package com.fredrikpaasche.example.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;

import com.fredrikpaasche.example.R;
import com.fredrikpaasche.example.fragment.HierarchyFragment;
import com.fredrikpaasche.example.fragment.PeopleFragment;
import com.fredrikpaasche.example.fragment.PhotosFragment;
import com.fredrikpaasche.example.fragment.SettingsFragment;
import com.fredrikpaasche.example.listener.TabListener;

public class NavigationTabsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.navigation_tabs);

		// We dont use setContentView(). The root viewgroup is used as the
		// container for each fragment. This works since all fragments are full screen.

		// Make the action bar display tabs
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab tab = actionBar.newTab();
		tab.setText(R.string.people);
		tab.setTabListener(new TabListener<PeopleFragment>(this, "people", PeopleFragment.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.photos);
		tab.setTabListener(new TabListener<PhotosFragment>(this, "photos", PhotosFragment.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.hierarchy);
		tab.setTabListener(new TabListener<HierarchyFragment>(this, "hierarchy", HierarchyFragment.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.settings);
		tab.setTabListener(new TabListener<SettingsFragment>(this, "photos", SettingsFragment.class));
		actionBar.addTab(tab);
	}
}
