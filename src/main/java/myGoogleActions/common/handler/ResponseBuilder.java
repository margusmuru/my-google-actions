package myGoogleActions.common.handler;

import com.google.api.services.actions_fulfillment.v2.model.RichResponse;
import com.google.api.services.actions_fulfillment.v2.model.RichResponseItem;
import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse;
import com.google.api.services.dialogflow_fulfillment.v2.model.IntentMessage;
import com.google.api.services.dialogflow_fulfillment.v2.model.WebhookResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    public WebhookResponse buildWebHookResponseWithSimpleResponse(String body) {
        WebhookResponse webhookResponse = new WebhookResponse();
        RichResponse richResponse = new RichResponse();
        RichResponseItem richResponseItem = new RichResponseItem();
        richResponseItem.setSimpleResponse(buildSimpleResponse(body));
        richResponse.setItems(Collections.singletonList(richResponseItem));

        webhookResponse.setPayload(buildWebHookPayload(richResponse));
        return webhookResponse;
    }

    private SimpleResponse buildSimpleResponse(String body) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setDisplayText(body);
        simpleResponse.setTextToSpeech(body);
        return simpleResponse;
    }

    private Map<String, Object> buildWebHookPayload(RichResponse richResponse) {
        IntentMessage intentMessage = new IntentMessage();
        Map<String, Object> payloadMap = new HashMap<>();
        Map<String, Object> richResponseMap = new HashMap<>();
        richResponseMap.put("richResponse", richResponse);
        payloadMap.put("google", richResponseMap);
        intentMessage.setPayload(payloadMap);
        return payloadMap;
    }

}
