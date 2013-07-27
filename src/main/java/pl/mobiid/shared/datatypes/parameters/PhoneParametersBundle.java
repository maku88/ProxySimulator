package pl.mobiid.shared.datatypes.parameters;

import java.io.Serializable;

/**
 * Obiekt przechowuje informacje o urzadzeniu 
 * TODO Zastanowic sie czy to nie powinno byc typowe Parcel (Bundle) bez deklaracji pol
 * Wada pol: sztywnosc i nierozszerzalnosc
 * Wada typowego bundle: niezbedne jest pobieranie parametrow zgodnie ze scisla kolejnoscia zapisu... 
 * Moze HashMap?
 * 
 * TODO Dodać bluetooth
 * 
 * @author Sebastian
 *
 */
public class PhoneParametersBundle implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mDeviceId = "NaN";
	private String mIMSI = "NaN";
	private String mIP = "NaN";
	private String mDisplayLanguage = "NaN";
	private String mBrand = "NaN";
	private String mManufacturer = "NaN";
	private String mModel = "NaN";
	private String mProduct = "NaN";

	private String mOSVersion = "NaN";
	private int mSDKVersion = 0;
	private String mSimOperator = "NaN";
	private String mNetworkOperator = "NaN";
	//TODO co lepiej, int czy String??
	private String mNetworkType = "NaN";

	private boolean mIsMobileDataTransferOn = false;
	private boolean mIsWifiOn = false; 
	private boolean mIsGpsOn = false;
	private AndroidLocation mLastKnownLocation;



	/**
	 * 
	 */
	public PhoneParametersBundle() {
		super();
	}






	public PhoneParametersBundle(String mDeviceId, String mIMSI, String mIP,
			String mDisplayLanguage, String mBrand, String mManufacturer,
			String mModel, String mProduct, String mOSVersion, int mSDKVersion,
			String mSimOperator, String mNetworkOperator, String mNetworkType,
			boolean mIsMobileDataTransferOn, boolean mIsWifiOn,
			boolean mIsGpsOn, AndroidLocation mLastKnownLocation) {
		super();
		this.mDeviceId = mDeviceId;
		this.mIMSI = mIMSI;
		this.mIP = mIP;
		this.mDisplayLanguage = mDisplayLanguage;
		this.mBrand = mBrand;
		this.mManufacturer = mManufacturer;
		this.mModel = mModel;
		this.mProduct = mProduct;
		this.mOSVersion = mOSVersion;
		this.mSDKVersion = mSDKVersion;
		this.mSimOperator = mSimOperator;
		this.mNetworkOperator = mNetworkOperator;
		this.mNetworkType = mNetworkType;
		this.mIsMobileDataTransferOn = mIsMobileDataTransferOn;
		this.mIsWifiOn = mIsWifiOn;
		this.mIsGpsOn = mIsGpsOn;
		this.mLastKnownLocation = mLastKnownLocation;
	}

	/**
	 * @return the mOSVersion
	 */
	public String getmOSVersion() {
		return mOSVersion;
	}
	/**
	 * @param mOSVersion the mOSVersion to set
	 */
	public void setmOSVersion(String mOSVersion) {
		this.mOSVersion = mOSVersion;
	}
	/**
	 * @return the mSDKVersion
	 */
	public int getmSDKVersion() {
		return mSDKVersion;
	}
	/**
	 * @param mSDKVersion the mSDKVersion to set
	 */
	public void setmSDKVersion(int mSDKVersion) {
		this.mSDKVersion = mSDKVersion;
	}
	/**
	 * @return the mNetworkOperator
	 */
	public String getmNetworkOperator() {
		return mNetworkOperator;
	}
	/**
	 * @param mNetworkOperator the mNetworkOperator to set
	 */
	public void setmNetworkOperator(String mNetworkOperator) {
		this.mNetworkOperator = mNetworkOperator;
	}
	/**
	 * @return the mNetworkType
	 */
	public String getmNetworkType() {
		return mNetworkType;
	}
	/**
	 * @param mNetworkType the mNetworkType to set
	 */
	public void setmNetworkType(String mNetworkType) {
		this.mNetworkType = mNetworkType;
	}

	/**
	 * @return the mIsMobileDataTransferOn
	 */
	public boolean ismIsMobileDataTransferOn() {
		return mIsMobileDataTransferOn;
	}
	/**
	 * @param mIsMobileDataTransferOn the mIsMobileDataTransferOn to set
	 */
	public void setmIsMobileDataTransferOn(boolean mIsMobileDataTransferOn) {
		this.mIsMobileDataTransferOn = mIsMobileDataTransferOn;
	}
	/**
	 * @return the mIsWifiOn
	 */
	public boolean ismIsWifiOn() {
		return mIsWifiOn;
	}
	/**
	 * @param mIsWifiOn the mIsWifiOn to set
	 */
	public void setmIsWifiOn(boolean mIsWifiOn) {
		this.mIsWifiOn = mIsWifiOn;
	}
	/**
	 * @return the mIsGpsOn
	 */
	public boolean ismIsGpsOn() {
		return mIsGpsOn;
	}
	/**
	 * @param mIsGpsOn the mIsGpsOn to set
	 */
	public void setmIsGpsOn(boolean mIsGpsOn) {
		this.mIsGpsOn = mIsGpsOn;
	}
	/**
	 * @return the mLastKnownLocation
	 */
	public AndroidLocation getmLastKnownLocation() {
		return mLastKnownLocation;
	}
	/**
	 * @param mLastKnownLocation the mLastKnownLocation to set
	 */
	public void setmLastKnownLocation(AndroidLocation mLastKnownLocation) {
		this.mLastKnownLocation = mLastKnownLocation;
	}
	/**
	 * @return the mDeviceId
	 */
	public String getmDeviceId() {
		return mDeviceId;
	}
	/**
	 * @param mDeviceId the mDeviceId to set
	 */
	public void setmDeviceId(String mDeviceId) {
		this.mDeviceId = mDeviceId;
	}
	/**
	 * @return the mSubscriberId
	 */
	public String getmSubscriberId() {
		return mIMSI;
	}
	/**
	 * @param mSubscriberId the mSubscriberId to set
	 */
	public void setmSubscriberId(String mSubscriberId) {
		this.mIMSI = mSubscriberId;
	}
	/**
	 * @return the mDisplayLanguage
	 */
	public String getmDisplayLanguage() {
		return mDisplayLanguage;
	}
	/**
	 * @param mDisplayLanguage the mDisplayLanguage to set
	 */
	public void setmDisplayLanguage(String mDisplayLanguage) {
		this.mDisplayLanguage = mDisplayLanguage;
	}
	/**
	 * @return the mBrand
	 */
	public String getmBrand() {
		return mBrand;
	}
	/**
	 * @param mBrand the mBrand to set
	 */
	public void setmBrand(String mBrand) {
		this.mBrand = mBrand;
	}
	/**
	 * @return the mManufacturer
	 */
	public String getmManufacturer() {
		return mManufacturer;
	}
	/**
	 * @param mManufacturer the mManufacturer to set
	 */
	public void setmManufacturer(String mManufacturer) {
		this.mManufacturer = mManufacturer;
	}
	/**
	 * @return the mModel
	 */
	public String getmModel() {
		return mModel;
	}
	/**
	 * @param mModel the mModel to set
	 */
	public void setmModel(String mModel) {
		this.mModel = mModel;
	}
	/**
	 * @return the mProduct
	 */
	public String getmProduct() {
		return mProduct;
	}
	/**
	 * @param mProduct the mProduct to set
	 */
	public void setmProduct(String mProduct) {
		this.mProduct = mProduct;
	}
	/**
	 * @return the mIMSI
	 */
	public String getmIMSI() {
		return mIMSI;
	}
	/**
	 * @param mIMSI the mIMSI to set
	 */
	public void setmIMSI(String mIMSI) {
		this.mIMSI = mIMSI;
	}

	public String getmSimOperator() {
		return mSimOperator;
	}

	public void setmSimOperator(String mSimOperator) {
		this.mSimOperator = mSimOperator;
	}

	/**
	 * @return the mIP
	 */
	public String getmIP() {
		return mIP;
	}

	/**
	 * @param mIP the mIP to set
	 */
	public void setmIP(String mIP) {
		this.mIP = mIP;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhoneParametersBundle [mDeviceId=" + mDeviceId + ", mIMSI="
		+ mIMSI + ", mIP=" + mIP + ", mDisplayLanguage="
		+ mDisplayLanguage + ", mBrand=" + mBrand + ", mManufacturer="
		+ mManufacturer + ", mModel=" + mModel + ", mProduct="
		+ mProduct + ", mOSVersion=" + mOSVersion + ", mSDKVersion="
		+ mSDKVersion + ", mSimOperator=" + mSimOperator
		+ ", mNetworkOperator=" + mNetworkOperator + ", mNetworkType="
		+ mNetworkType + ", mIsMobileDataTransferOn="
		+ mIsMobileDataTransferOn + ", mIsWifiOn=" + mIsWifiOn
		+ ", mIsGpsOn=" + mIsGpsOn + ", mLastKnownLocation="
		+ mLastKnownLocation + "]";
	}



}
