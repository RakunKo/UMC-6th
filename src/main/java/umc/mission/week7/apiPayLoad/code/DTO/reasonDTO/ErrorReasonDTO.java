package umc.mission.week7.apiPayLoad.code.DTO.reasonDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ErrorReasonDTO {
    private String message;
    private String code;
    private boolean isSuccess;
    private HttpStatus httpStatus;

    @Builder
    public ErrorReasonDTO(String message, String code, boolean isSuccess, HttpStatus httpStatus) {
        this.message = message;
        this.code = code;
        this.isSuccess = isSuccess;
        this.httpStatus = httpStatus;
    }
}