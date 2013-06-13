package com.fredrikpaasche.example.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.fredrikpaasche.example.R;

// A custom class that embeds a simple alert view inside a dialog fragment.
// The reason for doing this is that Android will handle rotation for us.
public class AlertDialogFragment extends DialogFragment {

	// We define an interface so that the caller can know what the user chose.
	public interface NoticeDialogListener {

		public void onDialogPositiveClick(DialogFragment dialog);

		public void onDialogNegativeClick(DialogFragment dialog);
	}

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
			NoticeDialogListener listener = (NoticeDialogListener) getActivity();
			listener.onDialogPositiveClick(AlertDialogFragment.this);
		}
	};

	// The NO button was clicked
	DialogInterface.OnClickListener onClickNo = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int id) {
			NoticeDialogListener listener = (NoticeDialogListener) getActivity();
			listener.onDialogNegativeClick(AlertDialogFragment.this);
		}
	};
}
