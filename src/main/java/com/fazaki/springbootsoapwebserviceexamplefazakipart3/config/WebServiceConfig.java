package com.fazaki.springbootsoapwebserviceexamplefazakipart3.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet
            (ApplicationContext context)
    {
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet,"/soapWS/*");
    }
    @Bean
    public XsdSchema bookSchema(){
        return new SimpleXsdSchema(new ClassPathResource("books.xsd"));
    }
    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bookSchema){
        DefaultWsdl11Definition definition =new DefaultWsdl11Definition();
        definition.setSchema(bookSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("UserServicePort");
        definition.setTargetNamespace("http://fazaki.com/spring-boot-soap-example-fazaki");
        return definition;
    }
}
