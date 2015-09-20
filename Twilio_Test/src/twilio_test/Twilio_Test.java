/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twilio_test;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Max
 */
public class Twilio_Test {

    /**
     * @param args the command line arguments
     */
    public static final String ACCOUNT_SID = "AC7eba03c0af2a413d9a3b09e4e5af67b3";
    public static final String AUTH_TOKEN = "979c768159497e25ac5ca5e369335b87";

    public static void main(String[] args) {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        Account account = client.getAccount();

        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+16476079886")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("From", "+16474964356")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("Body", "SPUNK5TORT"));
        try {
            Message sms = messageFactory.create(params);
        } catch (TwilioRestException e) {
            System.out.println("I throw error");
        }
    }
}
