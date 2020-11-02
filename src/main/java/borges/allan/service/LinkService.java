package borges.allan.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class LinkService {

	public Mono<String> shortenLink(String link) {
		return Mono.just(RandomStringUtils.randomAlphabetic(6));
	}
}
