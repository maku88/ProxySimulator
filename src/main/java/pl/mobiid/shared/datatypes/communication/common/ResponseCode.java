/**
 * 
 */
package pl.mobiid.shared.datatypes.communication.common;

/**
 *
 * ResponseCode 
 * @author Sebastian
 *
 */
public enum ResponseCode {
	OK(200),
	OK_UPDATED(201),
	OK_UPDATED_MOBI_ID(202),
	OK_SAVED_NEW_SCENARIO(203),
	OK_DEF_SYSTEM_SCENARIO_RETURNED(204),
	OK_ACCESS_GRANTED(205),	
	OK_USER_CREATED(206),
	
	ERROR_CLIENT_BAD_DATA(400),
	ERROR_CLIENT_NULL_ACTION(401),
	ERROR_CLIENT_DEPRECTIATED(402),
	
	ERROR_SERVER(500), // błąd na serwerze
	ERROR_SERVER_NO_TAG(501), // nie ma takiego znacznika w bazie
	ERROR_SERVER_DIFFERENT_IMSI(502), // zapisany innym IMEI
	ERROR_SERVER_SERVER_SAVE(503), // błąd zapisu po stronie serwera
	//SAVE_ERROR(504), // nie udało się zapisać
	ERROR_SERVER_UPDATE(504), // nie udało się zaktualizować
	ERROR_SERVER_CONTRACT_OUT_OF_DATE(505), // kontrakt wygasł
	ERROR_SERVER_TAG_LIMIT(506), // osiągnięto limit znaczników
	ERROR_SERVER_NO_CONFIG_FOUND(507), // brak konfiguracji dla danej wersji aplikacji (update)
	ERROR_SERVER_ACCESS_DENIED(508),
	ERROR_SERVER_USER_NOT_CREATED(509),
	ERROR_SERVER_CONTRACT_NOT_ACTIVE(510),
	ERROR_SERVER_NO_ORDER_FOUND(511),
	ERROR_SERVER_CAN_NOT_ADD_ORDER(512),
	ERROR_SERVER_CAN_NOT_CREATE_INVOICE(513),
	ERROR_SERVER_CAN_NOT_COMPLETE_ORDER(514),
	ERROR_SERVER_UNREGISTER_TAG(515),
	CRITICAL_ERROR(600);  // błąd krytyczny

	
	private int status;
		
	private ResponseCode(int status)  {
		this.status = status;
	}
	
	public int getCode() {
		return this.status;
	}
	
	
}
