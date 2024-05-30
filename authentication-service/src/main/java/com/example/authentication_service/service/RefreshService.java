package com.example.authentication_service.service;

import com.example.authentication_service.Client.TokenClient;
import com.example.authentication_service.dto.RefreshDTO;
import com.example.authentication_service.dto.TokenDTO;
import com.example.authentication_service.dto.TokenResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshService {

        private final TokenClient tokenClient;

        public TokenDTO refresh(RefreshDTO refreshToken) {
            String clientID = "springboot-keycloak-client";
            String grantType = "refresh_token";

            String requestBody = String.format("client_id=%s&refresh_token=%s&grant_type=%s", clientID, refreshToken, grantType);

            ResponseEntity<TokenResponseDTO> responseEntity = tokenClient.sendRequest(requestBody);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                TokenResponseDTO response = responseEntity.getBody();
                return new TokenDTO(response.access_token(), response.refresh_token());
            }

            throw new RuntimeException("Error refreshing token: " + responseEntity.getStatusCode());
        }
}
