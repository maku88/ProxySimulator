package pl.mobiid.shared.datatypes.communication.kuanza;

import pl.mobiid.shared.datatypes.communication.common.JsonMessageResponse;
import pl.mobiid.shared.datatypes.communication.common.ResponseCode;

/**
 * Response object used in tag registration process.
 * @author Sebastian
 *
 */

public class JsonRegisterTagKuanzaResponse extends JsonMessageResponse {

	/* serialVersionUID  */
	private static final long serialVersionUID = -4358605856967566029L;

	public JsonRegisterTagKuanzaResponse() {
		super();
	}

	public JsonRegisterTagKuanzaResponse(ResponseCode mStatusCode) {
		super(mStatusCode);
	}

}
