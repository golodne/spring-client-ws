package ru.consumer.controller;

import com.produce.GetArticleByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.consumer.client.SoapClient;

@RestController
public class ClientController {

    @Autowired
    private SoapClient soapClient;

    @RequestMapping(method = RequestMethod.GET, value = "/article/{id}", produces = {MediaType.APPLICATION_JSON_VALUE/*, MediaType.APPLICATION_XML_VALUE*/})
    public GetArticleByIdResponse getArticleByIdResponse(@PathVariable(value = "id") Integer id) {
        return soapClient.getArticleById(id);
    }
}
