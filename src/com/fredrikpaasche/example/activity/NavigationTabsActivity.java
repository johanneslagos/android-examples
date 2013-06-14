package com.fredrikpaasche.example.activity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;

import com.fredrikpaasche.example.R;
import com.fredrikpaasche.example.fragment.DemoFragment1;
import com.fredrikpaasche.example.fragment.DemoFragment2;
import com.fredrikpaasche.example.fragment.DemoFragment3;
import com.fredrikpaasche.example.fragment.DemoFragment4;
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
		tab.setText(R.string.page1);
		tab.setTabListener(new TabListener<DemoFragment1>(this, "demo1", DemoFragment1.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.page2);
		tab.setTabListener(new TabListener<DemoFragment2>(this, "demo2", DemoFragment2.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.page3);
		tab.setTabListener(new TabListener<DemoFragment3>(this, "demo3", DemoFragment3.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab();
		tab.setText(R.string.page4);
		tab.setTabListener(new TabListener<DemoFragment4>(this, "demo4", DemoFragment4.class));
		actionBar.addTab(tab);
	}
}
