package pl.mobiid.shared.datatypes.communication.common;

import java.io.Serializable;

public class JsonMessageResponse implements Serializable {
	/* serialVersionUID  */
	private static final long serialVersionUID = -3996903133052587653L;
	
	/**
	 * Kod statusu odpowiedzi
	 */
	private ResponseCode mStatusCode;
	
	public JsonMessageResponse(ResponseCode mStatusCode) {
		super();
		this.mStatusCode = mStatusCode;
	}

	public JsonMessageResponse() {
		
	}

	public ResponseCode getmStatusCode() {
		return mStatusCode;
	}

	public void setmStatusCode(ResponseCode mStatusCode) {
		this.mStatusCode = mStatusCode;
	}

	@Override
	public String toString() {
		return "JsonMessageResponse ["
				+ "mStatusCode=" + mStatusCode + "]";
	}
	
	
}
