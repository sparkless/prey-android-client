package com.prey.sms;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class SMSParser {

	public static List<JSONObject> getJSONListFromText(String command) {
		List<JSONObject> jsonObjectList =null;
		List<String> listCommand = SMSUtil.getListCommand(command);
		try {
			if (listCommand != null) {
				JSONObject json = new JSONObject();

				json.put("command", "sms");

				json.put("target", listCommand.get(2));
				if (listCommand.size() == 3) {
					json.put("options", null);
				} else {
					json.put("options", listCommand.get(3));
				}
				jsonObjectList = new ArrayList<JSONObject>();
				jsonObjectList.add(json);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObjectList;
	}

}
