package de.giuliomvr.log;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final SharedPreferences sp = getSharedPreferences(Hook.SP_NAME, MODE_WORLD_READABLE);
		
		((TextView) findViewById(R.id.pathBox)).setText(sp.getString(Hook.SPKEY_LOGPATH, Environment.getExternalStorageDirectory() + "/"));
		
		((Button) findViewById(R.id.saveButton)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sp.edit().putString(Hook.SPKEY_LOGPATH, ((EditText) findViewById(R.id.pathBox)).getText().toString()).apply();
			}
		});
		
		((CheckBox) findViewById(R.id.onOffBox)).setChecked(sp.getBoolean(Hook.SPKEY_ACTIVE, false));
		
		((CheckBox) findViewById(R.id.onOffBox)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				sp.edit().putBoolean(Hook.SPKEY_ACTIVE, isChecked).apply();
			}
		});
	}
	
}
