package com.destination.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse {
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;

    public HttpResponse(int httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }

    public HttpResponse(final int httpStatusCode, HttpStatus httpStatus, String message, Date date) {
        this.httpStatusCode=httpStatusCode;
        this.httpStatus=httpStatus;
        this.message=message;
        this.date=date;
    }
}
