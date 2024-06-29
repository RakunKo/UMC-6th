package umc.mission.week7.apiPayLoad.code.DTO.store;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class toCreateStore{
        String name;
        String address;
        Float score;
    }
}
