package borges.allan.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class LinkService {
	
	private final String baseUrl;
	
	public LinkService(@Value("${app.baseUrl}") String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Mono<String> shortenLink(String link) {
		return Mono.just(baseUrl + RandomStringUtils.randomAlphabetic(6));
	}
}
