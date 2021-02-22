package com.example.soapdemo.endpoint;

import com.example.soapdemo.service.DateService;
//import localhost.soap.GetCurrentDateRequest;
//import localhost.soap.GetCurrentDateResponse;
import com.test.my_soap_test.GetCurrentDateRequest;
import com.test.my_soap_test.GetCurrentDateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DateEndpoint {
    private final DateService dateService;

    @Autowired
    public DateEndpoint(DateService dateService) {
        this.dateService = dateService;
    }

    @PayloadRoot(namespace = "http://test.com/my-soap-test",
            localPart = "GetCurrentDateRequest")
    @ResponsePayload
    public GetCurrentDateResponse getCurrentDate(@RequestPayload GetCurrentDateRequest request) {
        GetCurrentDateResponse response = new GetCurrentDateResponse();
        response.setDate(dateService.getCurrentDate(request.getFormat()));
        return response;
    }
}
