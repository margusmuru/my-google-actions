package myGoogleActions.tv.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.api.services.dialogflow_fulfillment.v2.model.WebhookResponse;
import myGoogleActions.common.gateway.GatewayApiResponseWrapper;
import myGoogleActions.common.handler.ResponseBuilder;
import myGoogleActions.common.models.ActionRequestImpl;

public class GoogleRequestHandler extends DialogflowApp {


    @ForIntent("InventoryBackpackIntent")
    public GatewayApiResponseWrapper handleRequest(ActionRequestImpl request) throws JsonProcessingException {
        ResponseBuilder responseBuilder = new ResponseBuilder();
        WebhookResponse webhookResponse = responseBuilder.buildWebHookResponseWithSimpleResponse("something");
        String body = new ObjectMapper().writeValueAsString(webhookResponse);
        return new GatewayApiResponseWrapper.Builder()
                .body(body)
                .build();
    }
}
