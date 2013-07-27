/**
 * 
 */
package pl.mobiid.shared.datatypes.communication.common;

import pl.mobiid.shared.datatypes.Action;
import pl.mobiid.shared.datatypes.communication.common.JsonMessageRequest;

/**
 * Request object used in tag registration process.
 * 
 * @author Sebastian
 *
 */
 

public class JsonRegisterTagRequest extends JsonMessageRequest {

	/* serialVersionUID  */
	private static final long serialVersionUID = 193324770024575534L;

	/**
	 * Unikatowy identyfikator znacznika NFC
	 */
	private String mTagId;

	private Action mAction;
	
	private long mIMEI;
	
	private long mIMSI;

	private String mEmail = "";
	private String mPassword  = "";
	private String mActionDescription = "";
	
	public JsonRegisterTagRequest() {
		super();
	}

	public JsonRegisterTagRequest(String mTagId, String email, String password, String actionDescription, Action mAction, String applicationVersion, long IMSI, long IMEI) {
		super(applicationVersion);
		this.mTagId = mTagId;
		this.mAction = mAction;
		this.mEmail = email;
		this.mPassword = password;
		this.mActionDescription = actionDescription;
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
	

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	
	
	public String getmActionDescription() {
		return mActionDescription;
	}

	public void setmActionDescription(String mActionDescription) {
		this.mActionDescription = mActionDescription;
	}

	@Override
	public String toString() {
		return "JsonRegisterTagRequest [mTagId=" + mTagId + ", mAction="
				+ mAction + ", mIMEI=" + mIMEI + ", mIMSI=" + mIMSI
				+ ", mEmail=" + mEmail + ", mPassword=" + mPassword
				+ ", actionDescription=" + mActionDescription + "]";
	}

	


}
