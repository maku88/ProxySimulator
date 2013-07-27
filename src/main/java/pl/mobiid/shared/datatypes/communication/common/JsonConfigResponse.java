package pl.mobiid.shared.datatypes.communication.common;

import java.util.HashMap;

public class JsonConfigResponse extends JsonMessageResponse {

	/* serialVersionUID  */
	private static final long serialVersionUID = 1350574938155451032L;

	HashMap<String, String> params;

	public JsonConfigResponse() {
		super();
	}

	public JsonConfigResponse(ResponseCode mStatusCode, HashMap<String, String> params) {
		super(mStatusCode);
		this.params = params;
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "JsonConfigResponse [params=" + params + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
