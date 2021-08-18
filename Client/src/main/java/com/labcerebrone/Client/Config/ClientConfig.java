package com.labcerebrone.Client.Config;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;


@Configuration
public class ClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

    @Bean
    public JaegerTracer jaegerTracer() {
        try {
            JaegerTracer jaegerTracer = new io.jaegertracing.Configuration("jaeger-client")
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
