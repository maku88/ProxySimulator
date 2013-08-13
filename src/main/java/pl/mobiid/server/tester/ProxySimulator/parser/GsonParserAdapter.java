
package pl.mobiid.server.tester.ProxySimulator.parser;


import java.io.Reader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.apache.http.entity.StringEntity;



import com.google.gson.Gson;

/**
 * @author Sebastian
 *
 */
public class GsonParserAdapter implements IJsonParser, Serializable {


	public static Gson gson = new Gson();
private Logger Log = Logger.getLogger(GsonParserAdapter.class.getName());
	
	
	/* (non-Javadoc)
	 * @see pl.mobiid.android.basicclient.utils.jsonparsers.IJsonParser#parseFromJson(java.lang.String, java.lang.Class)
	 */
	public <T> T parseFromJson(String jsonMessage, Class<T> type) {
//		Log.info("JSON parsing...");
		if(jsonMessage != null) {
//			Log.info("JSON parsing... DONE");
			return gson.fromJson(jsonMessage, type);
		}	
		else {
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see pl.mobiid.android.basicclient.utils.jsonparsers.IJsonParser#parseFromJson(java.lang.String, java.lang.Class)
	 */
	
	public <T> T parseFromJson(Reader jsonReader, Class<T> type) {
//		Log.info("JSON parsing...");
		if(jsonReader != null) {
//			Log.info("JSON parsing... DONE");
			return gson.fromJson(jsonReader, type);
		}	
		else {
			return null;
		}
	}
	
	public <T> StringEntity parseToJsonSE(T object) {
		if(object != null) {
			String json = gson.toJson(object);
			StringEntity stringEntity;
			try {
				stringEntity = new StringEntity(json);
				return stringEntity;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		else 
			return null;
	}
	
	public <T> String parseToJsonS(T object) {
		if(object != null) {
			String json = gson.toJson(object);
			return json;
		}
		else 
			return null;
	}
}