package umc.mission.week7.apiPayLoad.exception.handler;

import umc.mission.week7.apiPayLoad.code.BaseErrorCode;
import umc.mission.week7.apiPayLoad.exception.GeneralException;

public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode code) {
        super(code);
    }
}
