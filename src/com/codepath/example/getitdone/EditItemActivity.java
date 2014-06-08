package com.codepath.example.getitdone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		String taskText = getIntent().getStringExtra("taskText");
		EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
		etEditItem.setText(taskText);
		etEditItem.setSelection(etEditItem.length());
		etEditItem.requestFocus();
	}
	
	public void saveItem(View v) {
		EditText editedItem = (EditText) findViewById(R.id.etEditItem);
		Intent data = new Intent();
		data.putExtra("editedText", editedItem.getText().toString());
		data.putExtra("itemNum", getIntent().getIntExtra("taskNum", 0));
		setResult(RESULT_OK, data);
		finish();
	}
}
