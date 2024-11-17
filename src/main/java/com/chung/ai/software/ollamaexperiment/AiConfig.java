package com.chung.ai.software.ollamaexperiment;


import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AiConfig {

    @Value("${spring.ai.ollama.chat.options.model}")
    private String model;

    @Bean
    public OllamaChatModel chatModel() {

        var ollamaApi = new OllamaApi();

        return new OllamaChatModel(ollamaApi,
                OllamaOptions.create()
                        .withModel(model)
                        .withTemperature(0.9));
    }
}
