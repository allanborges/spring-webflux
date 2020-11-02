package borges.allan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import borges.allan.service.LinkService;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = LinkController.class)
public class LinkControllerTest {

	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private LinkService linkService;
	
	@Test
	public void shortensLinks() {
		//mockando o retorno
		when(linkService.shortenLink("http://www.allanborges.com")).thenReturn(Mono.just("http://localhost:666"));
		webTestClient.post()
					 .uri("/link")
					 .contentType(MediaType.APPLICATION_JSON)			 
					 .body(Mono.just(new CreateLinkRequest("http://www.allanborges.com")), CreateLinkRequest.class)
					 .exchange()
					 .expectStatus()
					 .is2xxSuccessful()
					 .expectBody()
					 .jsonPath("$.shortenedLink")
					 .value(val -> assertThat(val).isEqualTo("http://localhost:666"));
	}
	
	static class CreateLinkRequest {
		
		public CreateLinkRequest(String link) {
			this.link = link;
		}
		
		public CreateLinkRequest() {
			
		}

		private String link;

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}
	}
}
