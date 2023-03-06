package com.rja.projects.mygameslib.utility.security;


import org.springframework.http.HttpHeaders;

public class HeadersHandler {

    public static HttpHeaders createAuthHeader(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        return httpHeaders;
    }
}
