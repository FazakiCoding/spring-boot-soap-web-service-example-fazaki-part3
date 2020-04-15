package com.fazaki.springbootsoapwebserviceexamplefazakipart3.endpoint;


import com.fazaki.spring_boot_soap_example_fazaki.GetBookRequest;
import com.fazaki.spring_boot_soap_example_fazaki.GetBookResponse;
import com.fazaki.springbootsoapwebserviceexamplefazakipart3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {
    @Autowired
    private BookService bookService;

    @PayloadRoot(
            namespace="http://fazaki.com/spring-boot-soap-example-fazaki",
            localPart="getBookRequest"
    )
    @ResponsePayload
    public GetBookResponse getBookRequest(@RequestPayload GetBookRequest request){
        GetBookResponse response=new GetBookResponse();
        response.setBook(bookService.getBook(request.getTitle()));
        return response;
    }

}
