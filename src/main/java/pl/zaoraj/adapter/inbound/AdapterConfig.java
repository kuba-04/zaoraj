package pl.zaoraj.adapter.inbound;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    @Bean
    public ChatClient chatClient(@Value(value = "${spring.ai.openai.api-key}") String token) {
        return new OpenAiChatClient(new OpenAiApi(token));
    }
}
