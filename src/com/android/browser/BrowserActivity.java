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
	private EditText text = null;

	private class ClickListener implements DialogInterface.OnClickListener
	{
		public void onClick(DialogInterface dialog, int which)
		{
			CharSequence url = BrowserActivity.this.text.getEditableText();
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url.toString()));
			BrowserActivity.this.startActivity(Intent.createChooser(intent, "Choose browser"));
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
	public void onCreate(Bundle ignored)
	{
		super.onCreate(ignored);
		AlertDialog.Builder alert = new AlertDialog.Builder(this, 3);
		alert.setMessage("Enter URL");
		alert.setView(this.text = new EditText(this));
		alert.setPositiveButton("Go", new ClickListener());
		alert.setOnCancelListener(new CancelListener());
		alert.show();
	}
}
