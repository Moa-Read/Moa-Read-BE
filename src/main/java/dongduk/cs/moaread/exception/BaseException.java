package dongduk.cs.moaread.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException{
    ErrorCode errorCode;
    String message;
    HttpStatus httpStatus;

    public BaseException(ErrorCode errorCode, String itemCreationFailed) {
        super();
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    public BaseException(dongduk.cs.moaread.domain.item.ErrorCode errorCode) {
    }
}