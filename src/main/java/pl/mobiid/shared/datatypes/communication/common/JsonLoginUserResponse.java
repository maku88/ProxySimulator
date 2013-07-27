package pl.mobiid.shared.datatypes.communication.common;

public class JsonLoginUserResponse extends JsonMessageResponse {

	/* serialVersionUID  */
	private static final long serialVersionUID = 1445985262057097518L;
	private int mRole;

	public JsonLoginUserResponse(ResponseCode mStatusCode, int mRole) {
		super(mStatusCode);
		this.mRole = mRole;
	}

	/**
	 * @return the mRole
	 */
	public int getRole() {
		return mRole;
	}

	/**
	 * @param role the mRole to set
	 */
	public void setRole(int role) {
		this.mRole = role;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonLoginUserResponse [mRole=" + mRole + ", toString()="
				+ super.toString() + "]";
	}
		
}
