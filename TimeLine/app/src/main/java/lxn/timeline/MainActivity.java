package lxn.timeline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * Created by hkqone on 2016/8/4
 * QQ:1006556626
 * csdn:http://blog.csdn.net/hkq463?viewmode=contents
 */

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(lxn.timeline.R.layout.activity_main);
		
	findViewById(lxn.timeline.R.id.linearlayout_addview).setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, ActivityLinearLayoutDemo.class);
			startActivity(intent);
		}
	});
	
	findViewById(lxn.timeline.R.id.listview).setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, ActivityListViewDemo.class);
			startActivity(intent);
		}
	});
	}
}
