package borges.allan;

import org.junit.Test;

import borges.allan.service.LinkService;
import reactor.test.StepVerifier;


public class LinkServiceTest {
	
	private LinkService linkService = new LinkService("http://www.allanborges.com.br");

	@Test
	public void shortensLink() {
		StepVerifier.create(linkService.shortenLink("http://www.allanborges.com.br"))
		.expectNextMatches(result -> {
			System.out.println(result);
			return result != null && result.length() > 0 &&
				 result.startsWith("http://www.allanborges.com.br");
		})
		.expectComplete()
		.verify();
	}
}
