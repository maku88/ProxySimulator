package pl.mobiid.shared.datatypes.communication.authenticated;

import pl.mobiid.shared.datatypes.NetworkType;
import pl.mobiid.shared.datatypes.communication.common.JsonActionToHandleRequest;
import pl.mobiid.shared.datatypes.parameters.PhoneParametersBundle;

public class JsonLoginActionToHandleRequest extends JsonActionToHandleRequest {

	/**
	 * login i hasło użytkownika w systemie mobi-id
	 * TODO Przeczytać w Android Security na temat posługiwania się tokenami do logowania
	 */
	private String mLoginData;
	
	public JsonLoginActionToHandleRequest(String mloginData, String mTagId, NetworkType mNetworkType,
			PhoneParametersBundle mDeviceParametersMap, String version) {
		
		super(mTagId, mNetworkType, mDeviceParametersMap, version);
		this.mLoginData = mloginData; 

	}
	
	
	
	/**
	 * 
	 */
	public JsonLoginActionToHandleRequest() {
		super();
	}



	@Override
	public String toString() {
		
		return super.toString() + ", mLoginData: " + mLoginData; 
				
	}

}
