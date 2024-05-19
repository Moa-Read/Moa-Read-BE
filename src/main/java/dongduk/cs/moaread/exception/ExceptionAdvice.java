package dongduk.cs.moaread.exception;

import dongduk.cs.moaread.dto.base.BaseResponse;
import dongduk.cs.moaread.exception.status.ErrorCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    /* Custom Exception */
    @ExceptionHandler(BaseException.class)
    public BaseResponse onBaseException(BaseException exception) {
        return BaseResponse.onFailure(exception.getErrorCode(), exception.getMessage(), null);
    }

    /* Validation Exception */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<ErrorResponse> onValidationException(BindingResult result) {
        return BaseResponse.onFailure(ErrorCode.BAD_REQUEST, null, ErrorResponse.of(result));
    }
}