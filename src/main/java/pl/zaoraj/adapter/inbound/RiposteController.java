package pl.zaoraj.adapter.inbound;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiposteController {

	private static final String PROMPT_TEMPLATE = "Mam pewnien przesadzony problem i potrzebuję żeby ktoś mnie doprowadził do " +
			"pionu ciętą ripostą. Najlepiej sarkastycznie i śmiesznie. Możesz skorzystać z najlepszych ripost jakie znasz " +
			"z filmów i historycznych wypowiedzi. Mój problem to: ";
	private final ChatClient chatClient;

	public RiposteController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@PostMapping
	public AnswerDto completion(@RequestBody MessageDto message) {
		return new AnswerDto(chatClient.call(PROMPT_TEMPLATE + message.message()));
	}
}
