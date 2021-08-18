package com.eseict;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestCoapClient {

    public static void main(String[] args) throws ConnectorException, IOException {

        //        CoapClient client = new CoapClient("coap://californium.eclipse.org:5683/obs");
        CoapClient client = new CoapClient("coap://10.10.0.198:5683/oic/res");
//        client.setTimeout(3L);

//        if(!client.ping()){
//            System.out.println("Server is down. Terminate program.");
//            return;
//        }

//        System.out.println("Request Get mothod of CoAP.");
//        String content1 = client.get().getResponseText();
//        System.out.println("Response : " + content1);
//
//        String content2 = client.get().getResponseText();
//        System.out.println("Response : " + content2);

        CoapResponse response = client.get();

        byte[] data = response.getPayload();
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        /* CBOR decode - use jackson Library */
        CBORFactory cf = new CBORFactory();
        ObjectMapper mapper = new ObjectMapper(cf);
        try {
            /* CBOR 을 JsonNode로 변환 */
            JsonNode jnode = mapper.readValue(bais, JsonNode.class);
            System.out.println("sdf");
//            cms.insertMsd(jnode);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
