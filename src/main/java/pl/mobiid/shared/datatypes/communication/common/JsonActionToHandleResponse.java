package pl.mobiid.shared.datatypes.communication.common;



/**
 *
 * JsonActionToHandleResponse is an object used to return scenario of actions attached to selected tag 
 * @author Sebastian
 *
 */

public class JsonActionToHandleResponse extends JsonMessageResponse {
	

	/* serialVersionUID  */
	private static final long serialVersionUID = -7715791843768282561L;

	/**
	 * Skrypt scenariusza akcji zapisany w JSON 
	 */
	private String mScenario;
	
	/**
	 * Rola uzytkownika w systemie, domyslnie 0 - uzytkownik z ulicy
	 */
	private int mUserRole = 0;
	/**
	 * Konstruktor stosowany przy obsludze akcji przez WS2
	 * @param mStatusLine
	 * @param mStatusCode
	 * @param mScenario
	 * @param mActions
	 */
	public JsonActionToHandleResponse(ResponseCode mStatusCode,
			String mScenario) {
		
		super(mStatusCode);
		this.mScenario = mScenario;
		
	}

	
	/**
	 * Konstruktor stosowany przy obsludze akcji przez WS3 (zarejestrowani uzytkownicy)
	 * @param mStatusLine
	 * @param mStatusCode
	 * @param mScenario
	 * @param mActions
	 * @param mUserRole
	 */
	public JsonActionToHandleResponse(ResponseCode mStatusCode,
			String mScenario, int mUserRole) {
		super(mStatusCode);
		this.mScenario = mScenario;
		this.mUserRole = mUserRole;
	}

	

	public JsonActionToHandleResponse() {
		super();
	}


	public String getmActionScenario() {
		return mScenario;
	}

	public void setmScenario(String mScenario) {
		this.mScenario = mScenario;
	}


	/**
	 * @return the mUserRole
	 */
	public int getmUserRole() {
		return mUserRole;
	}


	/**
	 * @param mUserRole the mUserRole to set
	 */
	public void setmUserRole(int mUserRole) {
		this.mUserRole = mUserRole;
	}


	/**
	 * @return the mScenario
	 */
	public String getmScenario() {
		return mScenario;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonActionToHandleResponse ["
				+ (mScenario != null ? "mScenario=" + mScenario + ", " : "")
				+ "mUserRole=" + mUserRole + "]";
	}


	
}
