package pl.mobiid.shared.datatypes.communication.common;

public class JsonLoginUserRequest extends JsonMessageRequest {

	/* serialVersionUID  */
	private static final long serialVersionUID = -42783695111690906L;
	private String mEmail = "";
	private String mPassword  = "";
	
	public JsonLoginUserRequest() {
		super();
		
	}

	public JsonLoginUserRequest(String mEmail, String mPassword, String applicationVersion) {
		super(applicationVersion);
		this.mEmail = mEmail;
		this.mPassword = mPassword;
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
	 * @param mPassword the mPassword to set
	 */
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonLoginUserRequest [mEmail=" + mEmail + ", mPassword="
				+ mPassword + ", toString()=" + super.toString() + "]";
	}
	
	
}
