package pl.mobiid.shared.datatypes.parameters;

import java.io.Serializable;

/**
 * Class represents android device location
 * @author Sebastian
 *
 */
public class AndroidLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mProvider="";
	private double mLatitude=0;
	private double mLongitude=0;

	private double mAltitude=-90000;
	private double mAccuracy=-90000;
	//mHasAltitude;
	//mHasAccuracy=true,

	/**
	 * @param mProvider
	 * @param mLatitude
	 * @param mLongitude
	 * @param mAltitude
	 * @param mAccuracy
	 */
	public AndroidLocation(String mProvider, double mLatitude,
			double mLongitude, double mAltitude, double mAccuracy, boolean mHasAltitude, boolean mHasAccuracy) {
		super();
		this.mProvider = mProvider;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		if(mHasAltitude)
			this.mAltitude = mAltitude;
		if(mHasAccuracy)
			this.mAccuracy = mAccuracy;
	}
	
	/**
	 * 
	 */
	public AndroidLocation() {
		super();
	}

	/**
	 * @return the mProvider
	 */
	public String getmProvider() {
		return mProvider;
	}

	/**
	 * @param mProvider the mProvider to set
	 */
	public void setmProvider(String mProvider) {
		this.mProvider = mProvider;
	}
	/**
	 * @return the mLatitude
	 */
	public double getmLatitude() {
		return mLatitude;
	}
	/**
	 * @param mLatitude the mLatitude to set
	 */
	public void setmLatitude(double mLatitude) {
		this.mLatitude = mLatitude;
	}
	/**
	 * @return the mLongitude
	 */
	public double getmLongitude() {
		return mLongitude;
	}
	/**
	 * @param mLongitude the mLongitude to set
	 */
	public void setmLongitude(double mLongitude) {
		this.mLongitude = mLongitude;
	}
	/**
	 * @return the mAltitude
	 */
	public double getmAltitude() {
		return mAltitude;
	}
	/**
	 * @param mAltitude the mAltitude to set
	 */
	public void setmAltitude(double mAltitude) {
		this.mAltitude = mAltitude;
	}
	/**
	 * @return the mAccuracy
	 */
	public double getmAccuracy() {
		return mAccuracy;
	}
	/**
	 * @param mAccuracy the mAccuracy to set
	 */
	public void setmAccuracy(double mAccuracy) {
		this.mAccuracy = mAccuracy;
	}
	

}
