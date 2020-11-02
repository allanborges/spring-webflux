package borges.allan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import borges.allan.service.LinkService;
import reactor.core.publisher.Mono;

@RestController
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	@PostMapping("/link")
	public Mono<CreateLinkResponse> create(@RequestBody CreateLinkRequest request) {
		//return Mono.just(new CreateLinkResponse("http://localhost:666"));
		return linkService.shortenLink(request.getLink())
				 .map(CreateLinkResponse::new);		
	}
	
	@GetMapping("/link")
	public Mono<CreateLinkResponse> create() {
		return Mono.just(new CreateLinkResponse("teste"));
		/*return linkService.shortenLink(request.link)
				 .map(CreateLinkResponse::new);		*/
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
	
	static class CreateLinkResponse {
		private String shortenedLink;

		public CreateLinkResponse(String shortenedLink) {			
			this.shortenedLink = shortenedLink;
		}

		public String getShortenedLink() {
			return shortenedLink;
		}

		public void setShortenedLink(String shortenedLink) {
			this.shortenedLink = shortenedLink;
		}
		
	}
	

}
