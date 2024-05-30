package umc.mission.week7.apiPayLoad.code;

import umc.mission.week7.apiPayLoad.code.DTO.reasonDTO.ErrorReasonDTO;

public interface BaseErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
