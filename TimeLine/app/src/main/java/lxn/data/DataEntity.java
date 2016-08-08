package lxn.data;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class DataEntity {
	public String status = "";
	public String describe = "";
	public String opername = "";
	public String createdate = "1970-01-01 00:00:00";
	
	public String getOpername(){
		return "负责人：" + opername;
	}
	
	private String[] getSplitDate(){
		String[] date = createdate.split("\\ ");
		return date;
	}
	
	public String getDate(){
		String date = getSplitDate()[0];
		return date;
	}
	
	public String getTime(){
		String time = getSplitDate()[1];
		
		return time.substring(0, 5);
	}
}
