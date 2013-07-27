package pl.mobiid.server.tester.ProxySimulator.parser;

import java.io.Reader;

import org.apache.http.entity.StringEntity;

/**
 * Interface to various JsonParsers. Created in order to test various Json parsers
 * 
 * @author Sebastian
 *
 */
public interface IJsonParser {

	public <T> T parseFromJson(String jsonMessage, Class<T> type);
	
	public <T> T parseFromJson(Reader jsonReader, Class<T> type);
	
	public <T> StringEntity parseToJsonSE(T object);
	
	public <T> String parseToJsonS(T object);
	
}
