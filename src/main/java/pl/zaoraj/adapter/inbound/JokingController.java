package pl.zaoraj.adapter.inbound;

import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokingController {

	private static final String PROMPT_TEMPLATE = "Mam pewnien problem i potrzebuje żeby ktoś mnie doprowadził do " +
			"pionu jakąś ciętą ripostą. Najlepiej sarkastycznie i śmiesznie ale nie obraźliwie. Mój problem to: ";
	private final ChatClient chatClient;

	@Autowired
	public JokingController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@PostMapping
	public AnswerDto completion(@RequestBody MessageDto message) {
		return new AnswerDto(chatClient.call(PROMPT_TEMPLATE + message.message()));
	}
}