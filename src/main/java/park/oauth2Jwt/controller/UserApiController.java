package park.oauth2Jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import park.oauth2Jwt.domain.User;
import park.oauth2Jwt.dto.AddUserRequest;
import park.oauth2Jwt.dto.AddUserResponse;
import park.oauth2Jwt.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserApiController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(AddUserRequest request) {
        User newUser = userService.save(request);
        return ResponseEntity.ok()
                .body(newUser);
    }
}
