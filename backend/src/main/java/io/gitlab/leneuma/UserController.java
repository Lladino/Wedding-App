package io.gitlab.leneuma;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class UserController {

    @PostMapping("/user/isLoggedIn")
    public void isLoggedIn() {
        System.out.println("okay");
    }

}
