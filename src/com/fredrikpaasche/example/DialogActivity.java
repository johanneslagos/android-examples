package com.fredrikpaasche.example;

import java.util.Locale;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

import com.fredrikpaasche.example.AlertDialogFragment.NoticeDialogListener;
import com.fredrikpaasche.example.EditNameDialogFragment.EditNameDialogListener;

// A custom class that can display a single dialog. It also listens for callbacks from the dialog.
public class DialogActivity extends FragmentActivity implements EditNameDialogListener, NoticeDialogListener {

	private String[] colors = { "Red", "Green", "Blue", "Pink" };
	private int selectedColorIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}

	// The Toast button was clicked
	public void onClickDisplayToast(View v) {
		Toast.makeText(this, "This is a short toast", Toast.LENGTH_SHORT).show();
	}

	// The Text alert button was clicked
	public void onClickDisplayTextAlert(View v) {
		showTextAlert();
	}

	// The List alert button was clicked
	public void onClickDisplayListAlert(View v) {
		showListAlert();
	}

	// The Radio button List alert button was clicked
	public void onClickDisplayRadioListAlert(View v) {
		showRadioListAlert();
	}

	// The Alert inside dialog button was clicked
	public void onClickDisplayAlertDialog(View v) {
		showAlertDialog();
	}

	// The Dialog button was clicked
	public void onClickDisplayDialog(View v) {
		showEditDialog();
	}

	// ------------------------------------------------------------------
	// Display a text alert
	// ------------------------------------------------------------------
	private void showTextAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		// Add the text
		builder.setTitle(R.string.hello_there);
		builder.setMessage(R.string.are_you_ok);

		// Add the YES and NO buttons
		builder.setPositiveButton(R.string.yes, onClickYes);
		builder.setNegativeButton(R.string.no, onClickNo);

		// Show the dialog
		builder.show();
	}

	// The YES button was clicked
	DialogInterface.OnClickListener onClickYes = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int id) {
			String message = getResources().getString(R.string.thats_great);
			Toast.makeText(DialogActivity.this, message, Toast.LENGTH_SHORT).show();
		}
	};

	// The NO button was clicked
	DialogInterface.OnClickListener onClickNo = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int id) {
			String message = getResources().getString(R.string.too_bad);
			Toast.makeText(DialogActivity.this, message, Toast.LENGTH_SHORT).show();
		}
	};

	// ------------------------------------------------------------------
	// Display a list alert
	// ------------------------------------------------------------------
	private void showListAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		// Add the title. No room for text when displaying lists.
		builder.setTitle(R.string.favourite_color);

		// Add the list items. The colors are a class variable so the listener can access it too.
		builder.setItems(colors, onClickList);

		// Show the dialog
		builder.show();
	}

	// A list item was clicked
	DialogInterface.OnClickListener onClickList = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int index) {
			String favouriteColor = colors[index].toLowerCase(Locale.getDefault());

			// Insert the favourite color into a template
			String template = getResources().getString(R.string.me_too);
			String message = String.format(template, favouriteColor);
			Toast.makeText(DialogActivity.this, message, Toast.LENGTH_SHORT).show();
		}
	};

	// ------------------------------------------------------------------
	// Display a radio button list alert
	// ------------------------------------------------------------------
	private void showRadioListAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		// Add the title. No room for text when displaying lists.
		builder.setTitle(R.string.favourite_color);

		// Add the list items. These are class variables so the listener can access it too.
		builder.setSingleChoiceItems(colors, selectedColorIndex, onClickRadioList);

		// Add the YES and NO buttons
		builder.setPositiveButton(R.string.ok, onClickOk);
		builder.setNegativeButton(R.string.cancel, onClickCancel);

		// Show the dialog
		builder.show();
	}

	// A radio button item was clicked
	DialogInterface.OnClickListener onClickRadioList = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int index) {
			selectedColorIndex = index;
		}
	};

	// The OK button was clicked
	DialogInterface.OnClickListener onClickOk = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int index) {
			String favouriteColor = colors[selectedColorIndex].toLowerCase(Locale.getDefault());

			// Insert the favourite color into a template
			String template = getResources().getString(R.string.thank_you);
			String message = String.format(template, favouriteColor);
			Toast.makeText(DialogActivity.this, message, Toast.LENGTH_SHORT).show();
		}
	};

	// The Cancel button was clicked
	DialogInterface.OnClickListener onClickCancel = new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog, int index) {
			String message = getResources().getString(R.string.try_again);
			Toast.makeText(DialogActivity.this, message, Toast.LENGTH_SHORT).show();
		}
	};

	// ------------------------------------------------------------------
	// Display an alert inside a dialog fragment. This is the safest way,
	// since rotation will be handled automatically.
	// ------------------------------------------------------------------
	private void showAlertDialog() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		AlertDialogFragment alertDialogFragment = new AlertDialogFragment();

		// Pass parameters to the fragment. This way, we can use the fragment other places.
		Bundle args = new Bundle();
		String message = getResources().getString(R.string.make_a_choice);
		args.putString("message", message);
		alertDialogFragment.setArguments(args);
		alertDialogFragment.show(fragmentManager, "fragment_edit_name");
	}

	// The YES button was clicked
	public void onDialogPositiveClick(DialogFragment dialog) {
		String message = getResources().getString(R.string.wisely);
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	// The NO button was clicked
	public void onDialogNegativeClick(DialogFragment dialog) {
		String message = getResources().getString(R.string.poorly);
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	// ------------------------------------------------------------------
	// Display a dialog using a dialog fragment. This is the safest way,
	// since rotation will be handled automatically.
	// ------------------------------------------------------------------
	private void showEditDialog() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
		editNameDialog.show(fragmentManager, "alert_dialog");
	}

	@Override
	// The dialog has finished and returns some text
	public void onFinishEditDialog(String inputText) {
		Toast.makeText(this, "Hello, " + inputText, Toast.LENGTH_LONG).show();
	}

}
