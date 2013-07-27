package pl.mobiid.shared.datatypes;

import java.io.Serializable;

public class Condition implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private ConditionType mConditionType;
	
	/**
	 * 
	 */
	private String mExpectedValue;

	
	
	public Condition() {
		super();
	}

	public Condition(ConditionType mConditionType, String mExpectedValue) {
		super();
		this.mConditionType = mConditionType;
		this.mExpectedValue = mExpectedValue;
	}

	/**
	 * @return the mConditionType
	 */
	public ConditionType getmConditionType() {
		return mConditionType;
	}

	/**
	 * @param mConditionType the mConditionType to set
	 */
	public void setmConditionType(ConditionType mConditionType) {
		this.mConditionType = mConditionType;
	}

	/**
	 * @return the mExpectedValue
	 */
	public String getmExpectedValue() {
		return mExpectedValue;
	}

	/**
	 * @param mExpectedValue the mExpectedValue to set
	 */
	public void setmExpectedValue(String mExpectedValue) {
		this.mExpectedValue = mExpectedValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Condition [mConditionType=" + mConditionType
				+ ", mExpectedValue=" + mExpectedValue + "]";
	}

	
	
}
