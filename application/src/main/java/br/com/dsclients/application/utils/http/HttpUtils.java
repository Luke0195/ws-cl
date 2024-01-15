package br.com.dsclients.application.utils.http;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public class HttpUtils {

    private HttpUtils(){}


    public static Integer makeHttpStatus(HttpStatus status){
        return status.value();
    }


    public static String getRequestPath(HttpServletRequest request){
        return request.getRequestURI();
    }

}
