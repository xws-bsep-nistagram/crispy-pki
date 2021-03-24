package rs.ac.uns.ftn.bsep.pki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class CertificateNotFoundExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = CertificateNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handleIssuerNotFound(CertificateNotFoundException e) {
        return "Such a certificate does not exist.";
    }
}