/**
 * 
 */
package pl.mobiid.shared.datatypes;

/**
 * @author Sebastian
 *
 */
public enum NetworkType {
	NETWORK_TYPE_UNKNOWN(-1),
	NETWORK_TYPE_WIFI(0),
	NETWORK_TYPE_GPRS(1),
	NETWORK_TYPE_UMTS(2),
	NETWORK_TYPE_LTE(3),
	NETWORK_TYPE_HSDPA(4),
	NETWORK_TYPE_HSUPA(5),
	NETWORK_TYPE_HSPA(6),
	NETWORK_TYPE_EDGE(7),
	NETWORK_TYPE_CDMA(8),
	NETWORK_TYPE_EVDO_0(9),
	NETWORK_TYPE_EVDO_A(10),
	NETWORK_TYPE_EVDO_B(11),
	NETWORK_TYPE_1xRTT(12),
	NETWORK_TYPE_IDEN(13),
	NETWORK_TYPE_EHRPD(14);
	

	private int mCode;
	
	private NetworkType(int code) {
		this.mCode = code;
	}
	
	public int getCode() {
		return mCode;
	}
}
