package org.zahran.socialnetwork.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zahran.socialnetwork.config.UserAuthenticationProvider;
import org.zahran.socialnetwork.dto.UserDto;
import org.zahran.socialnetwork.services.UserService;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    public AuthenticationController(UserService userService,
                                    UserAuthenticationProvider userAuthenticationProvider) {
        this.userService = userService;
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@AuthenticationPrincipal UserDto user) {
        user.setToken(userAuthenticationProvider.createToken(user.getLogin()));
        return ResponseEntity.ok(user);
    }

//    @PostMapping("/signUp")
//    public ResponseEntity<UserDto> signUp(@RequestBody @Valid SignUpDto user) {
//        UserDto createdUser = userService.signUp(user);
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getId() + "/profile")).body(createdUser);
//    }

    @PostMapping("/signOut")
    public ResponseEntity<Void> signOut(@AuthenticationPrincipal UserDto user) {
        SecurityContextHolder.clearContext();
        return ResponseEntity.noContent().build();
    }

}
