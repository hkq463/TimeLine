package lxn.data;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

	public static ArrayList<DataEntity> getData(){
//		List<DataEntity> dataList = JSON.parseArray(json_string, DataEntity.class);
		ArrayList<DataEntity> dataList = new ArrayList<DataEntity>();
		for (int i = 0; i < 5; i++) {
			DataEntity dataEntity = new DataEntity();
			dataEntity.status = "发货中";
			dataEntity.createdate = "1970-01-01 00:00:00";
			dataEntity.opername = "冰冰";
			dataEntity.describe = "已发货，没有物流信息";
			dataList.add(dataEntity);
		}
		
		return dataList;
	}
}
