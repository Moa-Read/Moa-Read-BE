package dongduk.cs.moaread.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException{
    ErrorCode errorCode;
    String message;
    HttpStatus httpStatus;

    public BaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }
}