package ru.consumer.client;
import com.produce.GetArticleByIdRequest;
import com.produce.GetArticleByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {
    @Autowired
    private Jaxb2Marshaller marshaller;
    private WebServiceTemplate template;

    public GetArticleByIdResponse getArticleById(long articleId) {
        template = new WebServiceTemplate(marshaller);
        GetArticleByIdRequest request = new GetArticleByIdRequest();
        request.setArticleId(articleId);
        GetArticleByIdResponse response = (GetArticleByIdResponse)template.marshalSendAndReceive(
                "http://localhost:8080/soapws/getArticleByIdRequest",
                request
        );
        // GetArticleByIdResponse response = (GetArticleByIdResponse) template.marshalSendAndReceive(
       //         request, new SoapActionCallback("http://localhost:8080/soapws/getArticleByIdRequest"));
        return response;
    }

}
