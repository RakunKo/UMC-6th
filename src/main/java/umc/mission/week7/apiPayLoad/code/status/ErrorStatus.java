package umc.mission.week7.apiPayLoad.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.mission.week7.apiPayLoad.code.BaseErrorCode;
import umc.mission.week7.apiPayLoad.code.DTO.reasonDTO.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // Member Error

    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // Article Error
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트"),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD4001", "음식 카테고리가 없습니다."),

    STORE_NAME_EMPTY(HttpStatus.NOT_FOUND, "STORE4001", "음식점 이름은 필수입니다."),
    STORE_ADDRESS_EMPTY(HttpStatus.NOT_FOUND, "STORE4002", "음식점 주소은 필수입니다."),

    REVIEW_TITLE_EMPTY(HttpStatus.NOT_FOUND, "REVIEW4001", "리뷰 본문은 필수입니다."),
    REVIEW_MEMBER_ID_EMPTY(HttpStatus.NOT_FOUND, "REVIEW4002", "사용자 ID는 필수입니다."),
    REVIEW_STORE_ID_EMPTY(HttpStatus.NOT_FOUND, "REVIEW4003", "상점 ID는 필수입니다."),
    REVIEW_SCORE_EMPTY(HttpStatus.NOT_FOUND, "REVIEW4004", "평점은 필수입니다."),

    MISSION_SPEC_EMPTY(HttpStatus.NOT_FOUND, "MISSION4001", "미션 설명은 필수입니다."),
    MISSION_DEADLINE_EMPTY(HttpStatus.NOT_FOUND, "MISSION4002", "미션 기한은 필수입니다."),
    MISSION_REWARD_EMPTY(HttpStatus.NOT_FOUND, "MISSION4003", "미션 보상은 필수입니다."),

    MEMBER_MISSION_STATUS_ERROR(HttpStatus.NOT_FOUND, "MEMBERMISSION4001", "FAIL, COMPLETE, READY, DAFALUT, PROCESS 중 하나만 선택하세요")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
