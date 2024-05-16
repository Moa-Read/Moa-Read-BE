package dongduk.cs.moaread.exception;

import dongduk.cs.moaread.exception.status.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    ErrorCode errorCode;
    String message;
    HttpStatus httpStatus;

    public BaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    public BaseException(ErrorCode errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = errorCode.getHttpStatus();
    }
}