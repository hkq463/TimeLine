package lxn.timeline;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import lxn.data.DataEntity;
import lxn.data.DataUtil;

public class ActivityLinearLayoutDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(lxn.timeline.R.layout.activity_activity_linear_layout_demo);
		freshView(DataUtil.getData());
		//freshView(DataUtil.getData());
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if(keyCode == KeyEvent.KEYCODE_BACK)
		{
			finish();
			return false;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	protected void freshView(ArrayList<DataEntity> dataList) {
		
		LinearLayout linearLayout = (LinearLayout)findViewById(lxn.timeline.R.id.linearlayout);
		LayoutInflater inflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (int i = 0; i < dataList.size(); i++) {
			DataEntity dataEntity = dataList.get(i);
			
			View view = inflater.inflate(lxn.timeline.R.layout.listitem_timeline, null);
			
			if(i == 0){
				RelativeLayout layoutDoing = (RelativeLayout)view.findViewById(lxn.timeline.R.id.listitem_doing);
				RelativeLayout layoutDone = (RelativeLayout)view.findViewById(lxn.timeline.R.id.listitem_done);
				layoutDoing.setVisibility(View.VISIBLE);
				layoutDone.setVisibility(View.GONE);
			}
			
			TextView details_text = (TextView)view.findViewById(lxn.timeline.R.id.item_date);
			details_text.setText(dataEntity.getDate());
			if(i == 0){
				details_text.setTextColor(Color.BLUE);
			}
			
			details_text = (TextView)view.findViewById(lxn.timeline.R.id.item_time);
			details_text.setText(dataEntity.getTime());
			if(i == 0){
				details_text.setTextColor(Color.BLUE);
			}
			
			details_text = (TextView)view.findViewById(lxn.timeline.R.id.item_status);
			details_text.setText(dataEntity.status);
			if(i == 0){
				details_text.setTextColor(Color.BLUE);
			}
			
			details_text = (TextView)view.findViewById(lxn.timeline.R.id.item_content);
			details_text.setText(dataEntity.describe);
			if(i == 0){
				details_text.setTextColor(Color.BLUE);
			}
			
			details_text = (TextView)view.findViewById(lxn.timeline.R.id.item_director);
			details_text.setText(dataEntity.getOpername());
			if(i == 0){
				details_text.setTextColor(Color.BLUE);
			}
			
			linearLayout.addView(view);
		}
	}
}
