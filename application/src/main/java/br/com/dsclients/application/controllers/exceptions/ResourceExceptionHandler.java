package br.com.dsclients.application.controllers.exceptions;


import br.com.dsclients.application.dtos.StandardErrorDto;
import br.com.dsclients.application.mappers.StandardErrorMapper;
import br.com.dsclients.application.services.exceptions.ResourceAlreadyExists;
import br.com.dsclients.application.utils.http.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<StandardErrorDto> entityAlreadyExists(HttpServletRequest request, ResourceAlreadyExists exception){
        Integer badRequest = HttpUtils.makeHttpStatus(HttpStatus.BAD_REQUEST);
        String  path = HttpUtils.getRequestPath(request);
        StandardErrorDto dto = StandardErrorMapper.makeStandardErrorDto(badRequest, "This entity already exists", path, exception.getMessage());
        return ResponseEntity.status(badRequest).body(dto);
    }
}
