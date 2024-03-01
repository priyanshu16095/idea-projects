package com.example.roughapipractice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@SuperBuilder
@Data
@JsonInclude(NON_NULL)
public class HttpResponse {
    protected String timestamp;
    protected HttpStatus httpStatus;
    protected int statusCode;
    protected String message;
    protected Boolean enabled;
    protected Map<?,?> data;
}
