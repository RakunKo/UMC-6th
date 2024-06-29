package umc.mission.week7.apiPayLoad.exception.handler;

import umc.mission.week7.apiPayLoad.code.BaseErrorCode;
import umc.mission.week7.apiPayLoad.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
