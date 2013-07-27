/**
 * 
 */
package pl.mobiid.shared.datatypes.communication.kuanza;

import pl.mobiid.shared.datatypes.Action;
import pl.mobiid.shared.datatypes.communication.common.JsonMessageRequest;

/**
 * Request object used in tag registration process.
 * 
 * @author Sebastian
 *
 */
 

public class JsonRegisterTagKuanzaRequest extends JsonMessageRequest {

	/* serialVersionUID  */
	private static final long serialVersionUID = 193324770024575534L;

	/**
	 * Unikatowy identyfikator znacznika NFC
	 */
	private String mTagId;

	private Action mAction;
	
	private long mIMEI;
	
	private long mIMSI;

	public JsonRegisterTagKuanzaRequest() {
		super();
	}

	public JsonRegisterTagKuanzaRequest(String mTagId, Action mAction, String applicationVersion, long IMSI, long IMEI) {
		super(applicationVersion);
		this.mTagId = mTagId;
		this.mAction = mAction;
		this.mIMEI = IMEI;
		this.mIMSI = IMSI;
	}

	/**
	 * @return the mTagId
	 */
	public String getmTagId() {
		return mTagId;
	}

	/**
	 * @param mTagId the mTagId to set
	 */
	public void setmTagId(String mTagId) {
		this.mTagId = mTagId;
	}

	/**
	 * @return the mAction
	 */
	public Action getmAction() {
		return mAction;
	}

	/**
	 * @param mAction the mAction to set
	 */
	public void setmAction(Action mAction) {
		this.mAction = mAction;
	}

	public long getmIMEI() {
		return mIMEI;
	}

	public void setmIMEI(long mIMEI) {
		this.mIMEI = mIMEI;
	}

	public long getmIMSI() {
		return mIMSI;
	}

	public void setmIMSI(long mIMSI) {
		this.mIMSI = mIMSI;
	}

	@Override
	public String toString() {
		return "JsonRegisterTagKuanzaRequest [mTagId=" + mTagId + ", mAction="
				+ mAction + ", mIMEI=" + mIMEI + ", mIMSI=" + mIMSI + "]";
	}
}
