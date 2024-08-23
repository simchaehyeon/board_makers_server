package BMproject.BMproject1.global.error;

import BMproject.BMproject1.global.error.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {

    private String message;
    private HttpStatus status;

    public ErrorResponse(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
    }

    public static ErrorResponse from(ErrorCode errorCode) {
        return null;
    }
}
