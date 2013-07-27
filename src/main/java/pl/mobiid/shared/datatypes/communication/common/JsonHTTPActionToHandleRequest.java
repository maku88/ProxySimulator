package pl.mobiid.shared.datatypes.communication.common;

import pl.mobiid.shared.datatypes.NetworkType;

/**
 *
 * JsonActionToHandleRequest object used to request for actions attached to selected tag
 * @author Sebastian
 *
 */

public class JsonHTTPActionToHandleRequest extends JsonMessageRequest {

	/* serialVersionUID  */
	private static final long serialVersionUID = -5150625535601814875L;

	/**
	 * Unikatowy identyfikator znacznika NFC
	 */
	private String mTagId;
	
	/**
	 * Typ wykorzystywanej sieci pakietowej, niezbędny przy doborze scenariusza
	 */
	private NetworkType mNetworkType;
	
	/**
	 * Dane określające parametry urządzenia, używane w statystykach itp.
	 */
	private String mPhoneParametersBundle;
	/**
	 * Dane określające lokalizację urządzenia, niezbędne dla statystyk lokalizacji
	 */
	//@SerializedName("deviceLocation")
	//private Object mDeviceLocation; 

	public JsonHTTPActionToHandleRequest() {
		super();
	}

	public JsonHTTPActionToHandleRequest(String mTagId, NetworkType mNetworkType,
                                         String mPhoneParametersBundle, String applicationVersion) {
		super(applicationVersion);
		this.mTagId = mTagId;
		this.mNetworkType = mNetworkType;
		this.mPhoneParametersBundle = mPhoneParametersBundle ;
	}
	
	public String getmTagId() {
		return mTagId;
	}
	
	public void setmTagId(String mTagId) {
		this.mTagId = mTagId;
	}

	public NetworkType getmNetworkType() {
		return mNetworkType;
	}

	public void setmNetworkType(NetworkType mNetworkType) {
		this.mNetworkType = mNetworkType;
	}

	public String getmPhoneParametersBundle() {
		return mPhoneParametersBundle;
	}

	public void setmPhoneParametersBundle(
			String mPhoneParametersBundle) {
		this.mPhoneParametersBundle = mPhoneParametersBundle;
	}

	@Override
	public String toString() {
		return "JsonActionToHandleRequest [mTagId=" + mTagId
				+ ", mNetworkType=" + mNetworkType
				+ ", mPhoneParametersBundle=" + mPhoneParametersBundle + "]";
	}

	
}
