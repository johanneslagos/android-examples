package com.fredrikpaasche.example;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	String Tag = "Examples";
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
			if (position == 0) {
				startActivity(new Intent(MainActivity.this, DialogActivity.class));
			}
		}
	}; 
	
	// Initialize with hard coded values
	private void initData() {
		choices.add("Dialogs");
		choices.add("Lorem");
		choices.add("Ipsum");
	}

}