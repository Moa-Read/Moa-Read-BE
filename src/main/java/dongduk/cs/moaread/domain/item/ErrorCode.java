package dongduk.cs.moaread.domain.item;

import lombok.Getter;

@Getter
public enum ErrorCode {
    REQUIRED_LOGIN(401, "AUTH-001", "로그인이 필요합니다."),
    ITEM_NOT_FOUND(404, "ITEM-001", "Item not found"),
    INTERNAL_SERVER_ERROR(500, "SERVER-001", "Internal server error");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
