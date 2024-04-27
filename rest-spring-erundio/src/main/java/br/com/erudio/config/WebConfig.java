package br.com.erudio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //  this method configures how Spring handles content negotiation, specifying whether to use parameter-based negotiation, the parameter name to look for, whether to ignore the Accept header, default content type, and supported media types (e.g., JSON, XML).
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //faz aceitar parametros
        configurer.favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(true).
                //This line configures whether Spring should use only registered file extensions for content negotiation. If set to false, Spring will also consider other methods such as query parameters and the Accept header.
                useRegisteredExtensionsOnly(false).
                // meaning JSON will be the default response format
                defaultContentType(MediaType.APPLICATION_JSON).
                //  "json" can be used as a parameter value in requests to indicate that the client wants JSON responses.
                mediaType("json", MediaType.APPLICATION_JSON).
                // "xml" as a parameter value to indicate that they want XML responses.
                mediaType("xml", MediaType.APPLICATION_XML);
    }

}
