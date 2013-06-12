package com.fredrikpaasche.example;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

// A custom class that handles a single dialog. It also listens for editor actions.
// This class can be used in a dialog or as a component in a view.
public class EditNameDialogFragment extends DialogFragment implements OnEditorActionListener {

	String Tag = "Examples";

	// This is the definition of an interface. Those who display this dialog can
	// implement it to get callbacks.
	public interface EditNameDialogListener {

		void onFinishEditDialog(String inputText);
	}

	// The dialog has an edit field that we save here
	private EditText editText;

	// Empty constructor
	public EditNameDialogFragment() {
	}

	@Override
	// At startup, we display the dialog
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_edit_name, container);

		// Save the edit field for easy access later
		editText = (EditText) view.findViewById(R.id.txt_your_name);

		// Listen for keyboard events
		editText.setOnEditorActionListener(this);

		// Put a greeting in the title
		String title = getResources().getString(R.string.hello_there);
		getDialog().setTitle(title);
		return view;
	}

	@Override
	// Something happened to the edit field
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

		// The DONE button was pressed on the keyboard
		if (EditorInfo.IME_ACTION_DONE == actionId) {

			// getActivity() only works for fragments. We get the activity of whoever has implemented
			// EditNameDialogListener.
			EditNameDialogListener activity = (EditNameDialogListener) getActivity();

			// Now we call a method in whoever has implemented the listener
			activity.onFinishEditDialog(editText.getText().toString());
			this.dismiss();
			return true;
		}
		return false;
	}

}
