package br.com.dsclients.application.mappers;

import br.com.dsclients.application.dtos.StandardErrorDto;

import java.time.Instant;

public class StandardErrorMapper {


    private StandardErrorMapper(){}


    public static StandardErrorDto makeStandardErrorDto(
            Integer httpStatus, String exceptionError,
            String path, String exceptionMessage){
        return StandardErrorDto
                .builder()
                .timestamp(Instant.now())
                .status(httpStatus)
                .error(exceptionError)
                .path(path)
                .message(exceptionMessage)
                .build();
    }

}
