package com.example.authentication_service.Controller;


import com.example.authentication_service.dto.Answer;
import com.example.authentication_service.dto.LoginDTO;
import com.example.authentication_service.dto.TokenDTO;
import com.example.authentication_service.service.LoginService;
import com.example.authentication_service.service.RefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class authenticationController {
    private final LoginService loginService;

    @PostMapping("/refresh")
    public ResponseEntity<Answer<TokenDTO>> refresh(@RequestBody RefreshService token) throws Exception{
       /* return ResponseEntity.status(HttpStatus.OK).body(new Answer<>("", token.refresh(RefreshDTO));*/
        return null;
    }


    @PostMapping("/signin")
    public ResponseEntity<Answer<TokenDTO>> login(@RequestBody LoginDTO loginDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new Answer<>("Login correcto", loginService.login(loginDTO)) );
    }




}
