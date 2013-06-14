package com.fredrikpaasche.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fredrikpaasche.example.fragment.HierarchyFragment;
import com.fredrikpaasche.example.fragment.PeopleFragment;
import com.fredrikpaasche.example.fragment.PhotosFragment;
import com.fredrikpaasche.example.fragment.SettingsFragment;

public class PagerAdapter extends FragmentPagerAdapter {

	PeopleFragment peopleFragment;
	PhotosFragment photosFragment;
	HierarchyFragment hierarchyFragment;
	SettingsFragment settingsFragment;

	// Constructor
	public PagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			if (peopleFragment == null) {
				peopleFragment = new PeopleFragment();
			}
			return peopleFragment;

		case 1:
			if (photosFragment == null) {
				photosFragment = new PhotosFragment();
			}
			return photosFragment;

		case 2:
			if (hierarchyFragment == null) {
				hierarchyFragment = new HierarchyFragment();
			}
			return hierarchyFragment;

		case 3:
			if (settingsFragment == null) {
				settingsFragment = new SettingsFragment();
			}
			return settingsFragment;
		}
		return null;
	}
}
