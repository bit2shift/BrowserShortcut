package com.android.browser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

public class BrowserActivity extends Activity
{
	private static final String TITLE = "Browser Shortcut";
	private static final Object TAG = new Object();

	private class ClickListener implements DialogInterface.OnClickListener
	{
		public void onClick(DialogInterface dialog, int which)
		{
			//get textbox from dialog
			EditText box = (EditText)((AlertDialog)dialog).getWindow().getDecorView().findViewWithTag(TAG);

			//issue intent
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(box.getEditableText().toString()));
			BrowserActivity.this.startActivity(Intent.createChooser(intent, TITLE));
			BrowserActivity.this.finish();
		}
	}

	private class CancelListener implements DialogInterface.OnCancelListener
	{
		public void onCancel(DialogInterface dialog)
		{
			BrowserActivity.this.finish();
		}
	}

	@Override
	public void onCreate(Bundle savedState)
	{
		super.onCreate(savedState);
		EditText textbox = new EditText(this);
		textbox.setTag(TAG);

		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle(TITLE);
		alert.setMessage("Enter URL");
		alert.setView(textbox);
		alert.setPositiveButton("Go", new ClickListener());
		alert.setOnCancelListener(new CancelListener());
		alert.show();
	}
}
