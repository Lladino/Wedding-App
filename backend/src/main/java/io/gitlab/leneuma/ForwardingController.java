package io.gitlab.leneuma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ForwardingController {

	// Routen von Vue auf / weiterleiten, sodass ein direkter Aufruf einer Route im Browser möglich ist.
	// Beispiel:
	// Der Aufruf http://localhost:8080/about lädt die index.html und der Pfad /about wird anschließend im Vue-Router behandelt.
	@GetMapping("/{path:^(?!static|api|favicon\\.ico|index\\.html).+}/**")
	public String forward(@PathVariable("path") String path) {
		return "forward:/";
	}

}
