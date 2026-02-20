package antoniotodarello.progetto70.NotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
        public class globalExceptionHandler  extends RuntimeException{

            @ExceptionHandler(RuntimeException.class)
            public ResponseEntity<?> handle(RuntimeException ex){
                return ResponseEntity.badRequest().body(ex.getMessage());
            }
        }


