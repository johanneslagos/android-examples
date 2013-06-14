package com.fredrikpaasche.example.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fredrikpaasche.example.R;

public class MainActivity extends Activity {

	static final String Tag = "Examples";
	static final String choiceDialogs = "Dialogs";
	static final String choiceRelativeLayout = "Relative layout";
	static final String choiceActionBar = "Action bar";
	static final String choiceNavigationTabs = "Navigation tabs";
	static final String choiceSwipe = "Swipe navigation";
	static final String choiceTitleStrip = "Title strip";

	ArrayList<String> choices = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		ListView listview = (ListView) findViewById(R.id.listview);

		// Use a built in adapter and built in cell definition
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, choices);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(onClickChoice);
	}

	// Private class to handle clicks in the listview
	private AdapterView.OnItemClickListener onClickChoice = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			final String item = (String) parent.getItemAtPosition(position);
			Log.d(Tag, item);
			if (item.equals(choiceDialogs)) {
				startActivity(new Intent(MainActivity.this, DialogActivity.class));
			}
			else if (item.equals(choiceRelativeLayout)) {
				startActivity(new Intent(MainActivity.this, RelativeLayoutActivity.class));
			}
			else if (item.equals(choiceActionBar)) {
				startActivity(new Intent(MainActivity.this, ActionBarActivity.class));
			}
			else if (item.equals(choiceNavigationTabs)) {
				startActivity(new Intent(MainActivity.this, NavigationTabsActivity.class));
			}
			else if (item.equals(choiceSwipe)) {
				startActivity(new Intent(MainActivity.this, SwipeActivity.class));
			}
			else if (item.equals(choiceTitleStrip)) {
				startActivity(new Intent(MainActivity.this, TitleStripActivity.class));
			}
		}
	};

	// Initialize with hard coded values
	private void initData() {
		choices.add(choiceDialogs);
		choices.add(choiceRelativeLayout);
		choices.add(choiceActionBar);
		choices.add(choiceNavigationTabs);
		choices.add(choiceSwipe);
		choices.add(choiceTitleStrip);
	}
}
