package lxn.timeline;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import lxn.data.DataEntity;
import lxn.data.DataUtil;

public class ActivityListViewDemo extends Activity {
	
	ListView listview;
	MyListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(lxn.timeline.R.layout.activity_activity_list_view_demo);
		
		listview = (ListView)findViewById(lxn.timeline.R.id.listview);
		adapter = new MyListAdapter(this);
		listview.setAdapter(adapter);
		initListView(DataUtil.getData());
	}
	
	public void initListView(ArrayList<DataEntity> paramArrayList)
	{			
		if (paramArrayList == null) return;
		
		if (this.adapter == null) return;
		
		this.adapter.removeAll();
		for (int i = 0; i < paramArrayList.size(); i++)
			this.adapter.addObject(paramArrayList.get(i));
			 
		this.adapter.notifyDataSetChanged();
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
	
	public class MyListAdapter extends LinkedListAdapter
	{
		@SuppressWarnings("unused")
		private Context context;
		private LayoutInflater layoutInflater;
		
		public MyListAdapter(Context context)
		{
			this.context = context;
			this.layoutInflater = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
		}

		public int getViewTypeCount() {
			return 1;
		}
		
		class ViewHold {
	        public RelativeLayout 	doing;
	        public RelativeLayout 	done;
	        public TextView 	date;
	        public TextView 	time;
	        public TextView 	status;
	        public TextView 	content;
	        public TextView 	director;
	    }
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			DataEntity	localData = (DataEntity)getItem(position);
			
			ViewHold hold = null;
			
			if (convertView == null){
				
				hold = new ViewHold();
				
				convertView = this.layoutInflater.inflate(lxn.timeline.R.layout.listitem_timeline, null);
				
				hold.doing	= (RelativeLayout)convertView.findViewById(lxn.timeline.R.id.listitem_doing);
				hold.done	= (RelativeLayout)convertView.findViewById(lxn.timeline.R.id.listitem_done);
				hold.date	= (TextView)convertView.findViewById(lxn.timeline.R.id.item_date);
				hold.time	= (TextView)convertView.findViewById(lxn.timeline.R.id.item_time);
				hold.status	= (TextView)convertView.findViewById(lxn.timeline.R.id.item_status);
				hold.content	= (TextView)convertView.findViewById(lxn.timeline.R.id.item_content);
				hold.director	= (TextView)convertView.findViewById(lxn.timeline.R.id.item_director);
				
				convertView.setTag(hold);
			}
			else 
			{
				hold = (ViewHold) convertView.getTag();
			}
			
			if(position == 0){
				hold.doing.setVisibility(View.VISIBLE);
				hold.done.setVisibility(View.GONE);
				hold.date.setTextColor(Color.BLUE);
				hold.time.setTextColor(Color.BLUE);
				hold.status.setTextColor(Color.BLUE);
				hold.content.setTextColor(Color.BLUE);
				hold.director.setTextColor(Color.BLUE);
				
			}else {
				hold.doing.setVisibility(View.GONE);
				hold.done.setVisibility(View.VISIBLE);
				hold.date.setTextColor(Color.BLACK);
				hold.time.setTextColor(Color.BLACK);
				hold.status.setTextColor(Color.BLACK);
				hold.content.setTextColor(Color.BLACK);
				hold.director.setTextColor(Color.BLACK);
			}
			
			hold.date.setText(localData.getDate());
			hold.time.setText(localData.getTime());
			hold.status.setText(localData.status);
			hold.content.setText(localData.describe);
			hold.director.setText(localData.opername);
			
			return convertView;
		}
	}
}