package com.android.browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class BrowserActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedState)
	{
		super.onCreate(savedState);
		
		try
		{
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://www.google.com"));
			this.startActivity(Intent.createChooser(intent, "Browser"));
		}
		catch(Exception e){}
		finally
		{
			this.finish();
		}
	}
}
