package net.dipbits.dipbitsRestApi.controller;

import lombok.RequiredArgsConstructor;
import net.dipbits.dipbitsRestApi.dto.auth.JwtAuthenticationResponse;
import net.dipbits.dipbitsRestApi.dto.auth.RegisterRequest;
import net.dipbits.dipbitsRestApi.dto.auth.SignInRequest;
import net.dipbits.dipbitsRestApi.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

@PostMapping("/register")
    public JwtAuthenticationResponse register(@RequestBody RegisterRequest request){
    return authenticationService.register(request);
}

@PostMapping("/signin")
    public  JwtAuthenticationResponse sigin(@RequestBody SignInRequest request){
    return authenticationService.sigin(request);
}

}
