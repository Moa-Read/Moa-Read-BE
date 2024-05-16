package dongduk.cs.moaread.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dongduk.cs.moaread.exception.status.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class BaseResponse<T> {
    @JsonProperty("isSuccess")
    private final boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    /* 요청 성공 응답 */
    public static <T> BaseResponse<T> onSuccess(T result) {
        return new BaseResponse<>(true, ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), result);
    }

    /* 요청 실패 응답 */
    public static <T> BaseResponse<T> onFailure(ErrorCode errorCode, T result) {
        return new BaseResponse<>(false, errorCode.getCode(), errorCode.getMessage(), result);
    }
}