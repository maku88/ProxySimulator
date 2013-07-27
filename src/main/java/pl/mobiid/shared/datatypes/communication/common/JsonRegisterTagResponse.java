package pl.mobiid.shared.datatypes.communication.common;

import pl.mobiid.shared.datatypes.communication.common.JsonMessageResponse;
import pl.mobiid.shared.datatypes.communication.common.ResponseCode;

/**
 * Response object used in tag registration process.
 * @author Sebastian
 *
 */

public class JsonRegisterTagResponse extends JsonMessageResponse {

	/* serialVersionUID  */
	private static final long serialVersionUID = -4358605856967566029L;

	public JsonRegisterTagResponse() {
		super();
	}

	public JsonRegisterTagResponse(ResponseCode mStatusCode) {
		super(mStatusCode);
	}

}
