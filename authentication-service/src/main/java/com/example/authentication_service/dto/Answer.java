package com.example.authentication_service.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Answer<T>{
    private String message;
    private T Data;

    public Answer(String message) {
        this.message = message;
    }
}
