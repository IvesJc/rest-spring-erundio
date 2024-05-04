package br.com.erudio.config;

import br.com.erudio.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_APPLICATION_YAML = MediaType.valueOf("application/x-yaml");

    @Value("${cors.originPatterns:default}")
    private String corsOriginPatterns = "";

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] allowedOrigins = corsOriginPatterns.split(",");
        registry.
                addMapping("/**").
//                allowedMethods("GET", "POST", "PUT").
                allowedMethods("*").
                allowedOrigins(allowedOrigins).
                allowCredentials(true);
    }

    //  this method configures how Spring handles content negotiation, specifying whether to use parameter-based negotiation, the parameter name to look for, whether to ignore the Accept header, default content type, and supported media types (e.g., JSON, XML).
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //faz aceitar parametros
        configurer.favorParameter(false).
                ignoreAcceptHeader(false).
                //This line configures whether Spring should use only registered file extensions for content negotiation. If set to false, Spring will also consider other methods such as query parameters and the Accept header.
                useRegisteredExtensionsOnly(false).
                // meaning JSON will be the default response format
                defaultContentType(MediaType.APPLICATION_JSON).
                //  "json" can be used as a parameter value in requests to indicate that the client wants JSON responses.
                mediaType("json", MediaType.APPLICATION_JSON).
                // "xml" as a parameter value to indicate that they want XML responses.
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YAML);


        // Media Type via QUERY PARAM
        // http://localhost:8080/api/person/v1/1?mediaType=xml
        /*configurer.favorParameter(true).
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
         */
    }

}
