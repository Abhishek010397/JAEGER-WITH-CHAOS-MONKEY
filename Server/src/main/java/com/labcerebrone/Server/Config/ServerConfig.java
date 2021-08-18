package com.labcerebrone.Server.Config;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Configuration
public class ServerConfig {
    //    Inject two Beans Here
    @Bean
    public WebClient webclient(){
//        Use the same Webclient when using Jaeger
        return WebClient.create();
    }

    //    Jaeger Tracer Bean Here
    @Bean
    public JaegerTracer jaegerTracer(){
//        Use the configuration class provided by Jaeger
        try {
            JaegerTracer jaegerTracer = new io.jaegertracing.Configuration("jaeger-server")
                    .withSampler(new io.jaegertracing.Configuration.SamplerConfiguration().withType(ConstSampler.TYPE)
                            .withParam(1))
                    .withReporter(new io.jaegertracing.Configuration.ReporterConfiguration().withLogSpans(true))
                    .getTracer();
            return jaegerTracer;
        }
        catch (Exception e){
            System.out.println("STackTrace: " + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}
