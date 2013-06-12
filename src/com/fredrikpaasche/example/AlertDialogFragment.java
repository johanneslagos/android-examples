package com.fredrikpaasche.example;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

// A custom class that embeds a simple alert view inside a dialog fragment.
// The reason for doing this is that Android will handle rotation for us.
public class AlertDialogFragment extends DialogFragment {

	private String message;

	// Constructor
	public AlertDialogFragment() {
	}

	@Override
	// At startup, display an alert
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		// Add the text
		message = getArguments().getString("message");
		builder.setMessage(message);
		builder.setPositiveButton(R.string.yes, onClickYes);
		builder.setNegativeButton(R.string.no, onClickNo);
		return builder.create();
	}

	// The YES button was clicked
	DialogInterface.OnClickListener onClickYes = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int id) {
			String message = getResources().getString(R.string.wisely);
			Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
		}
	};

	// The NO button was clicked
	DialogInterface.OnClickListener onClickNo = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int id) {
			String message = getResources().getString(R.string.poorly);
			Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
		}
	};
}
