package com.fredrikpaasche.example.activity;

import android.app.Activity;
import android.os.Bundle;

import com.fredrikpaasche.example.R;

public class NavigationTabsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_tabs);
		setTitle(R.string.navigation_tabs);
	}

}
