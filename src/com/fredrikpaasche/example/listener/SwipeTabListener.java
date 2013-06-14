package com.fredrikpaasche.example.listener;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

// This class listens to events from the Action bar tabs
public class SwipeTabListener<T extends ActionBar.TabListener> {

	private Fragment fragment;
	private final Activity activity;
	private final String tag;
	private final Class<T> fragmentClass;

	// Constructor
	public SwipeTabListener(Activity activity, String tag, Class<T> fragmentClass) {
		this.activity = activity;
		this.tag = tag;
		this.fragmentClass = fragmentClass;
	}

	// A tab was selected
	public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {

		// Instantiate the fragment and add it to the root groupview of the activity
		if (fragment == null) {
			fragment = Fragment.instantiate(activity, fragmentClass.getName());
			fragmentTransaction.add(android.R.id.content, fragment, tag);
		}

		// Fragment is instantiated already, attach it so it will be shown
		else {
			fragmentTransaction.attach(fragment);
		}
	}

	// A tab was unselected. Detach the fragment.
	public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
		if (fragment != null) {
			fragmentTransaction.detach(fragment);
		}
	}

	public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
		// User selected the already selected tab, we do nothing.
	}
}
