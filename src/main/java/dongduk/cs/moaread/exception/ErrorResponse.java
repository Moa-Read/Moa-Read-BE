package dongduk.cs.moaread.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private List<ErrorField> errors;

    public static ErrorResponse errorResponse(BindingResult result) {
        return new ErrorResponse(ErrorField.validationErrors(result));
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorField {
        private String field;
        private String value;
        private String message;

        public static List<ErrorField> validationErrors(BindingResult result) {
            List<ErrorField> errorFields = result.getAllErrors().stream().map(error ->
                    new ErrorField(((FieldError) error).getField(), ((FieldError) error).getRejectedValue().toString(),
                            ((FieldError) error).getDefaultMessage())).collect(Collectors.toList());

            return errorFields;
        }
    }
}