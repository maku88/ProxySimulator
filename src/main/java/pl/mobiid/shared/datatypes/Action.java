package pl.mobiid.shared.datatypes;

import java.io.Serializable;
import java.util.HashMap;

public class Action implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	/**
	 * Typ akcji atomowej ktorej definicja jest ta akcja
	 */
	private ActionType mActionType;
	
	/**
	 * Parametry akcji zdefiniowane przez klienta
	 */
	private HashMap<ParamType, String> mActionParams;

	
	
	public Action() {
		super();
	}

	public Action(ActionType mActionType, HashMap<ParamType, String> mActionParams) {
		super();
		this.mActionType = mActionType;
		this.mActionParams = mActionParams;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the mActionType
	 */
	public ActionType getmActionType() {
		return mActionType;
	}

	/**
	 * @param mActionType the mActionType to set
	 */
	public void setmActionType(ActionType mActionType) {
		this.mActionType = mActionType;
	}

	/**
	 * @return the mActionParams
	 */
	public HashMap<ParamType, String> getmActionParams() {
		return mActionParams;
	}

	/**
	 * @param mActionParams the mActionParams to set
	 */
	public void setmActionParams(HashMap<ParamType, String> mActionParams) {
		this.mActionParams = mActionParams;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Action [mActionType=" + mActionType + ", mActionParams="
				+ mActionParams + "]";
	}

	
	
	
}
