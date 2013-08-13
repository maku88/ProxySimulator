package pl.mobiid.server.tester.ProxySimulator.threads;

import java.io.*;
import java.util.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;


import org.apache.log4j.Logger;
import pl.mobiid.server.tester.ProxySimulator.config.SysConfig;
import pl.mobiid.server.tester.ProxySimulator.parser.GsonParserAdapter;
import pl.mobiid.server.tester.ProxySimulator.parser.IJsonParser;
import pl.mobiid.server.tester.ProxySimulator.simulation.Simulator;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.SimulationResult;
import pl.mobiid.server.tester.ProxySimulator.simulation.data.Tag;
import pl.mobiid.shared.datatypes.NetworkType;
import pl.mobiid.shared.datatypes.communication.common.JsonActionToHandleResponse;
import pl.mobiid.shared.datatypes.communication.common.JsonHTTPActionToHandleRequest;
import pl.mobiid.shared.datatypes.communication.common.JsonMessageResponse;
import pl.mobiid.shared.datatypes.parameters.AndroidLocation;
import pl.mobiid.shared.datatypes.parameters.PhoneParametersBundle;


public class Connector {

    private static final String UTF_8 = "utf-8";
    private static final String PBE_ALGORITHM = "PBEWithMD5AndDES";
    private static final String CIPHER_ALGORITHM = "PBEWithMD5AndDES";
    private static final int NUM_OF_ITERATIONS = 20;

    private final IJsonParser jsonParser = new GsonParserAdapter();

    private JsonHTTPActionToHandleRequest jsonHTTPActionToHandleRequest;
    private HttpPost httpPost = null;
    private static final String key = "vMjv5xcpL39oQwjwL9IgBnHXh24Ilg";
    private byte[] salt;
    private String threadName = "thread : ";
    private String endpoint = "";
    private List<Tag> tags = new ArrayList<Tag>();
    private Simulator simulator;
    private Logger log = Logger.getLogger(Connector.class);

    public Connector(List<Tag> tags, String label, String endpoint, Simulator simulator) throws UnsupportedEncodingException {

        threadName += label;
        this.tags = tags;
        this.endpoint = endpoint;
        this.simulator = simulator;
    }
    private String encrypt(String value) throws UnsupportedEncodingException {
        salt = ("1A$@*ii$").getBytes(UTF_8);
        String result;
        try {
            final byte[] bytes = value != null ? value.getBytes(UTF_8): new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(PBE_ALGORITHM);
            // generation of secret key
            SecretKey SKey = keyFactory.generateSecret(new PBEKeySpec((key).toCharArray()));
            // creation of DES cipher
            Cipher pbeCipher = Cipher.getInstance(CIPHER_ALGORITHM);

            pbeCipher.init(Cipher.ENCRYPT_MODE, SKey, new PBEParameterSpec(salt,NUM_OF_ITERATIONS));

            Base64 base64 = new Base64();

            result = new String(base64.encode(pbeCipher.doFinal(bytes)), UTF_8);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public JsonActionToHandleResponse sendActionRequest(String tagId, NetworkType networkType,PhoneParametersBundle phoneParametersBundle,String applicationVersion) throws UnsupportedEncodingException {
        String parameters = jsonParser.parseToJsonS(phoneParametersBundle);
        String encryptedParams = encrypt(parameters);

        jsonHTTPActionToHandleRequest = new JsonHTTPActionToHandleRequest(tagId, networkType, encryptedParams, applicationVersion);

        String wsURL = endpoint;

        log.info(tagId + " Connecting to web service: " + wsURL);

        httpPost = new HttpPost(wsURL);
        httpPost.setEntity(jsonParser.parseToJsonSE(jsonHTTPActionToHandleRequest));


        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        try {
            BufferedReader reade = new BufferedReader(new InputStreamReader(httpPost.getEntity().getContent()));
            String s;
//            while ((s = reade.readLine()) != null ){
//                System.out.println(s);
//            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return processHttpPostRequest(httpPost,JsonActionToHandleResponse.class, tagId);

    }

    private <T extends JsonMessageResponse, H extends HttpUriRequest> T processHttpPostRequest(H httpUriRequest, Class<T> type, String tagId) {
        // TimingLoggerFactory.getInstance().addSplit("HTTP Request start");
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
        HttpHost proxy = new HttpHost(SysConfig.proxyHost,SysConfig.proxyPort);
        DefaultHttpClient httpclient = new DefaultHttpClient(httpParams);
        try {


            httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

            HttpResponse response;
            response = httpclient.execute(httpUriRequest);
//            log.info(tagId + " HTTPClientTask: Connected with result code: " + response.getStatusLine().toString());

            if (response != null) {
                T responseObject = jsonParser.parseFromJson(handleResponse(response), type);
                if (responseObject != null) {
                    return responseObject;
                } else {
                    log.error(threadName + " " + tagId + " Response is null!");
                }
            }
        } catch (ClientProtocolException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Reader handleResponse(HttpResponse response)
            throws IllegalStateException, IOException {
        Reader reader;
        final int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode != HttpStatus.SC_OK) {
            StatusLine statusLine = response.getStatusLine();

//			System.out.println(TAG + " Error  " + statusCode);
//
//			System.out.println(TAG + " StatusLine "	+ statusLine.getReasonPhrase());

            return null;
        }

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream instream = entity.getContent();
            reader = new InputStreamReader(instream);
            return reader;
        }

        return null;
    }


    public void doRun() {
        for (Tag  tag : tags) {
            PhoneParametersBundle phoneParametersBundle = new PhoneParametersBundle("testowy", "testowy", "test", "PL_pl", "test", "test", "test", "test", "test", 1, "test", "test", "0", true, true, false, new AndroidLocation("test", 1, 1, 1, 1, true, true));
            String applicationVersion = "ST.1.0.01";
            try {
                long start = new Date().getTime();
                JsonActionToHandleResponse resp = sendActionRequest(tag.getTagId(), NetworkType.NETWORK_TYPE_GPRS, phoneParametersBundle, applicationVersion);
                tag.incrementReadTime();
                long end = new Date().getTime();

                log.info(tag.getTagId() + " Time : " + ( end - start ) + " ms ");

                simulator.addResult(new SimulationResult(threadName,tag,start,end,(end-start),resp.getmScenario() == null ? null : resp.getmScenario().toString()));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }

}
