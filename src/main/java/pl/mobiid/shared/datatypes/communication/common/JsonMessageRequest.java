package pl.mobiid.shared.datatypes.communication.common;

import java.io.Serializable;

public class JsonMessageRequest implements Serializable {

	/* serialVersionUID  */
	private static final long serialVersionUID = -4430578010680228112L;
	private String mApplicationVersion;
	
	public JsonMessageRequest() {
		
	}

	
	public JsonMessageRequest(String mApplicationVersion) {
		super();
		this.mApplicationVersion = mApplicationVersion;
	}


	public String getmApplicationVersion() {
		return mApplicationVersion;
	}


	/**
	 * @param mApplicationVersion the mApplicationVersion to set
	 */
	public void setmApplicationVersion(String mApplicationVersion) {
		this.mApplicationVersion = mApplicationVersion;
	}


	@Override
	public String toString() {
		return "JsonMessageRequest [mApplicationVersion=" + mApplicationVersion
				+ "]";
	}

	
}
