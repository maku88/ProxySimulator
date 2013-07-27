package pl.mobiid.shared.datatypes.communication.common;

public class JsonRegisterUserRequest extends JsonMessageRequest {

	/* serialVersionUID  */
	private static final long serialVersionUID = -2669650111004214632L;
	private String mEmail = "";
	private String mPassword  = "";
	private long mIMSI = 0l;
	
	public JsonRegisterUserRequest() {
		super();
		
	}

	public JsonRegisterUserRequest(String email, String password, long IMSI, String applicationVersion) {
		super(applicationVersion);
		this.mEmail = email;
		this.mPassword = password;
		this.mIMSI = IMSI;
	}

	/**
	 * @return the mEmail
	 */
	public String getmEmail() {
		return mEmail;
	}
	
	/**
	 * @param email the mEmail to set
	 */
	public void setmEmail(String email) {
		this.mEmail = email;
	}
	
	/**
	 * @return the mPassword
	 */
	public String getmPassword() {
		return mPassword;
	}
	
	/**
	 * @param password the mPassword to set
	 */
	public void setmPassword(String password) {
		this.mPassword = password;
	}
	
	
	public long getmIMSI() {
		return mIMSI;
	}

	public void setmIMSI(long mIMSI) {
		this.mIMSI = mIMSI;
	}

	@Override
	public String toString() {
		return "JsonRegisterUserRequest [mEmail=" + mEmail + ", mPassword="
				+ mPassword + ", mIMSI=" + mIMSI + "]";
	}
	
}
