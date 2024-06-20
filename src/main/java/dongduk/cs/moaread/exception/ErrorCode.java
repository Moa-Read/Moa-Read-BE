package dongduk.cs.moaread.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    /* 요청 성공 */
    SUCCESS("2000", "SUCCESS!", HttpStatus.OK),

    /* Common Error */
    INTERNAL_SERVER_ERROR("COMMON4001", "서버 에러, 관리자에게 문의 바랍니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("COMMON4002", "잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("COMMON4003", "권한이 잘못되었습니다.", HttpStatus.UNAUTHORIZED),
    METHOD_NOT_ALLOWED("COMMON4004", "지원하지 않는 Http Method 입니다.", HttpStatus.METHOD_NOT_ALLOWED),
    FORBIDDEN("COMMON4005", "금지된 요청입니다.", HttpStatus.FORBIDDEN),
    ITEM_NOT_FOUND("COMMON4005", "발견되지 않았습니다.", HttpStatus.NOT_FOUND),
    REQUIRED_LOGIN("COMMON4006", "관리자가 아닙니다.", HttpStatus.UNAUTHORIZED);

    /* Account Error */
    

    private String code;
    private String message;
    private HttpStatus httpStatus;

    ErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}